package com.xmh.gulimall.order.dao;

import com.xmh.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author fcfang
 * @email 851485863@qq.com
 * @date 2022-12-11 17:15:33
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
