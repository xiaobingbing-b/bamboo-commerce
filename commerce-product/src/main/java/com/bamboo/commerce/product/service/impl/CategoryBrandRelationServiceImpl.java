package com.bamboo.commerce.product.service.impl;

import com.bamboo.commerce.product.entity.CategoryEntity;
import com.bamboo.commerce.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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

    /**
     * 品牌名称 或者 分组名称修改了， 要同步修改 关联表，
     * 目的 减少表关联
     * @param relationEntity
     */
    @Override
    public void updateByOtherId(CategoryBrandRelationEntity relationEntity) {
        UpdateWrapper<CategoryBrandRelationEntity> updateWrapper = new UpdateWrapper<CategoryBrandRelationEntity>();
        if (null != relationEntity.getBrandId() && 0 != relationEntity.getBrandId()){
            updateWrapper.eq("brand_id", relationEntity.getBrandId());
        } else if (null != relationEntity.getCatelogId() && 0 != relationEntity.getCatelogId()){
            updateWrapper.eq("catelog_id", relationEntity.getCatelogId());
        }
        this.update(relationEntity, updateWrapper);
    }

}