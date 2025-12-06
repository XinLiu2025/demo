package com.nudt.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private OrderService orderService;

//    public CustomerService(OrderService orderService) {
//        this.orderService = orderService;
//        System.out.println("CustomerService: 正在构造，需要 OrderService");
//    }
    // ... 其他方法

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
