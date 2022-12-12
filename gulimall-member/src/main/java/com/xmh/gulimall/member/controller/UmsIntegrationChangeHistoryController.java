package com.xmh.gulimall.member.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xmh.gulimall.member.entity.UmsIntegrationChangeHistoryEntity;
import com.xmh.gulimall.member.service.UmsIntegrationChangeHistoryService;
import com.xmh.common.utils.PageUtils;
import com.xmh.common.utils.R;



/**
 * 积分变化历史记录
 *
 * @author fcfang
 * @email 851485863@qq.com
 * @date 2022-12-11 17:03:55
 */
@RestController
@RequestMapping("member/umsintegrationchangehistory")
public class UmsIntegrationChangeHistoryController {
    @Autowired
    private UmsIntegrationChangeHistoryService umsIntegrationChangeHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:umsintegrationchangehistory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsIntegrationChangeHistoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:umsintegrationchangehistory:info")
    public R info(@PathVariable("id") Long id){
		UmsIntegrationChangeHistoryEntity umsIntegrationChangeHistory = umsIntegrationChangeHistoryService.getById(id);

        return R.ok().put("umsIntegrationChangeHistory", umsIntegrationChangeHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:umsintegrationchangehistory:save")
    public R save(@RequestBody UmsIntegrationChangeHistoryEntity umsIntegrationChangeHistory){
		umsIntegrationChangeHistoryService.save(umsIntegrationChangeHistory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:umsintegrationchangehistory:update")
    public R update(@RequestBody UmsIntegrationChangeHistoryEntity umsIntegrationChangeHistory){
		umsIntegrationChangeHistoryService.updateById(umsIntegrationChangeHistory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:umsintegrationchangehistory:delete")
    public R delete(@RequestBody Long[] ids){
		umsIntegrationChangeHistoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
