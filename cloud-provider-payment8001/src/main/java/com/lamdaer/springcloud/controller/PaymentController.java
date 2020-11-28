package com.lamdaer.springcloud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lamdaer.springcloud.entity.CommonResult;
import com.lamdaer.springcloud.entity.Payment;
import com.lamdaer.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lamdaer
 * @createTime 2020/10/28
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    
    @Value("${server.port}")
    private String serverPort;
    
    @Resource
    private DiscoveryClient discoveryClient;
    
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果:" + result);
        if (result > 0) {
            return new CommonResult(200, "数据插入成功!serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "数据插入失败");
        }
    }
    
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("插入结果:" + result);
        if (result != null) {
            return new CommonResult(200, "查询成功,serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "没有对应记录");
        }
    }
    
    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*****service:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" +
                    instance.getUri());
        }
        return this.discoveryClient;
    }
    
}
