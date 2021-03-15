package com.bamboo.commerce.order.dao;

import com.bamboo.commerce.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 17:18:55
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
