package com.bamboo.commerce.product.service;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bamboo.common.utils.PageUtils;
import com.bamboo.commerce.product.entity.AttrGroupEntity;

import java.awt.*;
import java.util.Map;

/**
 * 属性分组
 *
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 15:09:54
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, Long categoryId);

    AttrGroupEntity getInfoById(Long attrGroupId);

    /**
     * 根据属性分组id
     * @param groupId
     * @return
     */
    JSONArray getAttrByGroupId(Long groupId);
}

