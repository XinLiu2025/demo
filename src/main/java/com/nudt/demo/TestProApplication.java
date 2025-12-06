package com.nudt.demo;

import com.nudt.demo.model.DeepNestedParam;
import com.nudt.demo.service.FinalBusinessService;
import com.nudt.demo.service.Layer3Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

@SpringBootApplication
public class TestProApplication {

    public static void main(String[] args) {
        // 启动Spring上下文（IoC容器初始化，自动注入所有复杂Bean）
        ConfigurableApplicationContext context = SpringApplication.run(TestProApplication.class, args);

        // 从容器中获取最终业务服务Bean（验证IoC是否成功管理复杂对象）
//        FinalBusinessService businessService = context.getBean(FinalBusinessService.class);
        // 调用业务方法（验证功能正常）
//        String result = businessService.executeBusiness("sk-100");
//        System.out.println("Business Result: " + result);
//
//        context.close();
//        DeepNestedParam deepNestedParam = context.getBean(DeepNestedParam.class);
//        String s = deepNestedParam.testEncryptKeyWithLogic(3);
//        System.out.println( s);
    }

}
