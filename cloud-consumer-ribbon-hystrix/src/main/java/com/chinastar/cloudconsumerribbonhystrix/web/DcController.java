package com.chinastar.cloudconsumerribbonhystrix.web;

import com.chinastar.cloudconsumerribbonhystrix.service.ConsumerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述
 *
 * @author LBG - 2019/4/8
 */
@RestController
public class DcController {

    @Resource
    private ConsumerService consumerService;

    @GetMapping("/consumer")
    public String dc() throws InterruptedException {
        return consumerService.consumer();
    }
}
