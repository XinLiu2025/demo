package com.nudt.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class NestedParam2 {
    private final DeepNestedParam deepParam;  // 依赖底层模型
    private final List<String> userIds;       // 集合参数（泛型）
    private final int retryCount;             // 重试次数（整型）

    // 仅含参构造器
    public NestedParam2(DeepNestedParam deepParam, @Value("${nested1.param2.userIds:1001,1002,1003}") List<String> userIds, @Value("${nested1.param2.retryCount:3}") int retryCount) {
        this.deepParam = deepParam;
        this.userIds = userIds;
        this.retryCount = retryCount;
    }

    // getter
    public DeepNestedParam getDeepParam() { return deepParam; }
    public List<String> getUserIds() { return userIds; }
    public int getRetryCount() { return retryCount; }
}

