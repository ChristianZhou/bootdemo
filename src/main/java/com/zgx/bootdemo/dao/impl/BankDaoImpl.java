package com.zgx.bootdemo.dao.impl;

import com.zgx.bootdemo.dao.BankDao;
import com.zgx.bootdemo.entity.Bank;
import com.zgx.bootdemo.entity.Customer;
import org.hibernate.*;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
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
    public Bank read(String id) {
        return sessionFactory.getCurrentSession().get(Bank.class, id);
    }

    @Override
    public List list(Bank bank) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Bank.class);
        for(Field field : bank.getClass().getDeclaredFields()){
            field.setAccessible(true);
            try {
                Object o = field.get(bank);
                String name = field.getName();
                if (o != null) criteria.add(Restrictions.like(name, o));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return criteria.list();
    }

    @Override
    public List list() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        return criteria.list();
    }

    @Override
    public void save(Bank bank) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        session.save(bank);
        transaction.commit();
    }

    @Override
    public int count(Bank bank) {
        Session currentSession = sessionFactory.getCurrentSession();
        StringBuilder hql = new StringBuilder(" select count(1) as count from Bank    where 1=1 ");
        for (Field field : bank.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object o = field.get(bank);
                String name = field.getName();
                if (o != null) hql.append(" and ").append(name).append(" = ").append(o.toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        Query query = currentSession.createQuery(hql.toString());
        String count = query.uniqueResult().toString();
        return Integer.parseInt(count);
    }

    @Override
    public void remove(String bankCode) {
        Session session = sessionFactory.getCurrentSession();
        Bank bank = session.get(Bank.class, bankCode);
        if(bank !=null)session.delete(bank);
    }

    @Override
    public void update(String bankCode, String bankName) {
        Session session = sessionFactory.getCurrentSession();
        Bank bank = new Bank();
        bank.setBankCode(bankCode);
        bank.setBankName(bankName);
        session.update(bank);
    }

}
