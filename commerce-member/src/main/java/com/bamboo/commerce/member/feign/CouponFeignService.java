package com.bamboo.commerce.member.feign;

import com.bamboo.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @program: bamboo-commerce
 * @description: 调用优惠服务
 * @author: Bing.Tang
 * @create: 2021-03-16 15:04
 **/
@FeignClient(name = "commerce-coupon")
public interface CouponFeignService {

    @RequestMapping("coupon/coupon/list")
    public R list(@RequestParam Map<String, Object> params);

}
