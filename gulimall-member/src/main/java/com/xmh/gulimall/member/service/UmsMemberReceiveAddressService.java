package com.xmh.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xmh.common.utils.PageUtils;
import com.xmh.gulimall.member.entity.UmsMemberReceiveAddressEntity;

import java.util.Map;

/**
 * 会员收货地址
 *
 * @author fcfang
 * @email 851485863@qq.com
 * @date 2022-12-11 17:03:55
 */
public interface UmsMemberReceiveAddressService extends IService<UmsMemberReceiveAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

