package com.xmh.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xmh.common.utils.PageUtils;
import com.xmh.gulimall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author fcfang
 * @email 851485863@qq.com
 * @date 2022-12-11 17:15:33
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

