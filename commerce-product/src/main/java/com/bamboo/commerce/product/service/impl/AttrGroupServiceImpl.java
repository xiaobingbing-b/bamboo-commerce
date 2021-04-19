package com.bamboo.commerce.product.service.impl;

import com.bamboo.commerce.product.service.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bamboo.common.utils.PageUtils;
import com.bamboo.common.utils.Query;

import com.bamboo.commerce.product.dao.AttrGroupDao;
import com.bamboo.commerce.product.entity.AttrGroupEntity;
import com.bamboo.commerce.product.service.AttrGroupService;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    private CategoryService categoryService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long categoryId) {
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<>();
        if (categoryId != 0){
            wrapper.eq("catelog_id", categoryId);
        }
        String key = (String) params.get("key");
        if (StringUtils.isNoneBlank(key)){
            wrapper.and((obj) -> {
                obj.eq("attr_group_id", key).or().like("attr_group_name", key).like("descript", key);
            });
        }
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                wrapper
        );
        return new PageUtils(page);
    }

    @Override
    public AttrGroupEntity getInfoById(Long attrGroupId) {
        AttrGroupEntity entity = this.getById(attrGroupId);
        entity.setCatelogIds(this.categoryService.getParentIds(entity.getCatelogId()));
        return entity;
    }

}