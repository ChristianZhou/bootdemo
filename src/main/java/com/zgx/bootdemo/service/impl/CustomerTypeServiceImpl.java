package com.zgx.bootdemo.service.impl;

import com.zgx.bootdemo.dao.CustomerTypeDao;
import com.zgx.bootdemo.entity.CustomerType;
import com.zgx.bootdemo.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhouguixing
 * @date 2019/4/27 4:12
 * @description
 */
@Service
@Transactional
public class CustomerTypeServiceImpl implements CustomerTypeService {

    @Autowired
    private CustomerTypeDao customerTypeDao;
    @Override
    public List<CustomerType> list() {
        return customerTypeDao.list();
    }
}
