package com.xmh.gulimall.product.dao;

import com.xmh.gulimall.product.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 * 
 * @author fcfang
 * @email 851485863@qq.com
 * @date 2022-12-11 12:22:15
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {
	
}
