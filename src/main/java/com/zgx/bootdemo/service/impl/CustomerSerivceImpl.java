package com.zgx.bootdemo.service.impl;

import com.zgx.bootdemo.dao.CustomerDao;
import com.zgx.bootdemo.entity.Customer;
import com.zgx.bootdemo.entity.Page;
import com.zgx.bootdemo.service.CustomerSerivce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "customerSerivce")
@Transactional
public class CustomerSerivceImpl implements CustomerSerivce {

    @Autowired
    private CustomerDao customerDao;

    private Logger logger = LoggerFactory.getLogger(CustomerSerivceImpl.class);
    

    @Override
    public Customer read(String custCode){
        return customerDao.read(custCode);
    }

    @Override
    public Page<Customer> listPage(String keyword, int offset, int limit,String orderKey) {
        Long total = customerDao.count(keyword);
        List list = customerDao.listPage(keyword, offset, limit,orderKey);
        Page<Customer> page = new Page<>();
        page.setList(list);
        page.setOffset(offset);
        page.setLimit(limit);
        page.setTotalSize(total);
        page.setOrderKey(orderKey);
        return page;
    }

    @Override
    public void save(Customer customer) {
        try {
            customerDao.save(customer);
        } catch (Exception e) {
            logger.error("--------------------新增客户出现异常--------------------");
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(String customerId) {
        try {
            customerDao.delete(customerId);
        } catch (RuntimeException e) {
            logger.error("--------------------删除客户出现异常--------------------");
            throw new RuntimeException();
        }
    }

    @Override
    public void update(Customer customer) {
        try {
            customerDao.update(customer);
        } catch (RuntimeException e) {
            logger.error("--------------------修改客户信息出现异常--------------------");
            throw new RuntimeException();
        }
    }
}
