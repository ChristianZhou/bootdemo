package com.zgx.bootdemo.dao;

import com.zgx.bootdemo.entity.Bank;

import java.util.List;

/**
 * @author zhouguixing
 * @date 2019/4/13 9:45
 * @description 银行dao层接口
 */
public interface BankDao{

    /**
     * @author zhouguixing
     * @date 2019/4/17 16:51
     * @description 根据主键查询银行信息
     *
     * @param id 1
     * @return : com.zgx.bootdemo.entity.Bank
     */
    Bank read(String id);

    /**
     * @author zhouguixing
     * @date 2019/4/17 16:51
     * @description 根据实体类查询列表
     *
     * @param bank 1
     * @return : java.util.List
     */
    @Deprecated
    List list(Bank bank);

    /**
     * @author zhouguixing
     * @date 2019/4/18 13:40
     * @description 查询银行列表
     *
     * @return : java.util.List
     */
    List list();

    /**
     * @author zhouguixing
     * @date 2019/4/17 16:52
     * @description 新增银行信息
     *
     * @param bank 1
     * @return : void
     */
    void save(Bank bank);

    /**
     * @author zhouguixing
     * @date 2019/4/17 16:55
     * @description 根据实体类统计银行总数
     *
     * @param bank 1
     * @return : int
     */
    int count(Bank bank);

    /**
     * @author zhouguixing
     * @date 2019/4/17 16:55
     * @description 根据主键删除银行
     *
     * @param bankCode 1
     * @return : void
     */
    void remove( String bankCode);

    /**
     * @author zhouguixing
     * @date 2019/4/17 16:57
     * @description 修改银行信息
     *
     * @param bankCode 1
     * @param bankName 2
     * @return : void
     */
    void update(String bankCode,String bankName);


}
