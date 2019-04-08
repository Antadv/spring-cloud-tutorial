package com.chinastar.cloudconsumerfeign.web;

import com.chinastar.cloudconsumerfeign.client.DcClient;
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
    private DcClient dcClient;

    @GetMapping("/consumer")
    public String dc() {
        return dcClient.consumer();
    }
}
