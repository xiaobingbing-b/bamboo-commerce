package com.bamboo.commerce.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.bamboo.commerce.product.dao")
@SpringBootApplication
public class CommerceProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommerceProductApplication.class, args);
    }

}
