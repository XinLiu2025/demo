package com.nudt.demo.config;

import com.nudt.demo.enums.BusinessType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class ComplexConfig {
    // Bean1：自定义字符串（UUID生成，非固定值）
    @Bean
    public String systemKey() {
        return "SYS-" + UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    }

    // Bean2：业务类型枚举（固定值，但需作为参数注入）
    @Bean
    public BusinessType defaultBusinessType() {
        return BusinessType.REFUND;
    }

    // Bean3：整数参数（动态生成，非固定值）
    @Bean
    public int maxLimit() {
        return (int) (Math.random() * 1000 + 500); // 500-1500随机数
    }
}
