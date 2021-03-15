package com.bamboo.commerce.order.dao;

import com.bamboo.commerce.order.entity.PaymentInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 * 
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 17:18:54
 */
@Mapper
public interface PaymentInfoDao extends BaseMapper<PaymentInfoEntity> {
	
}
