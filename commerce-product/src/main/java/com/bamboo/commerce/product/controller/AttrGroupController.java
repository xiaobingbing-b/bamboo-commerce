package com.bamboo.commerce.product.controller;

import com.alibaba.fastjson.JSONArray;
import com.bamboo.commerce.product.entity.AttrGroupEntity;
import com.bamboo.commerce.product.service.AttrGroupService;
import com.bamboo.common.utils.PageUtils;
import com.bamboo.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 属性分组
 *
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 15:34:28
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    /**
     * 列表
     */
    @RequestMapping("/list/{categoryId}")
    public R list(@RequestParam Map<String, Object> params, @PathVariable("categoryId") Long categoryId){
        PageUtils page = attrGroupService.queryPage(params, categoryId);

        return R.ok().put("page", page);
    }

    /**
     * 根据属性分组id获取 属性
     * @param groupId
     * @return
     */
    @RequestMapping("/getAttrByGroupId/{groupId}")
    public R getAttrByGroupId(@PathVariable("groupId") Long groupId){
        JSONArray data = this.attrGroupService.getAttrByGroupId(groupId);
        return R.ok().put("data", data);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getInfoById(attrGroupId);

        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

    /**
     * 获取这个分类下没有绑定分组的 属性
     * @param groupId
     * @param catelogId
     * @return
     */
    @RequestMapping("/getNoBindAttr")
    public R getNoBindAttrByGroupCatelogId(Long groupId, Long catelogId){
        JSONArray data = this.attrGroupService.getNoBindAttrByGroupCatelogId(groupId, catelogId);
        return R.ok().put("data", data);
    }

}
