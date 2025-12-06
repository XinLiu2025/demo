package com.nudt.demo.enums;

// 业务类型枚举，构造器参数需包含此枚举
public enum BusinessType {
    PAYMENT("支付业务", 1001),
    REFUND("退款业务", 1002),
    TRANSFER("转账业务", 1003);

    private final String desc;
    private final int code;

    BusinessType(String desc, int code) {
        this.desc = desc;
        this.code = code;
    }

    // getter（无setter，确保不可变）
    public String getDesc() { return desc; }
    public int getCode() { return code; }
}