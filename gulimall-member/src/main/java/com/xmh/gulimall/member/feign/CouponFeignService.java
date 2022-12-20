package com.xmh.gulimall.member.feign;

import com.xmh.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("gulimall-coupon")//告诉spring cloud这个接口是一个远程客户端，要调用coupon服务(nacos中找到)
public interface CouponFeignService {
    // 远程服务的url
    @RequestMapping("coupon/smscoupon/list")//注意写全优惠券类上还有映射
    public R membercoupons();//得到一个R对象

}
