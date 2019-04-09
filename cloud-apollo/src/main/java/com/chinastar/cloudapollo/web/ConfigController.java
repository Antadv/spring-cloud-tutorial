package com.chinastar.cloudapollo.web;

import com.chinastar.cloudapollo.config.JavaConfigBean;
import com.chinastar.cloudapollo.config.RedisConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述
 *
 * @author LBG - 2019/4/8
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Resource
    private JavaConfigBean configBean;
    @Resource
    private RedisConfig redisConfig;


    @GetMapping("/test")
    public String test() {
        return "hello apollo";
    }

    @GetMapping("/timeout")
    public String timeout() {
        return "timeout：" + configBean.getTimeout();
    }

    @GetMapping("/redis")
    public String redisConfig() {
        return redisConfig.getExpireSeconds() + ", " + redisConfig.getCommandTimeout();
    }
}
