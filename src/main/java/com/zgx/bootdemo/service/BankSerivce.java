package com.zgx.bootdemo.service;

import com.zgx.bootdemo.entity.Bank;

import java.util.List;

/**
 * @author zhouguixing
 * @date 2019/4/13	9:38
 * @description 银行service接口
 */
public interface BankSerivce {

    /**
     * @author zhouguixing
     * @date 2019/4/17 16:48
     * @description 根据主键查询银行信息
     *
     * @param bankCode 1
     * @return : com.zgx.bootdemo.entity.Bank
     */
    Bank readBank(String bankCode);

    /**
     * @author zhouguixing
     * @date 2019/4/17 16:49
     * @description 根据实体类查询银行列表
     *
     * @param bank 1
     * @return : java.util.List
     */
    List listBank(Bank bank);

    /**
     * @author zhouguixing
     * @date 2019/4/17 16:49
     * @description 统计某类银行数量
     *
     * @param bank 1
     * @return : java.lang.Integer
     */
    Integer countBank(Bank bank);

    /**
     * @author zhouguixing
     * @date 2019/4/17 16:50
     * @description 新增银行
     *
     * @param bank 1
     * @return : java.lang.Boolean
     */
    Boolean saveBank(Bank bank);

    /**
     * @author zhouguixing
     * @date 2019/4/17 16:50
     * @description 根据主键删除银行
     *
     * @param bankCode 1
     * @return : void
     */
    void removeBank(String bankCode);

    /**
     * @author zhouguixing
     * @date 2019/4/17 16:50
     * @description 修改银行信息
     *
     * @param bank 1
     * @return : void
     */
    void updateBank(Bank bank);

}
