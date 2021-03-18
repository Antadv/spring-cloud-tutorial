package com.chinastar.cloudconsumerribbonhystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 描述
 *
 * @author LBG - 2019/4/8
 */
@Service
public class ConsumerService {

	@Resource
	RestTemplate restTemplate;

	/**
	 * 服务降级
	 * <p>
	 * HystrixCommand 讲当前方法包装成了 Hystrix 命令
	 * 以来隔离、服务降级在使用时都是一体化实现的
	 */
	@HystrixCommand(fallbackMethod = "fallback")
	public String consumer() throws InterruptedException {
		TimeUnit.SECONDS.sleep(5L);
		return restTemplate.getForObject("http://eureka-service/dc", String.class);
	}

	private String fallback() {
		return "fallback";
	}
}
