package com.bamboo.commerce.product.service.impl;

import com.bamboo.commerce.product.entity.AttrAttrgroupRelationEntity;
import com.bamboo.commerce.product.service.AttrAttrgroupRelationService;
import com.bamboo.commerce.product.vo.AttrVo;
import com.bamboo.common.utils.Constant;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
//        QueryWrapper<AttrEntity> wrapper = new QueryWrapper<>();
//        Long catelogId = (Long)params.get("catelogId");
//        String key = (String) params.get("key");
//        if (null != catelogId && 0 != catelogId){
//            wrapper.eq("catelog_Id", catelogId);
//        }
//        if (StringUtils.isNotBlank(key)){
//            wrapper.or((obj) -> {
//                obj.eq("attr_id", key).or().like("attr_name", key);
//            });
//        }
//        IPage<AttrEntity> page = this.page(
//                new Query<AttrEntity>().getPage(params),
//                wrapper
//        );
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
        if (null != attr.getAttrGroupId() && 0 != attr.getAttrGroupId()){
            AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = new AttrAttrgroupRelationEntity();
            attrAttrgroupRelationEntity.setAttrGroupId(attr.getAttrGroupId());
            attrAttrgroupRelationEntity.setAttrId(attr.getAttrId());
            this.attrAttrgroupRelationService.save(attrAttrgroupRelationEntity);
        }
    }

}