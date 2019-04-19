package com.zgx.bootdemo.service;

import com.zgx.bootdemo.entity.Customer;
import com.zgx.bootdemo.entity.Page;

import java.util.List;

/**
 * @author zhouguixing
 * @date 2019/4/13	9:38
 * @description 银行service接口
 */
public interface CustomerSerivce {

    /**
     * @author zhouguixing
     * @date 2019/4/17 17:01
     * @description 根据主键查询单个用户
     *
     * @param custCode 1
     * @return : com.zgx.bootdemo.entity.Customer
     */
    Customer getCustomer(String custCode) throws Exception;

    /**
     * @author zhouguixing
     * @date 2019/4/18 9:53
     * @description 按关键词（代码、助记码、名称）分页查询
     *
     * @param keyword 1
     * @param pageNum 2
     * @param pageSize 3
     * @return : com.zgx.bootdemo.entity.Page<com.zgx.bootdemo.entity.Customer>
     */
    Page<Customer> listPageCustomer(String keyword,int pageNum,int pageSize);


    /**
     * @author zhouguixing
     * @date 2019/4/19 13:40
     * @description 新增客户
     *
     * @param customer 1
     * @return : void
     */
    void saveCustomer(Customer customer);

    /**
     * @author zhouguixing
     * @date 2019/4/17 17:03
     * @description 根据主键删除用户
     *
     * @param custCode 1
     * @return : void
     */
    void removeCustomer(String custCode) throws Exception;

    /**
     * @author zhouguixing
     * @date 2019/4/17 17:03
     * @description 修改用户信息
     *
     * @param customer 1
     * @return : void
     */
    void updateCustomer(Customer customer);

}
