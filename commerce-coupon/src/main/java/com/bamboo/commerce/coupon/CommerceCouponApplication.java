package com.bamboo.commerce.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan(value = "com.bamboo.commerce.coupon.dao")
@EnableDiscoveryClient
@EnableFeignClients
public class CommerceCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommerceCouponApplication.class, args);
    }

}
