package com.lamdaer.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lamdaer
 * @createTime 2020/11/28
 */
@RestController
@Slf4j
public class OrderZkController {
    public static final String INVOKE_URL = "http://cloud-payment-service";
    
    @Resource
    private RestTemplate restTemplate;
    
    @GetMapping("/consumer/payment/zk")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return result;
    }
}
