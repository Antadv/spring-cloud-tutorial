package com.chinastar.cloudapollo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Boot提供了@ConfigurationProperties把配置注入到bean对象中。Apollo也支持这种方式
 *
 * @author LBG - 2019/4/8
 */
@Configuration
@ConfigurationProperties(prefix = "redis.cache")
public class RedisConfig {

    private int expireSeconds;
    private int commandTimeout;

    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public void setCommandTimeout(int commandTimeout) {
        this.commandTimeout = commandTimeout;
    }

    public int getExpireSeconds() {
        return expireSeconds;
    }

    public int getCommandTimeout() {
        return commandTimeout;
    }
}
