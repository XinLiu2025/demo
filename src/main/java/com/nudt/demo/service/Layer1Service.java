package com.nudt.demo.service;

import com.nudt.demo.enums.BusinessType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Layer1Service {
    private final String systemKey;
    private final BusinessType businessType;
    private final int maxLimit;

    // 有参构造器
    public Layer1Service(@Qualifier("systemKey") String systemKey, @Qualifier("defaultBusinessType") BusinessType businessType, @Qualifier("maxLimit") int maxLimit) {
        this.systemKey = systemKey;
        this.businessType = businessType;
        this.maxLimit = maxLimit;
    }

    // 业务方法
    public String getSystemInfo() {
        return "SystemKey: " + systemKey + ", BusinessType: " + businessType.getDesc() + ", MaxLimit: " + maxLimit;
    }

    // getter
    public String getSystemKey() { return systemKey; }
    public BusinessType getBusinessType() { return businessType; }
    public int getMaxLimit() { return maxLimit; }
}

