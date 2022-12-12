package com.xmh.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xmh.common.utils.PageUtils;
import com.xmh.gulimall.member.entity.UmsMemberLoginLogEntity;

import java.util.Map;

/**
 * 会员登录记录
 *
 * @author fcfang
 * @email 851485863@qq.com
 * @date 2022-12-11 17:03:55
 */
public interface UmsMemberLoginLogService extends IService<UmsMemberLoginLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

