package com.xmh.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xmh.common.utils.PageUtils;
import com.xmh.gulimall.coupon.entity.SmsMemberPriceEntity;

import java.util.Map;

/**
 * 商品会员价格
 *
 * @author fcfang
 * @email 851485863@qq.com
 * @date 2022-12-11 15:28:24
 */
public interface SmsMemberPriceService extends IService<SmsMemberPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

