package com.nudt.demo.service;

import com.nudt.demo.enums.BusinessType;
import com.nudt.demo.model.DeepNestedParam;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@ConfigurationProperties(prefix = "final.business.service") // 绑定配置前缀（处理Map）
public class FinalBusinessService {
    private final Layer3Service layer3Service;
    private final BusinessType businessType;
    private final DeepNestedParam deepParam;
    private final List<String> whiteList;
    private Map<String, String> extMap;
    private final double feeRate;
    private final int version;

    // Constructor
    public FinalBusinessService(
            Layer3Service layer3Service,
            @Qualifier("defaultBusinessType") BusinessType businessType,
            DeepNestedParam deepParam,
            @Value("${final.business.service.whiteList}") List<String> whiteList,
            @Value("${final.business.service.feeRate}") double feeRate,
            @Value("${final.business.service.version}") int version
    ) {
        this.layer3Service = layer3Service;
        this.businessType = businessType;
        this.deepParam = deepParam;
        this.whiteList = whiteList;
        this.feeRate = feeRate;
        this.version = version;
    }
    public void setExtMap(Map<String, String> extMap) {
        this.extMap = extMap;
    }

    /**
     * Executes the core business logic for processing an order.
     *
     * This method validates if the given order ID is in the whitelist and if the deep parameter service is enabled.
     * If both conditions are met, it calculates a fee based on the nested configuration parameters multiplied by
     * the configured fee rate. The result includes order details, calculated fee, version information, and layer 3 configuration.
     *
     * @param orderId The unique identifier of the order to be processed
     * @return A string containing either the processing result with fee calculation or a rejection message
     */
    public String executeBusiness(String orderId) {
        if (whiteList.contains(orderId) && deepParam.getIsEnable()) {
            double fee = layer3Service.getLayer2Service().getBaseParam().
                    getNested1().getAmount() * feeRate;
            return "Order: " + orderId + ", Fee: " + fee + ", Version: " + version +
                    ", Layer3Config: " + layer3Service.getComplexConfig();
        }
        return "Order " + orderId + " rejected (not in whiteList or service disabled)";
    }

    // getter
    public Layer3Service getLayer3Service() { return layer3Service; }
    public BusinessType getBusinessType() { return businessType; }
    public DeepNestedParam getDeepParam() { return deepParam; }
    public List<String> getWhiteList() { return whiteList; }
    public Map<String, String> getExtMap() { return extMap; }
    public double getFeeRate() { return feeRate; }
    public int getVersion() { return version; }
}