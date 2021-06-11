package com.bamboo.commerce.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bamboo.common.utils.PageUtils;
import com.bamboo.common.utils.Query;

import com.bamboo.commerce.product.dao.CategoryDao;
import com.bamboo.commerce.product.entity.CategoryEntity;
import com.bamboo.commerce.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void deleteByIds(List<Long> asList) {
        this.baseMapper.deleteBatchIds(asList);
    }

    /**
     * 获取这个子组所有的父id 并包含当前id
     * @param childrenId
     * @return
     */
    @Override
    public Long[] getParentIds(Long childrenId) {
        List<Long> list = new ArrayList<>();
        this.parentIds(childrenId, list);
        return list.toArray(new Long[list.size()]);
    }

    private List<Long> parentIds(Long childrenId, List<Long> list){
        CategoryEntity entity = this.getById(childrenId);
        if (entity != null && entity.getParentCid() != 0){
            this.parentIds(entity.getParentCid(), list);
        }
        list.add(childrenId);
        return list;
    }

    @Override
    public List<CategoryEntity> list() {
        List<CategoryEntity> entities = this.baseMapper.selectList(null);
        return entities.stream().filter(entity -> {
            return entity.getCatLevel() == 1;
        }).map(entity -> {
            entity.setList(this.getChildEntity(entity, entities));
            return entity;
        }).sorted((e1, e2) -> {
            return e1.getSort() - e2.getSort();
        }).collect(Collectors.toList());
    }

    private List<CategoryEntity> getChildEntity(CategoryEntity entity, List<CategoryEntity> entities) {
        return entities.stream().filter(child -> {
            return child.getParentCid().equals(entity.getCatId());
        }).map(child -> {
            child.setList(this.getChildEntity(child, entities));
            return child;
        }).sorted((e1, e2) -> {
            return e1.getSort() - e2.getSort();
        }).collect(Collectors.toList());
    }
}