package com.bamboo.commerce.product.controller;

import com.bamboo.commerce.product.entity.AttrEntity;
import com.bamboo.commerce.product.service.AttrService;
import com.bamboo.commerce.product.vo.AttrVo;
import com.bamboo.common.utils.PageUtils;
import com.bamboo.common.utils.R;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 商品属性
 *
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 15:34:28
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    /**
     * 列表
     */
    @RequestMapping("/{attrType}/list")
    public R list(@RequestParam Map<String, Object> params, @PathVariable("attrType") String attrType){
        attrType = StringUtils.equals(attrType, "sale") ? "0" : "1";
        params.put("attrType", attrType);
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    public R info(@PathVariable("attrId") Long attrId){
		AttrVo vo = this.attrService.getAttrVoInfoById(attrId);

        return R.ok().put("attr", vo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrVo attr){
		attrService.saveAttr(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrVo attr){
		attrService.updateAttr(attr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
