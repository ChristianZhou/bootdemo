package com.zgx.bootdemo.dao;

import com.zgx.bootdemo.entity.Customer;
import com.zgx.bootdemo.entity.Page;

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
    Customer read(String custCode);

    /**
     * @author zhouguixing
     * @date 2019/4/17 17:16
     * @description 根据实体类查询客户列表
     *
     * @param customer 1
     * @return : java.util.List
     */
    @Deprecated
    List list(Customer customer);


    /**
     * @author zhouguixing
     * @date 2019/4/18 9:31
     * @description 按关键词（代码、助记码、名称）分页查询
     *
     * @param keyword 1
     * @param startIndex 2
     * @param size 3
     * @return : java.util.List
     */
    List<Customer> listPage(String keyword,int startIndex,int size);

    /**
     * @author zhouguixing
     * @date 2019/4/17 17:17
     * @description 新增客户
     *
     * @param customer 1
     * @return : void
     */
    void save(Customer customer);

    /**
     * @author zhouguixing
     * @date 2019/4/17 17:17
     * @description 根据实体类查询客户数量
     *
     * @param customer 1
     * @return : int
     */
    int count(Customer customer);
    
    /**
     * @author zhouguixing
     * @date 2019/4/18 9:57
     * @description 根据关键字查询客户数量
     *
     * @param keyword 1
     * @return : int
     */
    int count(String keyword);

    /**
     * @author zhouguixing
     * @date 2019/4/17 17:17
     * @description 根据主键删除客户
     *
     * @param custCode 1
     * @return : void
     */
    void remove(String custCode);

    /**
     * @author zhouguixing
     * @date 2019/4/17 17:17
     * @description 修改客户信息
     *
     * @param customer 1
     * @return : void
     */
    void update(Customer customer);
}
