package com.chinastar.cloudconsumerribbon.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 消费者
 *
 * @author LBG - 2019/4/8
 */
@RestController
public class DcController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String dc() {
        /*
            这里URL有些特殊，并没有ip和端口号，而是采用服务名的方式组成。
            Spring cloud Ribbon 有个拦截器，在实际进行调用的时候，能够用真实的服务提供方的
            IP和端口号替换这里的服务名，从而完成服务接口的调用
         */
        return restTemplate.getForObject("http://eureka-service/dc", String.class);
    }
}
