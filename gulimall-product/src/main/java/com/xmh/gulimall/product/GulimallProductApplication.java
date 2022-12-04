package com.xmh.gulimall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GulimallProductApplication {

    /**
     * @param args
     * @Cacheable 触发将数据保存到缓存中的操作
     * @CacheEvict 触发将数据从缓存删除的操作
     * @CachePut
     * @Caching 组合以上多个操作
     * @CacheConfig
     */
    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
