package com.xmh.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xmh.common.utils.PageUtils;
import com.xmh.gulimall.coupon.entity.SmsSkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author fcfang
 * @email 851485863@qq.com
 * @date 2022-12-11 15:28:24
 */
public interface SmsSkuFullReductionService extends IService<SmsSkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

