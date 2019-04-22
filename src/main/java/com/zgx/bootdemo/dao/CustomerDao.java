package com.zgx.bootdemo.dao;

import com.zgx.bootdemo.entity.Customer;

import java.util.List;

/**
 * @author zhouguixing
 * @date 2019/4/13 9:45
 * @description 银行dao层
 */

public interface CustomerDao {

    /**
     * @author zhouguixing
     * @date 2019/4/17 17:16
     * @description 根据主键查询单个
     *
     * @param custCode 1
     * @return : com.zgx.bootdemo.entity.Customer
     */
    Customer read(String custCode) throws RuntimeException;

    /**
     * @author zhouguixing
     * @date 2019/4/22 9:52
     * @description 按关键词（代码、助记码、名称）分页查询
     *
     * @param keyword 1
     * @param offSet 2
     * @param limit 3
     * @param orderKey 4
     * @return : java.util.List
     */
    List listPage(String keyword,int offSet,int limit,String orderKey) throws RuntimeException;

    /**
     * @author zhouguixing
     * @date 2019/4/17 17:17
     * @description 新增客户
     *
     * @param customer 1
     * @return : void
     */
    void save(Customer customer) throws RuntimeException;

    /**
     * @author zhouguixing
     * @date 2019/4/18 9:57
     * @description 根据关键字查询客户数量
     *
     * @param keyword 1
     * @return : int
     */
    Long count(String keyword) throws RuntimeException;

    /**
     * @author zhouguixing
     * @date 2019/4/17 17:17
     * @description 根据主键删除客户
     *
     * @param custCode 1
     * @return : void
     */
    void delete(String custCode) throws RuntimeException;

    /**
     * @author zhouguixing
     * @date 2019/4/17 17:17
     * @description 修改客户信息
     *
     * @param customer 1
     * @return : void
     */
    void update(Customer customer) throws RuntimeException;
}
