package com.bamboo.commerce.coupon.dao;

import com.bamboo.commerce.coupon.entity.CouponSpuRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券与产品关联
 * 
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 17:08:54
 */
@Mapper
public interface CouponSpuRelationDao extends BaseMapper<CouponSpuRelationEntity> {
	
}
