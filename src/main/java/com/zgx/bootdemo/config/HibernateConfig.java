package com.zgx.bootdemo.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

/**
 * @author zhouguixing
 * @date 2019/4/16 18:24
 * @description 注入SessionFactory
 */
@Configuration
public class HibernateConfig{



    @Bean
    public SessionFactory sesssionFactory(EntityManagerFactory entityManagerFactory){
        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }else{
            return entityManagerFactory.unwrap(SessionFactory.class);
        }
    }







}