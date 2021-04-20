package com.bamboo.commerce.product.service.impl;

import com.bamboo.commerce.product.entity.CategoryBrandRelationEntity;
import com.bamboo.commerce.product.service.CategoryBrandRelationService;
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

import com.bamboo.commerce.product.dao.BrandDao;
import com.bamboo.commerce.product.entity.BrandEntity;
import com.bamboo.commerce.product.service.BrandService;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    private CategoryBrandRelationService relationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        QueryWrapper<BrandEntity> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(key)){
            wrapper.like("brand_id", key).or().like("name", key).or().like("descript", key);
        }
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

    @Override
    public void updateDetail(BrandEntity brand) {
        this.updateById(brand);
        //修改 分类-品牌关联信息
        if (StringUtils.isNotBlank(brand.getName())){
            CategoryBrandRelationEntity relationEntity = new CategoryBrandRelationEntity();
            relationEntity.setBrandId(brand.getBrandId());
            relationEntity.setBrandName(brand.getName());
            this.relationService.updateByOtherId(relationEntity);
        }

    }

}