package com.zgx.bootdemo.service;

import com.zgx.bootdemo.entity.Customer;
import com.zgx.bootdemo.entity.KeywordPage;
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
     * @return : com.zgx.bootdemo.entity.CustomerDTO
     */
    Customer read(Long custCode) throws Exception;

    /**
     * @author zhouguixing
     * @date 2019/4/24 15:36
     * @description 按关键词（代码、助记码、名称）分页查询
     *
     * @param keywordPage 1
     * @return : com.zgx.bootdemo.entity.Page<com.zgx.bootdemo.entity.CustomerDTO>
     */
    Page<Customer> listPage(KeywordPage keywordPage);

    /*
     * @author zhouguixing
     * @date 2019/4/27 11:15
     * @description  按照客户类型查询
     *
     * @param custTypeCode 1
     * @return : java.util.List
     */
    List listByType(Long custTypeCode);


    /*
     * @author zhouguixing
     * @date 2019/4/28 19:09
     * @description 根据客户类别、关键字查询
     *
     * @param custTypeCode 1
     * @param keyword 2
     * @return : java.util.List
     */
    List listByTypeAndKeyword(Long custTypeCode,String keyword);

    /**
     * @author zhouguixing
     * @date 2019/4/19 13:40
     * @description 新增客户
     *
     * @param customer 1
     * @return : void
     */
    void save(Customer customer);

    /**
     * @author zhouguixing
     * @date 2019/4/17 17:03
     * @description 根据主键删除用户
     *
     * @param custCode 1
     * @return : void
     */
    void delete(Long custCode) throws Exception;

    /**
     * @author zhouguixing
     * @date 2019/4/17 17:03
     * @description 修改用户信息
     *
     * @param customer 1
     * @return : void
     */
    void update(Customer customer);

}
