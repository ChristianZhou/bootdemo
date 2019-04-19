package com.zgx.bootdemo.dao.impl;

import com.zgx.bootdemo.dao.CustomerDao;
import com.zgx.bootdemo.entity.Customer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDaoImp implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Customer read(String id) throws RuntimeException {
        return sessionFactory.getCurrentSession().get(Customer.class, id);
    }

    @Override
    public List listPage(String keyword, int startIndex, int size)  throws RuntimeException{
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        Disjunction dis = Restrictions.disjunction();
        dis.add(Restrictions.like("custCode","%"+keyword+"%"));
        dis.add(Restrictions.like("custName","%"+keyword+"%"));
        dis.add(Restrictions.like("mnemonicCode","%"+keyword+"%"));
        criteria.add(dis).setFirstResult(startIndex).setMaxResults(size);
        return criteria.list();
    }

    @Override
    public void save(Customer customer)  throws RuntimeException{
        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
    }

    @Override
    public Long count(String keyword)  throws RuntimeException{
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        Disjunction dis = Restrictions.disjunction();
        dis.add(Restrictions.like("custCode","%"+keyword+"%"));
        dis.add(Restrictions.like("custName","%"+keyword+"%"));
        dis.add(Restrictions.like("mnemonicCode","%"+keyword+"%"));
        criteria.add(dis);
        criteria.setProjection(Projections.rowCount());
        return (Long)criteria.uniqueResult();
    }

    @Override
    public void delete(String custCode)  throws RuntimeException{
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Customer where custCode=? ");
        query.setString(0, custCode);
        query.executeUpdate();
    }

    @Override
    public void update(Customer customer)  throws RuntimeException{
        Session session = sessionFactory.getCurrentSession();
        session.update(customer);
    }
}
