package com.zgx.bootdemo.config;

import com.zgx.bootdemo.service.BankSerivce;
import com.zgx.bootdemo.service.CustomerSerivce;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

/**
 * @author zhouguixing
 * @date 2019/4/16 18:24
 * @description httpInvoker配置
 */
@Configuration
public class HttpInvokerConfig {

    @Bean("/bankService")
    public HttpInvokerServiceExporter httpInvokerServiceExporter(BankSerivce bankSerivce) {
        HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setService(bankSerivce);
        httpInvokerServiceExporter.setServiceInterface(BankSerivce.class);
        return httpInvokerServiceExporter;
    }

    @Bean("/customerService")
    public HttpInvokerServiceExporter customerSerivceImplExporter(CustomerSerivce customerSerivce) {
        HttpInvokerServiceExporter customerSerivceImplExporter = new HttpInvokerServiceExporter();
        customerSerivceImplExporter.setService(customerSerivce);
        customerSerivceImplExporter.setServiceInterface(CustomerSerivce.class);
        return customerSerivceImplExporter;
    }
}