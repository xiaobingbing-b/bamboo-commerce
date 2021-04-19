package com.bamboo.commerce.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bamboo.common.utils.PageUtils;
import com.bamboo.commerce.product.entity.AttrGroupEntity;

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
}

