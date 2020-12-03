package com.lamdaer.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lamdaer.springcloud.service.PaymentHystrixService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lamdaer
 * @createTime 2020/12/4
 */
@RestController
@Slf4j
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;
    
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    String paymentInfoOk(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfoOk(id);
        return result;
    }
    
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    String paymentInfoTimeout(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfoTimeout(id);
        return result;
    }
}
