package com.bamboo.commerce.order.dao;

import com.bamboo.commerce.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 17:18:55
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
