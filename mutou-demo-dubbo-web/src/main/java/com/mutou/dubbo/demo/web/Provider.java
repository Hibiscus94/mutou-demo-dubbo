package com.mutou.dubbo.demo.web;

import com.mutou.dubbo.demo.api.service.DemoService;
import com.mutou.dubbo.demo.api.service.UserService;
import com.mutou.dubbo.demo.service.DemoServiceImpl;
import com.mutou.dubbo.demo.service.UserServiceImpl;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConfigCenterConfig;
import org.apache.dubbo.config.MetadataReportConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class Provider {
    public static void main(String[] args) throws IOException {
        // 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口

        // 服务提供者暴露服务配置
        // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        ServiceConfig<DemoService> service = new ServiceConfig<>();
        ApplicationConfig applicationConfig = new ApplicationConfig("mutou-demo-dubbo");
        service.setApplication(applicationConfig);
        // 多个注册中心可以用setRegistries()
        //注册中心
        service.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));

        // 多个协议可以用setProtocols()

        //配置中心
        ConfigCenterConfig configCenterConfig = new ConfigCenterConfig();
        configCenterConfig.setAddress("zookeeper://127.0.0.1:2181");
        service.setConfigCenter(configCenterConfig);

        //元数据中心
        MetadataReportConfig metadataReportConfig = new MetadataReportConfig();
        metadataReportConfig.setAddress("zookeeper://127.0.0.1:2181");
        service.setMetadataReportConfig(metadataReportConfig);

        service.setInterface(DemoService.class);
        service.setRef(new DemoServiceImpl());

        service.setVersion("1.0.0");

        // 暴露及注册服务
        service.export();

        // 服务提供者暴露服务配置
        // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        ServiceConfig<UserService> service2 = new ServiceConfig<>();
        ApplicationConfig applicationConfig2 = new ApplicationConfig("mutou-demo-dubbo");
        service2.setApplication(applicationConfig2);
        // 多个注册中心可以用setRegistries()
        //注册中心
        service2.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));

        // 多个协议可以用setProtocols()
        List<ProtocolConfig> protocolConfigs = new ArrayList<>();
        protocolConfigs.add(new ProtocolConfig("dubbo"));
        ProtocolConfig restProtocol = new ProtocolConfig("rest",888);
        restProtocol.setContextpath("api");
        restProtocol.setServer("jetty");
        protocolConfigs.add(restProtocol);
        service2.setProtocols(protocolConfigs);

        //配置中心
        ConfigCenterConfig configCenterConfig2 = new ConfigCenterConfig();
        configCenterConfig2.setAddress("zookeeper://127.0.0.1:2181");
        service2.setConfigCenter(configCenterConfig2);

        //元数据中心
        MetadataReportConfig metadataReportConfig2 = new MetadataReportConfig();
        metadataReportConfig2.setAddress("zookeeper://127.0.0.1:2181");
        service2.setMetadataReportConfig(metadataReportConfig2);

        service2.setInterface(UserService.class);
        service2.setRef(new UserServiceImpl());

        service2.setVersion("1.0.0");

        // 暴露及注册服务
        service2.export();

        System.in.read();
    }
}
