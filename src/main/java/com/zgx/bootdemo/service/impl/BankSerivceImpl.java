package com.zgx.bootdemo.service.impl;

import com.zgx.bootdemo.dao.BankDao;
import com.zgx.bootdemo.entity.Bank;
import com.zgx.bootdemo.service.BankSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "bankSerivceImpl")
public class BankSerivceImpl implements BankSerivce {

    @Autowired
    private  BankDao bankDao;

    @Override
    @Transactional
    public Bank readBank(String bankCode) {
        return bankDao.read(bankCode);
    }

    @Override
    @Transactional
    public List listBank(Bank bank) {
        return bankDao.list(bank);
    }

    @Override
    @Transactional
    public Integer countBank(Bank bank) {
        return bankDao.count(bank);
    }

    @Override
    @Transactional
    public Boolean saveBank(Bank bank) {
        boolean flag = true;
        if (bankDao.read(bank.getBankCode()) == null) {
            bankDao.save(bank);
        }else {
            flag=false;
        }
        return flag;
    }

    @Override
    @Transactional
    public void removeBank(String bankCode) {
        bankDao.remove(bankCode);
    }

    @Override
    @Transactional
    public void updateBank(Bank bank) {
        bankDao.update(bank.getBankCode(),bank.getBankName());
    }

}
