package com.zgx.bootdemo.dao.impl;

import com.zgx.bootdemo.dao.CustomerDao;
import com.zgx.bootdemo.dao.CustomerTypeDao;
import com.zgx.bootdemo.entity.CustomerType;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhouguixing
 * @date 2019/4/27 4:00
 * @description
 */
@Repository
public class CustomerTypeDaoImpl implements CustomerTypeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CustomerType> list() throws RuntimeException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CustomerType.class);
        return criteria.list();
    }
}
