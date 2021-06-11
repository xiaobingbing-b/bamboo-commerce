package com.bamboo.commerce.product.vo;

import lombok.Data;

@Data
public class AttrVo {

    /**
     * 关联id
     */
    private Long relationId;


    /**
     * 可选值列表[用逗号分隔]
     */
    private String valueSelect;

    /**
     * 属性名
     */
    private String attrName;

    private Long attrId;
}
