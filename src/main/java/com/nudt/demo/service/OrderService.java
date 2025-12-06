package com.nudt.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private CustomerService customerService;

    // 构造函数注入：需要 CustomerService
//    public OrderService(CustomerService customerService) {
//        this.customerService = customerService;
//        System.out.println("OrderService: 正在构造，需要 CustomerService");
//    }
    // ... 其他方法

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
