package com.chinastar.cloudservice.web;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 描述
 *
 * @author LBG - 2019/4/8
 */
@RestController
public class DcController {

	@Resource
	private DiscoveryClient discoveryClient;

	@GetMapping("/dc")
	public String dc() {
		String services = "Services: " + discoveryClient.getServices();
		System.out.println(services);
		return services;
	}

	@GetMapping("/hello")
	public String hello(HttpServletRequest request) {
		System.out.println(request.getParameter("color"));
		return "hello " + DateFormatUtils.format(new Date(), "mm:ss");
	}
}
