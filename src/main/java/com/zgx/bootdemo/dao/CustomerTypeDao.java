package com.zgx.bootdemo.dao;

import com.zgx.bootdemo.entity.CustomerType;

import java.util.List;

/**
 * @author zhouguixing
 * @date 2019/4/27 3:59
 * @description 客户类型Dao
 */
public interface CustomerTypeDao {

    List<CustomerType> list() throws RuntimeException;

}
