package com.somelogs.cloudservice2.controller;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 描述
 *
 * @author LBG - 3/23/21
 */
@RestController
public class DemoController {

	@GetMapping("/hello")
	public String hello(HttpServletRequest request) {
		System.out.println(request.getParameter("color"));
		return "hello2 " + DateFormatUtils.format(new Date(), "mm:ss");
	}
}
