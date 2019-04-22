package com.zgx.bootdemo.config;

import com.zgx.bootdemo.service.impl.BankSerivceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.HashMap;

/**
 * @author zhouguixing
 * @date 2019/4/16 18:24
 * @description 注入SessionFactory
 */
@Configuration
public class HttpInvokerConfig {

    @Autowired
    private BankSerivceImpl bankSerivceImpl;

    @Bean//开放service层，配置实现类、接口
    public HttpInvokerServiceExporter httpInvokerServiceExporter() {
        HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setService(bankSerivceImpl);
        httpInvokerServiceExporter.setServiceInterface(bankSerivceImpl.getClass().getInterfaces()[0]);
        httpInvokerServiceExporter.afterPropertiesSet();
        return httpInvokerServiceExporter;
    }

    @Bean//url映射，指向服务层开放口
    public SimpleUrlHandlerMapping simpleUrlHandlerMapping(){
        SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
        simpleUrlHandlerMapping.setOrder(0);
        HashMap<String, HttpInvokerServiceExporter> map = new HashMap<>();
        map.put("bankService",httpInvokerServiceExporter() );
        simpleUrlHandlerMapping.setUrlMap(map);
        return simpleUrlHandlerMapping;
    }


}