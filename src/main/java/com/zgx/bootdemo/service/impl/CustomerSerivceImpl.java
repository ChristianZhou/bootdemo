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
    public Customer getCustomer(String custCode){
        return customerDao.read(custCode);
    }

    @Override
    public Page<Customer> listPageCustomer(String keyword, int pageNum, int pageSize) {
        int startIndex = 0;
        Long total = customerDao.count(keyword);
        startIndex = (pageNum-1)*pageSize;
        List list = customerDao.listPage(keyword, startIndex, pageSize);
        Page<Customer> customerPage = new Page<>();
        customerPage.setList(list);
        customerPage.setPageNum(pageNum);
        customerPage.setPageSize(pageSize);
        customerPage.setTotalSize(total);
        return customerPage;
    }

    @Override
    public void saveCustomer(Customer customer) {
        try {
            customerDao.save(customer);
        } catch (Exception e) {
            logger.error("--------------------新增客户出现异常--------------------");
            throw new RuntimeException();
        }
    }

    @Override
    public void removeCustomer(String customerId) {
        try {
            customerDao.delete(customerId);
        } catch (RuntimeException e) {
            logger.error("--------------------删除客户出现异常--------------------");
            throw new RuntimeException();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        try {
            customerDao.update(customer);
        } catch (RuntimeException e) {
            logger.error("--------------------修改客户信息出现异常--------------------");
            throw new RuntimeException();
        }
    }
}
