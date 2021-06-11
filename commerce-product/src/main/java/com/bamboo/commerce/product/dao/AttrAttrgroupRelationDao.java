package com.bamboo.commerce.product.dao;

import com.bamboo.commerce.product.entity.AttrAttrgroupRelationEntity;
import com.bamboo.commerce.product.vo.AttrVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 属性&属性分组关联
 * 
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 15:09:54
 */
@Mapper
public interface AttrAttrgroupRelationDao extends BaseMapper<AttrAttrgroupRelationEntity> {

    List<AttrVo> queryByGroupId(@Param("groupId") String groupId);
}
