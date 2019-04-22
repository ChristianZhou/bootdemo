package com.zgx.bootdemo.dao.impl;

import com.zgx.bootdemo.dao.BankDao;
import com.zgx.bootdemo.entity.Bank;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhouguixing
 * @date 2019/4/16 18:42
 * @description 银行Dao层实现类
 */
@Repository
public class BankDaoImpl implements BankDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Bank read(String id) throws RuntimeException {
        return sessionFactory.getCurrentSession().get(Bank.class, id);
    }

    @Override
    public List list() throws RuntimeException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Bank.class);
        return criteria.list();
    }

    @Override
    public void save(Bank bank) throws RuntimeException {
        Session session = sessionFactory.getCurrentSession();
        session.save(bank);
    }

    @Override
    public void delete(String bankCode) throws RuntimeException {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Bank where bankCode=:bankCode ");
        query.setParameter("bankCode",bankCode);
        query.executeUpdate();
    }

    @Override
    public void update(Bank bank) throws RuntimeException {
        Session session = sessionFactory.getCurrentSession();
        session.update(bank);
    }
}
