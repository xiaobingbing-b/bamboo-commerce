package com.bamboo.commerce.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bamboo.commerce.product.entity.AttrAttrgroupRelationEntity;
import com.bamboo.commerce.product.service.AttrAttrgroupRelationService;
import com.bamboo.commerce.product.service.CategoryService;
import com.bamboo.commerce.product.vo.AttrVo;
import com.bamboo.common.constant.ProductConstant;
import com.bamboo.common.utils.Constant;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bamboo.common.utils.PageUtils;
import com.bamboo.common.utils.Query;

import com.bamboo.commerce.product.dao.AttrDao;
import com.bamboo.commerce.product.entity.AttrEntity;
import com.bamboo.commerce.product.service.AttrService;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;
    
    @Autowired
    private AttrDao attrDao;

    @Autowired
    private CategoryService categoryService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        long curPage = 1;
        long limit = 10;
        if(params.get(Constant.PAGE) != null){
            curPage = Long.parseLong(params.get(Constant.PAGE).toString());
        }
        if(params.get(Constant.LIMIT) != null){
            limit = Long.parseLong((String)params.get(Constant.LIMIT));
        }
        Page<AttrVo> page = new Page<>(curPage, limit);
        page = this.attrDao.queryForPage(page, params);

        return new PageUtils(page);
    }

    @Override
    public void saveAttr(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr, attrEntity);
        this.save(attrEntity);
        //保存 属性与 属性分组关联关系
        if (null != attr.getAttrGroupId() && 0 != attr.getAttrGroupId() && StringUtils.equals(attr.getAttrType() + "", ProductConstant.ATTR_TYPE_BASE.getValue())){
            AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = new AttrAttrgroupRelationEntity();
            attrAttrgroupRelationEntity.setAttrGroupId(attr.getAttrGroupId());
            attrAttrgroupRelationEntity.setAttrId(attr.getAttrId());
            this.attrAttrgroupRelationService.save(attrAttrgroupRelationEntity);
        }
    }

    @Override
    public AttrVo getAttrVoInfoById(Long attrId) {
        AttrVo vo = this.attrDao.getAttrVoInfoById(attrId);
        //设置所属分类路径
        if (null != vo.getCatelogId()){
            vo.setCatelogPath(this.categoryService.getParentIds(vo.getCatelogId()));
        }

        return vo;
    }

    @Override
    public void updateAttr(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr, attrEntity);
        this.updateById(attrEntity);
        //修改属性与分组关联信息信息
        if (null != attr.getAttrGroupId() && 0 != attr.getAttrGroupId() && StringUtils.equals(attr.getAttrType()+"", ProductConstant.ATTR_TYPE_BASE.getValue())){
            AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = new AttrAttrgroupRelationEntity();
            attrAttrgroupRelationEntity.setAttrGroupId(attr.getAttrGroupId());
            attrAttrgroupRelationEntity.setAttrId(attr.getAttrId());
            UpdateWrapper<AttrAttrgroupRelationEntity> wrapper = new UpdateWrapper<>();
            wrapper.eq("attr_id", attrAttrgroupRelationEntity.getAttrId());
            boolean updateSuccess = this.attrAttrgroupRelationService.update(attrAttrgroupRelationEntity, wrapper);
            if (!updateSuccess){
                //属性没有分组直接添加分组
                this.attrAttrgroupRelationService.save(attrAttrgroupRelationEntity);
            }
        }
    }

    @Override
    public JSONArray getAttrByGroupId(Long groupId) {
        List<Map<String, Object>> maps = this.attrDao.getAttrByGroupId(groupId);
        return JSONArray.parseArray(JSON.toJSONString(maps));
    }

}