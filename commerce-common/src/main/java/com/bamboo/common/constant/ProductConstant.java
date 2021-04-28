package com.bamboo.common.constant;

import lombok.Data;

/**
 * @program: bamboo-commerce
 * @description:
 * @author: Bing.Tang
 * @create: 2021-04-23 16:08
 **/
public enum  ProductConstant {
    ATTR_TYPE_BASE("1", "基本属性"),
    ATTR_TYPE_SALE("0", "销售属性");

    private String value;

    private String msg;

    ProductConstant(String value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
