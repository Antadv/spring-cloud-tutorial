package com.chinastar.cloudapollo;

import com.chinastar.cloudapollo.config.RedisConfig;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableApolloConfig
@SpringBootApplication
public class CloudApolloApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudApolloApplication.class, args);
	}

	@Bean
	public RedisConfig sampleRedisConfig() {
		return new RedisConfig();
	}
}
