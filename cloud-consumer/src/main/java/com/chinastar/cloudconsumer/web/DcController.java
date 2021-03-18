package com.chinastar.cloudconsumer.web;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 消费者
 * <p>
 * LoadBalancerClient 获取服务提供方
 * RestTemplate 发起接口调用
 *
 * @author LBG - 2019/4/8
 */
@RestController
public class DcController {

	@Resource
	LoadBalancerClient loadBalancerClient;

	@Resource
	private RestTemplate restTemplate;

	@GetMapping("/consumer")
	public String dc() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-service");
		System.out.println(serviceInstance);
		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
		System.out.println(url);
		return restTemplate.getForObject(url, String.class);
	}
}
