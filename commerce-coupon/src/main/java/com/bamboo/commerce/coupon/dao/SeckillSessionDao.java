package com.bamboo.commerce.coupon.dao;

import com.bamboo.commerce.coupon.entity.SeckillSessionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀活动场次
 * 
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 17:08:54
 */
@Mapper
public interface SeckillSessionDao extends BaseMapper<SeckillSessionEntity> {
	
}
