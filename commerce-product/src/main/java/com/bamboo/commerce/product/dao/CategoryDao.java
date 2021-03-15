package com.bamboo.commerce.product.dao;

import com.bamboo.commerce.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 15:09:54
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
