package com.bamboo.commerce.tripartite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CommerceTripartiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommerceTripartiteApplication.class, args);
	}

}
