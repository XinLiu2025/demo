package com.nudt.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 中层嵌套模型1（依赖底层模型+基础类型）
@Component
public class NestedParam1 {
    private final DeepNestedParam deepParam; // 依赖底层模型
    private final String businessId;         // 业务ID
    private final double amount;             // 金额（浮点型）

    // 仅含参构造器
    public NestedParam1(DeepNestedParam deepParam, @Value("${nested1.param1.businessId:中层嵌套模型默认业务ID}") String businessId, @Value("${nested1.param1.amount:100.0}")double amount) {
        this.deepParam = deepParam;
        this.businessId = businessId;
        this.amount = amount;
    }

    // getter
    public DeepNestedParam getDeepParam() { return deepParam; }
    public String getBusinessId() { return businessId; }
    public double getAmount() { return amount; }
}

