package com.bamboo.commerce.product.service;

import com.alibaba.fastjson.JSONArray;
import com.bamboo.commerce.product.vo.AttrVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bamboo.common.utils.PageUtils;
import com.bamboo.commerce.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 15:09:54
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    /**
     * 根据属性id 获取 属性详情信息
     * @param attrId
     * @return
     */
    AttrVo getAttrVoInfoById(Long attrId);

    void updateAttr(AttrVo attr);

    /**
     * 根据属性分组id
     * @param groupId
     * @return
     */
    JSONArray getAttrByGroupId(Long groupId);
}

