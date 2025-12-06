package com.nudt.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BaseParam {
    private final NestedParam1 nested1; // 依赖中层模型1
    private final NestedParam2 nested2; // 依赖中层模型2
    private final String requestId;     // 请求ID（唯一标识）

    // 仅含参构造器
    public BaseParam(NestedParam1 nested1, NestedParam2 nested2, @Value("${base.param:BaseParam默认请求ID}") String requestId) {
        this.nested1 = nested1;
        this.nested2 = nested2;
        this.requestId = requestId;
    }

    // getter
    public NestedParam1 getNested1() { return nested1; }
    public NestedParam2 getNested2() { return nested2; }
    public String getRequestId() { return requestId; }
}
