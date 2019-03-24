package com.mutou.dubbo.demo.web;

import com.mutou.dubbo.demo.api.service.DemoService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConfigCenterConfig;
import org.apache.dubbo.config.MetadataReportConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

/**
 * ,__,
 * (oo)_____
 * (__)     )\
 * ````||---|| *
 * com.mutou.dubbo.demo.web <br>
 * jdk 8
 *
 * @author mutou <br>
 * @version 1.0.0
 * @date 2019-03-23 <br>
 */
public class Consumer {
    public static void main(String[] args){
        ReferenceConfig<DemoService> reference = new ReferenceConfig<>();

        ApplicationConfig applicationConfig = new ApplicationConfig("mutou-demo-dubbo");
        applicationConfig.setQosPort(33333);
        reference.setApplication(applicationConfig);

        //注册中心
        reference.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));

        //配置中心
        ConfigCenterConfig configCenterConfig = new ConfigCenterConfig();
        configCenterConfig.setAddress("zookeeper://127.0.0.1:2181");
        reference.setConfigCenter(configCenterConfig);

        //元数据中心
        MetadataReportConfig metadataReportConfig = new MetadataReportConfig();
        metadataReportConfig.setAddress("zookeeper://127.0.0.1:2181");
        reference.setMetadataReportConfig(metadataReportConfig);

        reference.setInterface(DemoService.class);
        reference.setVersion("1.0.0");
        DemoService service = reference.get();
        String message = service.sayHello();
        System.out.println(message);
    }
}
