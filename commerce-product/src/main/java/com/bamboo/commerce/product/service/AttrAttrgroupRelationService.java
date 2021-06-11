package com.bamboo.commerce.product.service;

import com.bamboo.commerce.product.vo.AttrVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bamboo.common.utils.PageUtils;
import com.bamboo.commerce.product.entity.AttrAttrgroupRelationEntity;

import java.util.List;
import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 15:09:54
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据分组id查询属性
     * @param params
     * @return
     */
    List<AttrVo> queryByGroupId(Map<String, Object> params);

    /**
     * 一次性保存多个
     * @param params
     */
    void saveForBatch(Map<String, Object> params);
}

