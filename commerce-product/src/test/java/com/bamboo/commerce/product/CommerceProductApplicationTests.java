package com.bamboo.commerce.product;

import com.bamboo.commerce.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CommerceProductApplicationTests {

    @Autowired
    private BrandService brandService;

    @Test
    void contextLoads() {
        System.out.println(brandService.getById("1"));
    }

}
