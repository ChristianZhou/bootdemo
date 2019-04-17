package com.zgx.bootdemo.controller;

import com.zgx.bootdemo.entity.Bank;
import com.zgx.bootdemo.service.BankSerivce;
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

    @Resource(name = "bankSerivceImpl")
    private BankSerivce bankSerivce;

    /**
     * @author zhouguixing
     * @date 2019/4/17 14:45
     * @description 
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
     * @description 根据实体类参数属性查询银行列表，为空的属性忽略
     */
    @ResponseBody
    @RequestMapping(value = "/bank/list", method = RequestMethod.POST)
    public List listBank(@RequestBody Bank bank) {
        return bankSerivce.listBank(bank);
    }

    /**
     * @author zhouguixing
     * @date 2019/4/17 10:32
     * @description 根据实体类参数属性查询银行总数，为空的属性忽略
     */
    @ResponseBody
    @RequestMapping(value = "/bank/count", method = RequestMethod.GET)
    public int countBank() {
        return bankSerivce.countBank(new Bank());
    }


    /**
     * @author zhouguixing
     * @date 2019/4/17 10:32
     * @description 添加银行信息，主键为后端自动生成的UUID
     */
    @ResponseBody
    @RequestMapping(value = "/bank", method = RequestMethod.POST)
    public String saveBank(@RequestBody Bank bank) {
        bank.setBankCode(UUID.randomUUID().toString());
        boolean flag = bankSerivce.saveBank(bank);
        return flag ? "添加成功" : "添加失败";
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
