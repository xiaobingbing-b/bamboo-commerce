package com.bamboo.commerce.product.dao;

import com.bamboo.commerce.product.entity.AttrEntity;
import com.bamboo.commerce.product.vo.AttrVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 * 
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 15:09:54
 */
@Mapper
public interface AttrDao extends BaseMapper<AttrEntity> {

    Page<AttrVo> queryForPage(Page<AttrVo> page, @Param("params") Map<String, Object> params);

    AttrVo getAttrVoInfoById(@Param("attrId") Long attrId);

    List<Map<String, Object>> getAttrByGroupId(@Param("groupId") Long groupId);

    List<Map<String, Object>> getNoBindAttr(@Param("params") Map<Object, Object> params);
}
