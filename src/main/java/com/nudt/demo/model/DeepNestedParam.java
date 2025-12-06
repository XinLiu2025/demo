package com.nudt.demo.model;

// 最底层嵌套模型（含基础类型+自定义逻辑）

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DeepNestedParam {
    private final String encryptKey;
    private final long timeout;
    private final boolean isEnable;

    // 仅含参构造器
    public DeepNestedParam(@Value("${deep.nested.encryptKey:sk-0000}") String encryptKey, @Value("${deep.nested.timeout:5000}") long timeout, @Value("${deep.nested.isEnable:false}") boolean isEnable) {
        this.encryptKey = encryptKey;
        this.timeout = timeout;
        this.isEnable = isEnable;
    }

    // 随便生成一个方法，有分支和循环
    public String testEncryptKeyWithLogic(int i) {
        if (isEnable) {
            for (; i < 10; i++) {
                System.out.println("DeepNestedParam: " + i);
            }
            return "进入分支 + EncryptKey: " + encryptKey;
        }
        return "没进入分支：EncryptKey: " + encryptKey;
    }


    // getter（无setter，不可变）
    public String getEncryptKey() { return encryptKey; }
    public long getTimeout() { return timeout; }
    public boolean getIsEnable() { return isEnable; }
}