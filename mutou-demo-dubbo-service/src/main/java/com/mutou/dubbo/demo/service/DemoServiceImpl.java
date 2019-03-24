package com.mutou.dubbo.demo.service;

import com.mutou.dubbo.demo.api.service.DemoService;
import com.mutou.dubbo.demo.dao.Person;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mutou
 */
public class DemoServiceImpl implements DemoService {
    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public String sayHello() {
        Person person = new Person("mutou", 28);
        logger.info("Hello " + person.getName() + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + person.getName() + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }
}
