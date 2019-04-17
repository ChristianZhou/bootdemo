package com.zgx.bootdemo.service;

import com.zgx.bootdemo.entity.Customer;

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
     * @date 2019/4/17 17:02
     * @description 根据实体类查询用户列表
     *
     * @param customer 1
     * @return : java.util.List
     */
    List listCustomer(Customer customer);

    /**
     * @author zhouguixing
     * @date 2019/4/17 17:02
     * @description 根据实体类查询用户数量
     *
     * @param customer 1
     * @return : java.lang.Integer
     */
    Integer countCustomer(Customer customer);

    /**
     * @author zhouguixing
     * @date 2019/4/17 17:03
     * @description 新增用户
     *
     * @param customer 1
     * @return : java.lang.Boolean
     */
    Boolean saveCustomer(Customer customer);

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
