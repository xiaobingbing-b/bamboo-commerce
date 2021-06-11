package com.bamboo.commerce.product.service.impl;

import org.apache.commons.lang3.StringUtils;
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

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 获取基本属性
     * 有bindAttrIds 要屏蔽掉这些属性
     *
     * @param params
     * @return
     */
    @Override
    public List<AttrEntity> getBaseAttr(Map<String, Object> params) {
        QueryWrapper<AttrEntity> queryWrapper = new QueryWrapper<>();
        List<Integer> ids = (List<Integer>) params.get("attrIds");
        queryWrapper.eq("attr_type", "1");
        if (null != ids){
            queryWrapper.and(obj -> {
                obj.notIn("attr_id", ids);
            });
        }
        return this.list(queryWrapper);
    }

}