package com.chinastar.cloudconsumerfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

// 开启扫描 Spring cloud feign 客户端的功能
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class CloudConsumerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudConsumerFeignApplication.class, args);
	}

}
