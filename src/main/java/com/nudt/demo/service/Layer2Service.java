package com.nudt.demo.service;
import com.nudt.demo.model.BaseParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class Layer2Service {
    private final Layer1Service layer1Service; // 依赖1级服务
    private final BaseParam baseParam;         // 依赖复杂模型
    private final long timestamp;              // 时间戳参数（构造时生成）

    // 有参构造器
    public Layer2Service(Layer1Service layer1Service, BaseParam baseParam) {
        this.layer1Service = layer1Service;
        this.baseParam = baseParam;
        this.timestamp = System.currentTimeMillis(); // 动态参数（非注入，增加复杂度）
    }

    // 业务方法
    public String getBusinessParam() {
        return "RequestId: " + baseParam.getRequestId() + ", Timestamp: " + timestamp + ", Layer1Info: " + layer1Service.getSystemInfo();
    }

    // getter
    public Layer1Service getLayer1Service() { return layer1Service; }
    public BaseParam getBaseParam() { return baseParam; }
    public long getTimestamp() { return timestamp; }
}
