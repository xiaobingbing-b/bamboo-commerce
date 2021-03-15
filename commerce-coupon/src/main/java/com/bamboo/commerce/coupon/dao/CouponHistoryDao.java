package com.bamboo.commerce.coupon.dao;

import com.bamboo.commerce.coupon.entity.CouponHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 * 
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 17:08:55
 */
@Mapper
public interface CouponHistoryDao extends BaseMapper<CouponHistoryEntity> {
	
}
