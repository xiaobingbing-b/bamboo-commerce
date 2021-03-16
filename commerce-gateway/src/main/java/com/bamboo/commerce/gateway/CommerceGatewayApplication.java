package com.bamboo.commerce.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CommerceGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommerceGatewayApplication.class, args);
    }

}
