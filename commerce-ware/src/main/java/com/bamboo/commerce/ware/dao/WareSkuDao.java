package com.bamboo.commerce.ware.dao;

import com.bamboo.commerce.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 17:29:15
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
