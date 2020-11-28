package com.lamdaer.springcloud.service;

import org.apache.ibatis.annotations.Param;

import com.lamdaer.springcloud.entity.Payment;

/**
 * @author lamdaer
 * @createTime 2020/10/28
 */
public interface PaymentService {
    /**
     * 创建订单
     * @param payment
     * @return
     */
    int create(Payment payment);
    
    /**
     * 通过 id 查询订单
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
