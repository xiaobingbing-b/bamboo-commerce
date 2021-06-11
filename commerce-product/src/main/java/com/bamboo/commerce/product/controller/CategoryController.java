package com.bamboo.commerce.product.controller;

import com.bamboo.commerce.product.entity.CategoryEntity;
import com.bamboo.commerce.product.service.CategoryService;
import com.bamboo.common.utils.PageUtils;
import com.bamboo.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 商品三级分类
 *
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 15:34:28
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list/tree")
    public R list(Map<String, Object> params){
        List<CategoryEntity> list = this.categoryService.list();
        return R.ok().put("list", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CategoryEntity category){
        categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/updateList")
    public R updateList(@RequestBody CategoryEntity[] categorys){

        categoryService.updateBatchById(Arrays.asList(categorys));

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] catIds){
		categoryService.deleteByIds(Arrays.asList(catIds));
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteById")
    public R deleteById(@RequestBody Long id){
		categoryService.removeById(id);
        return R.ok();
    }

}
