package com.lamdaer.springcloud.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lamdaer.springcloud.dao.PaymentDao;
import com.lamdaer.springcloud.entity.Payment;
import com.lamdaer.springcloud.service.PaymentService;

/**
 * @author lamdaer
 * @createTime 2020/10/28
 */
@Service
public class PaymentServiceImpl  implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }
    
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
