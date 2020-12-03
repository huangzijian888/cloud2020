package com.lamdaer.springcloud.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

/**
 * @author lamdaer
 * @createTime 2020/12/3
 */
@Service
public class PaymentService {
    public String paymentInfoOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfoOk, id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }
    
    public String paymentInfoTimeout(Integer id) {
        int timeNumber = 3;
        
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfoTimeout, id:" + id + "\t" + "O(∩_∩)O哈哈~" +
                " 耗时(秒)：" + timeNumber;
    }
}
