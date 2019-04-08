package com.chinastar.cloudapollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableApolloConfig
@SpringBootApplication
public class CloudApolloApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudApolloApplication.class, args);
	}

}
