package com.chinastar.cloudapollo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 描述
 *
 * @author LBG - 2019/4/8
 */
@Configuration
public class JavaConfigBean {

    @Value("${timeout:20}")
    private int timeout;

    public int getTimeout() {
        return timeout;
    }
}
