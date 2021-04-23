package com.bamboo.commerce.product.vo;

import com.bamboo.commerce.product.entity.AttrEntity;
import lombok.Data;

/**
 * @program: bamboo-commerce
 * @description:
 * @author: Bing.Tang
 * @create: 2021-04-20 16:11
 **/
@Data
public class AttrVo extends AttrEntity {

    private Long attrGroupId;

    private String catelogName;

    private String attrGroupName;

    private Long[] catelogPath;
}
