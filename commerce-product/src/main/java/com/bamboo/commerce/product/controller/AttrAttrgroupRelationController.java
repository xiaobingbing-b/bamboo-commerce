package com.bamboo.commerce.product.controller;

import com.bamboo.commerce.product.entity.AttrAttrgroupRelationEntity;
import com.bamboo.commerce.product.service.AttrAttrgroupRelationService;
import com.bamboo.commerce.product.vo.AttrVo;
import com.bamboo.common.utils.PageUtils;
import com.bamboo.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 属性&属性分组关联
 *
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 15:34:28
 */
@RestController
@RequestMapping("product/attrattrgrouprelation")
public class AttrAttrgroupRelationController {
    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrAttrgroupRelationService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/queryByGroupId")
    public R queryByGroupId(@RequestParam Map<String, Object> params){
        List<AttrVo> vos = attrAttrgroupRelationService.queryByGroupId(params);
        List<Long> attrIds = vos.stream().map(vo -> vo.getAttrId()).filter(id -> null != id).collect(Collectors.toList());
        return R.ok().put("data", vos).put("attrIds", attrIds);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		AttrAttrgroupRelationEntity attrAttrgroupRelation = attrAttrgroupRelationService.getById(id);

        return R.ok().put("attrAttrgroupRelation", attrAttrgroupRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrAttrgroupRelationEntity attrAttrgroupRelation){
		attrAttrgroupRelationService.save(attrAttrgroupRelation);

        return R.ok();
    }

    /**
     * 一次性保存多个
     * @param params
     * @return
     */
    @PostMapping("/saveForBatch")
    public R saveForBatch(@RequestBody Map<String, Object> params){
        this.attrAttrgroupRelationService.saveForBatch(params);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrAttrgroupRelationEntity attrAttrgroupRelation){
		attrAttrgroupRelationService.updateById(attrAttrgroupRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		attrAttrgroupRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
