package com.zgx.bootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zhouguixing
 * @date 2019/4/17 17:33
 * @description SpringBoot启动项
 */
@SpringBootApplication
public class BootdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootdemoApplication.class, args);
    }
}
