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
     * @return : com.zgx.bootdemo.entity.BankDTO
     */
    Bank read(Long bankCode) ;

    /**
     * @author zhouguixing
     * @date 2019/4/18 13:45
     * @description 查询所有银行列表
     *
     * @return : java.util.List
     */
    List list();

    /**
     * @author zhouguixing
     * @date 2019/4/19 13:39
     * @description 新增银行
     *
     * @param bank 1
     * @return : void
     */
    void save(Bank bank);

    /**
     * @author zhouguixing
     * @date 2019/4/17 16:50
     * @description 根据主键删除银行
     *
     * @param bankCode 1
     * @return : void
     */
    void delete(Long bankCode);

    /**
     * @author zhouguixing
     * @date 2019/4/17 16:50
     * @description 修改银行信息
     *
     * @param bank 1
     * @return : void
     */
    void update(Bank bank);

}
