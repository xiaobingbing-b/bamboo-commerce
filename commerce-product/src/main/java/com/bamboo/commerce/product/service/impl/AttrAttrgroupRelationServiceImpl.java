package com.bamboo.commerce.product.service.impl;

import com.bamboo.commerce.product.vo.AttrVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bamboo.common.utils.PageUtils;
import com.bamboo.common.utils.Query;

import com.bamboo.commerce.product.dao.AttrAttrgroupRelationDao;
import com.bamboo.commerce.product.entity.AttrAttrgroupRelationEntity;
import com.bamboo.commerce.product.service.AttrAttrgroupRelationService;


@Service("attrAttrgroupRelationService")
public class AttrAttrgroupRelationServiceImpl extends ServiceImpl<AttrAttrgroupRelationDao, AttrAttrgroupRelationEntity> implements AttrAttrgroupRelationService {

    @Autowired
    private AttrAttrgroupRelationDao relationDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String groupId = (String) params.get("groupId");
        QueryWrapper<AttrAttrgroupRelationEntity> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(groupId)){
            wrapper.eq("attr_group_id", groupId);
        }
        IPage<AttrAttrgroupRelationEntity> page = this.page(
                new Query<AttrAttrgroupRelationEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

    @Override
    public List<AttrVo> queryByGroupId(Map<String, Object> params) {
        String groupId = (String) params.get("groupId");
        return this.relationDao.queryByGroupId(groupId);
    }

    /**
     * 一次性保存多个
     *
     * @param params
     */
    @Override
    public void saveForBatch(Map<String, Object> params) {
        Integer groupId = (Integer) params.get("groupId");
        List<Integer> attrIds = (List<Integer>) params.get("attrIds");
        List<AttrAttrgroupRelationEntity> entityList = new ArrayList<>();
        attrIds.stream().forEach(attrId -> {
            AttrAttrgroupRelationEntity entity = new AttrAttrgroupRelationEntity();
            entity.setAttrGroupId(groupId.longValue());
            entity.setAttrId(Long.valueOf(attrId));
            entityList.add(entity);
        });
        this.saveBatch(entityList);
    }

}