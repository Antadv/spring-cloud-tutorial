package com.somelogs.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述
 *
 * @author LBG - 3/22/21
 */
@RestController
public class DemoController {

	@GetMapping("/test")
	public String test() {
		return "test";
	}

	@GetMapping("/test2")
	public String test2() {
		return "test2";
	}
}
