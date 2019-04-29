package com.zgx.bootdemo.dao;

import com.zgx.bootdemo.entity.Customer;
import com.zgx.bootdemo.entity.KeywordPage;

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
     * @return : com.zgx.bootdemo.entity.CustomerDTO
     */
    Customer read(Long custCode) throws RuntimeException;

    /**
     * @author zhouguixing
     * @date 2019/4/24 15:40
     * @description 按关键词（代码、助记码、名称）分页查询
     *
     * @param keywordPage 1
     * @return : java.util.List
     */
    List listPage(KeywordPage keywordPage) throws RuntimeException;

    /*
     * @author zhouguixing
     * @date 2019/4/27 11:14
     * @description 按照客户类型查询
     *
     * @param custTypeCode 1
     * @return : java.util.List
     */
    List listByType(Long custTypeCode)  throws RuntimeException;


    /*
     * @author zhouguixing
     * @date 2019/4/28 19:09
     * @description 根据客户类别、关键字查询
     *
     * @param custTypeCode 1
     * @param keyword 2
     * @return : java.util.List
     */
    List listByTypeAndKeyword(Long custTypeCode,String keyword)  throws RuntimeException;

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
    void delete(Long custCode) throws RuntimeException;

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
