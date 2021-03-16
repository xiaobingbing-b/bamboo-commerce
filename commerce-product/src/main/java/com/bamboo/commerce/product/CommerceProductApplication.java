package com.bamboo.commerce.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan(value = "com.bamboo.commerce.product.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class CommerceProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommerceProductApplication.class, args);
    }

}
