package com.zgx.bootdemo.service.impl;

import com.zgx.bootdemo.dao.CustomerDao;
import com.zgx.bootdemo.entity.Customer;
import com.zgx.bootdemo.entity.KeywordPage;
import com.zgx.bootdemo.entity.Page;
import com.zgx.bootdemo.service.CustomerSerivce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerSerivceImpl implements CustomerSerivce {

    @Autowired
    private CustomerDao customerDao;

    private Logger logger = LoggerFactory.getLogger(CustomerSerivceImpl.class);
    

    @Override
    public Customer read(Long custCode){
        return customerDao.read(custCode);
    }

    @Override
    public Page<Customer> listPage(KeywordPage keywordPage) {
        String keyword = keywordPage.getKeyword();
        Long total = customerDao.count(keyword);
        List list = customerDao.listPage(keywordPage);
        Page<Customer> page = keywordPage.getPage();
        page.setList(list);
        page.setTotalSize(total);
        return page;
    }

    @Override
    public List listByType(Long custTypeCode) {
        return customerDao.listByType(custTypeCode);
    }

    @Override
    public List listByTypeAndKeyword(Long custTypeCode, String keyword) {
        return customerDao.listByTypeAndKeyword(custTypeCode,keyword);
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
    public void delete(Long customerId) {
        try {
            customerDao.delete(customerId);
        } catch (RuntimeException e) {
            logger.error("--------------------删除客户出现异常--------------------");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void update(Customer customer) {
        try {
            customerDao.update(customer);
        } catch (RuntimeException e) {
            logger.error("--------------------修改客户信息出现异常--------------------");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
