package com.zgx.bootdemo.controller;

import com.zgx.bootdemo.entity.Bank;
import com.zgx.bootdemo.service.BankSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;


/**
 * @author zhouguixing
 * @date 2019/4/16 18:40
 * @description 银行信息Controller
 */
@RestController
public class BankController {

    @Autowired
    private BankSerivce bankSerivce;

    /**
     * @author zhouguixing
     * @date 2019/4/17 14:45
     * @description  根据主键查询银行信息
     *
     * @param bankCode 1
     * @return : com.zgx.bootdemo.entity.Bank
     */
    @ResponseBody
    @RequestMapping(value = "/bank/{bankId}", method = RequestMethod.GET)
    public Bank readBank(@PathVariable("bankId") String bankCode) {
        return bankSerivce.readBank(bankCode);
    }


    /**
     * @author zhouguixing
     * @date 2019/4/17 10:31
     * @description 查询所有银行列表
     */
    @ResponseBody
    @RequestMapping(value = "/bank/list", method = RequestMethod.GET)
    public List listBank() {
        return bankSerivce.listBank();
    }

    /**
     * @author zhouguixing
     * @date 2019/4/17 10:32
     * @description 添加银行信息，主键为后端自动生成的UUID
     */
    @ResponseBody
    @RequestMapping(value = "/bank", method = RequestMethod.POST)
    public void saveBank(@RequestBody Bank bank) {
        bank.setBankCode(UUID.randomUUID().toString());
        bankSerivce.saveBank(bank);
    }


    /**
     * @author zhouguixing
     * @date 2019/4/17 10:33
     * @description 根据主键删除银行
     */
    @ResponseBody
    @RequestMapping(value = "/bank/{bankId}", method = RequestMethod.DELETE)
    public void removeBank(@PathVariable("bankId") String bankId) {
        bankSerivce.removeBank(bankId);
    }


    /**
     * @author zhouguixing
     * @date 2019/4/17 10:35
     * @description 修改银行信息
     */
    @ResponseBody
    @RequestMapping(value = "/bank", method = RequestMethod.PUT)
    public void updateBank(@RequestBody Bank bank) {
        bankSerivce.updateBank(bank);
    }


}
