package com.xmh.gulimall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xmh.gulimall.coupon.entity.SmsCouponEntity;
import com.xmh.gulimall.coupon.service.SmsCouponService;
import com.xmh.common.utils.PageUtils;
import com.xmh.common.utils.R;


/**
 * 优惠券信息
 *
 * @author fcfang
 * @email 851485863@qq.com
 * @date 2022-12-11 15:28:24
 */
@RestController
@RequestMapping("coupon/smscoupon")
public class SmsCouponController {
    @Autowired
    private SmsCouponService smsCouponService;
    @Value("${server.port}")
    private int port;
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:smscoupon:list")
    public R list(@RequestParam Map<String, Object> params) {
        return R.ok(String.valueOf(port));
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:smscoupon:info")
    public R info(@PathVariable("id") Long id) {
        SmsCouponEntity smsCoupon = smsCouponService.getById(id);

        return R.ok().put("smsCoupon", smsCoupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:smscoupon:save")
    public R save(@RequestBody SmsCouponEntity smsCoupon) {
        smsCouponService.save(smsCoupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:smscoupon:update")
    public R update(@RequestBody SmsCouponEntity smsCoupon) {
        smsCouponService.updateById(smsCoupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:smscoupon:delete")
    public R delete(@RequestBody Long[] ids) {
        smsCouponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
