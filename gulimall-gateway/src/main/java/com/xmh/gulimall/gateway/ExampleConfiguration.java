package com.xmh.gulimall.gateway;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StreamUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;

@Slf4j
@Configuration
public class ExampleConfiguration {
    private final ObjectMapper mapper = new ObjectMapper();
    private final DataBufferFactory dataBufferFactory = new NettyDataBufferFactory(ByteBufAllocator.DEFAULT);
    @Bean
    @Order(-1)
    public GlobalFilter a() {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String path = request.getPath().pathWithinApplication().value();
            HttpMethod method = request.getMethod();
            StringBuilder builder = new StringBuilder();
            URI targetUri = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR);
            if (HttpMethod.GET.equals(method)) {
                MultiValueMap<String, String> queryParams = request.getQueryParams();
                try {
                    builder.append(mapper.writeValueAsString(queryParams));
                } catch (JsonProcessingException e) {
                    log.error(e.getMessage(), e);
                }
            } else if (HttpMethod.POST.equals(method)) {
                Flux<DataBuffer> body = request.getBody();
                ServerHttpRequest serverHttpRequest = request.mutate().uri(request.getURI()).build();
                body.subscribe(dataBuffer -> {
                    InputStream inputStream = dataBuffer.asInputStream();
                    try {
                        builder.append(StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8));
                    } catch (IOException e) {
                        log.error(e.getMessage(), e);
                    }
                });
                // ???????????????,??????????????????????????????????????????
                request = new ServerHttpRequestDecorator(serverHttpRequest) {
                    @Override
                    public Flux<DataBuffer> getBody() {
                        return Flux.just(dataBufferFactory.wrap(builder.toString().getBytes(StandardCharsets.UTF_8)));
                    }
                };
            }
            InetSocketAddress remoteAddress = request.getRemoteAddress();
            return chain.filter(exchange.mutate().request(request).build()).then(Mono.fromRunnable(() -> {
                ServerHttpResponse response = exchange.getResponse();
                HttpStatus statusCode = response.getStatusCode();
                log.info("????????????:{},??????IP??????:{},????????????:{},????????????:{},??????URI:{},?????????:{}",
                    path, remoteAddress, method, builder.toString(), targetUri, statusCode);
            }));
        };
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(r -> r.path("/order/**")
                .filters(f ->
                    f.addResponseHeader("X-TestHeader", "foobar")
                )
                .uri("lb://gulimall-order")
            )
            .build();
    }
}
