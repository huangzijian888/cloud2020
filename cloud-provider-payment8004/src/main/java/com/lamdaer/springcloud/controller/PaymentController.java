package com.lamdaer.springcloud.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lamdaer
 * @createTime 2020/11/28
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    
    @RequestMapping("/payment/zk")
    public String paymentZk() {
        return "SpringCloud with Zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
