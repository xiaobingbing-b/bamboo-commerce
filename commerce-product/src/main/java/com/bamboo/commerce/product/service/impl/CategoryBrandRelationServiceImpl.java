package com.bamboo.commerce.product.service.impl;

import com.bamboo.commerce.product.entity.CategoryEntity;
import com.bamboo.commerce.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bamboo.common.utils.PageUtils;
import com.bamboo.common.utils.Query;

import com.bamboo.commerce.product.dao.CategoryBrandRelationDao;
import com.bamboo.commerce.product.entity.CategoryBrandRelationEntity;
import com.bamboo.commerce.product.service.CategoryBrandRelationService;


@Service("categoryBrandRelationService")
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationDao, CategoryBrandRelationEntity> implements CategoryBrandRelationService {

    @Autowired
    private CategoryService categoryService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String brandId = (String) params.get("brandId");
        QueryWrapper<CategoryBrandRelationEntity> wrapper = new QueryWrapper<>();
        if (null != brandId && brandId != "0"){
            wrapper.eq("brand_id", brandId);
        }
        IPage<CategoryBrandRelationEntity> page = this.page(
                new Query<CategoryBrandRelationEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

    @Override
    public void saveEntity(CategoryBrandRelationEntity categoryBrandRelation) {
        CategoryEntity categoryEntity = this.categoryService.getById(categoryBrandRelation.getCatelogId());
        if (null != categoryEntity){
            categoryBrandRelation.setCatelogName(categoryEntity.getName());
        }
        this.save(categoryBrandRelation);
    }

}