package com.chinastar.cloudconsumerfeign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 描述
 *
 * @author LBG - 2019/4/8
 */
@FeignClient("eureka-service")
public interface DcClient {

    @GetMapping("/dc")
    String consumer();
}
