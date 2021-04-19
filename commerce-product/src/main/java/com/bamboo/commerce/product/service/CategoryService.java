package com.bamboo.commerce.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bamboo.common.utils.PageUtils;
import com.bamboo.commerce.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 15:09:54
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void deleteByIds(List<Long> asList);

    /**
     * 获取这个子组所有的父id 并包含当前id
     * @param childrenId
     * @return
     */
    Long[] getParentIds(Long childrenId);
}

