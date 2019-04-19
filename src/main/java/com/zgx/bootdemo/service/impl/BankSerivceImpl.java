package com.zgx.bootdemo.service.impl;

import com.zgx.bootdemo.dao.BankDao;
import com.zgx.bootdemo.entity.Bank;
import com.zgx.bootdemo.service.BankSerivce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "bankSerivceImpl")
@Transactional
public class BankSerivceImpl implements BankSerivce {

    private Logger logger = LoggerFactory.getLogger(BankSerivceImpl.class);

    @Autowired
    private  BankDao bankDao;

    @Override
    public Bank readBank(String bankCode) {
        return bankDao.read(bankCode);
    }

    @Override
    public List listBank() {
        return bankDao.list();
    }

    @Override
    public void saveBank(Bank bank) {
        try {
            bankDao.save(bank);
        } catch (Exception e) {
            logger.error("--------------------新增银行出现异常--------------------");
            throw new RuntimeException();
        }
    }

    @Override
    public void removeBank(String bankCode) {
        try {
            bankDao.delete(bankCode);
        } catch (Exception e) {
            logger.error("--------------------删除银行信息出现异常--------------------");
            throw new RuntimeException();
        }
    }

    @Override
    public void updateBank(Bank bank) {
        try {
            bankDao.update(bank);
        } catch (Exception e) {
            logger.error("--------------------修改银行信息出现异常--------------------");
            throw new RuntimeException();
        }
    }

}
