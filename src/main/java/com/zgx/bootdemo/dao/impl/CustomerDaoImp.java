package com.zgx.bootdemo.dao.impl;

import com.zgx.bootdemo.dao.CustomerDao;
import com.zgx.bootdemo.entity.Customer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public List listPage(String keyword, int offSet, int limit,String orderKey)  throws RuntimeException{
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        Disjunction dis = Restrictions.disjunction();
        dis.add(Restrictions.like("custCode",keyword, MatchMode.ANYWHERE));
        dis.add(Restrictions.like("custName",keyword, MatchMode.ANYWHERE));
        dis.add(Restrictions.like("mnemonicCode",keyword, MatchMode.ANYWHERE));
        if (!"".equals(orderKey)) {
            criteria.addOrder(Order.asc(orderKey));
        }
        criteria.add(dis).setFirstResult(offSet).setMaxResults(limit);
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
        dis.add(Restrictions.like("custCode",keyword, MatchMode.ANYWHERE));
        dis.add(Restrictions.like("custName",keyword, MatchMode.ANYWHERE));
        dis.add(Restrictions.like("mnemonicCode",keyword, MatchMode.ANYWHERE));
        criteria.add(dis);
        criteria.setProjection(Projections.rowCount());
        return (Long)criteria.uniqueResult();
    }

    @Override
    public void delete(String custCode)  throws RuntimeException{
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Customer where custCode=:custCode ");
        query.setParameter("custCode",custCode);
        query.executeUpdate();
    }

    @Override
    public void update(Customer customer)  throws RuntimeException{
        Session session = sessionFactory.getCurrentSession();
        session.update(customer);
    }
}
