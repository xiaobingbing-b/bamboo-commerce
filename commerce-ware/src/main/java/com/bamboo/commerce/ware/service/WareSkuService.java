package com.bamboo.commerce.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bamboo.common.utils.PageUtils;
import com.bamboo.commerce.ware.entity.WareSkuEntity;

import java.util.Map;

/**
 * εεεΊε­
 *
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 17:29:15
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

