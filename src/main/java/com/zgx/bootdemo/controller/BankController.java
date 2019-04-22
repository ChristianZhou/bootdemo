package com.zgx.bootdemo.controller;

import com.zgx.bootdemo.entity.Bank;
import com.zgx.bootdemo.service.BankSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


/**
 * @author zhouguixing
 * @date 2019/4/16 18:40
 * @description 银行信息Controller
 */
@Controller
@RequestMapping(value = "/bank")
public class BankController {

    @Autowired
    private BankSerivce bankSerivce;

    /**
     * @param bankCode 1
     *
     * @return : com.zgx.bootdemo.entity.Bank
     *
     * @author zhouguixing
     * @date 2019/4/17 14:45
     * @description 根据主键查询银行信息
     */
    @ResponseBody
    @RequestMapping(value = "/read/{bankId}", method = RequestMethod.GET)
    public Bank read(@PathVariable("bankId") String bankCode) {
        return bankSerivce.read(bankCode);
    }

    /**
     * @author zhouguixing
     * @date 2019/4/17 10:31
     * @description 查询所有银行列表
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List list() {
        return bankSerivce.list();
    }

    /**
     * @author zhouguixing
     * @date 2019/4/17 10:32
     * @description 添加银行信息，主键为后端自动生成的UUID
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Bank bank) {
        bank.setBankCode(UUID.randomUUID().toString());
        bankSerivce.save(bank);
    }

    /**
     * @author zhouguixing
     * @date 2019/4/17 10:33
     * @description 根据主键删除银行
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{bankId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("bankId") String bankId) {
        bankSerivce.delete(bankId);
    }

    /**
     * @author zhouguixing
     * @date 2019/4/17 10:35
     * @description 修改银行信息
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody Bank bank) {
        bankSerivce.update(bank);
    }

}
