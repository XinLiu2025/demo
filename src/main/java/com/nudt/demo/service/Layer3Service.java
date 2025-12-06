package com.nudt.demo.service;

import com.nudt.demo.model.NestedParam1;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;
import java.util.Map;

@Service
@ConfigurationProperties(prefix = "layer3.service")
public class Layer3Service {
    private final Layer2Service layer2Service;
    private Map<String, Integer> configMap;
    private final boolean isDebug;

    // 构造器注入
    public Layer3Service(
            Layer2Service layer2Service,
            @Value("${layer3.service.isDebug}") boolean isDebug
    ) {
        this.layer2Service = layer2Service;
        this.isDebug = isDebug;
    }

    public void setConfigMap(Map<String, Integer> configMap) {
        this.configMap = configMap;
    }

    // 业务方法
    public String getComplexConfig() {
        System.out.println("ComplexConfig: " + configMap);
        return "DebugMode: " + isDebug + ", ConfigSize: " + configMap.size() + ", Layer2Info: " + layer2Service.getBusinessParam();
    }

    // getter（保持不变）
    public Layer2Service getLayer2Service() { return layer2Service; }
    public Map<String, Integer> getConfigMap() { return configMap; }
    public boolean isDebug() { return isDebug; }
}