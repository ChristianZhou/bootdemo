package com.zgx.bootdemo.dao.impl;

import com.zgx.bootdemo.dao.CustomerDao;
import com.zgx.bootdemo.entity.Customer;
import com.zgx.bootdemo.entity.Page;
import org.hibernate.*;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.List;

@Repository
public class CustomerDaoImp implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Customer read(String id) {
        return sessionFactory.getCurrentSession().get(Customer.class, id);
    }

    @Override
    public List list(Customer customer) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        for (Field field : customer.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object o = field.get(customer);
                String name = field.getName();
                if (o != null) criteria.add(Restrictions.eq(name, o));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return criteria.list();

//        Session currentSession = sessionFactory.getCurrentSession();
//        StringBuilder hql = new StringBuilder(" select * from ");
//        StringBuilder hqlCust = new StringBuilder(" select * from customer  where 1=1 ");
//        for(Field field :customer.getClass().getDeclaredFields()){
//            field.setAccessible(true);
//            try {
//                Object o = field.get(customer);
//                String name = field.getName();
//                if (o != null) hqlCust.append(" and ").append(name).append(" = ").append(o.toString());
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//        String hqlBank = " select BANK_CODE,BANK_NAME FROM bank ";
//        String hqlJoin =" left join ";
//        String hqlOn = " on cust.BAN_BANK_CODE = bank.BANK_CODE";
//
//        hql.append(" ( ").append(hqlCust).append( ") as cust ").append(hqlJoin).append(" ( ").append(hqlBank).append(" )  as bank ").append(hqlOn);
//
//        SQLQuery query = currentSession.createSQLQuery(hql.toString()).addEntity(Customer.class);
//
//        return query.list();
    }

    @Override
    public List listPage(String keyword, int startIndex, int size) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        Disjunction dis = Restrictions.disjunction();
        dis.add(Restrictions.like("custCode","%"+keyword+"%"));
        dis.add(Restrictions.like("custName","%"+keyword+"%"));
        dis.add(Restrictions.like("mnemonicCode","%"+keyword+"%"));
        criteria.add(dis).setFirstResult(startIndex).setMaxResults(size);
        return criteria.list();
    }

    @Override
    public void save(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        session.save(customer);
        transaction.commit();
    }

    @Override
    public int count(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        StringBuilder hql = new StringBuilder(" select count(1) as count from Customer    where 1=1 ");
        for (Field field : customer.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object o = field.get(customer);
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
    public int count(String keyword) {
//        Session currentSession = sessionFactory.getCurrentSession();
//        StringBuilder hql = new StringBuilder(" select count(1) from Customer where ");
//        StringBuilder hqlCustomerCount = new StringBuilder();
//        String[] keyColumns = {
//                "custCode","custName","mnemonicCode"};
//        for (String keyColumn: keyColumns) {
//            hql.append(" or ").append(keyColumn).append(" like ").append(keyword);
//        }
//        Query query = currentSession.createQuery(hql.toString());
//
//        String count = query.uniqueResult().toString();
//        return Integer.parseInt(count);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        Disjunction dis = Restrictions.disjunction();
        dis.add(Restrictions.like("custCode","%"+keyword+"%"));
        dis.add(Restrictions.like("custName","%"+keyword+"%"));
        dis.add(Restrictions.like("mnemonicCode","%"+keyword+"%"));
        criteria.add(dis);
        criteria.setProjection(Projections.rowCount());
        return Integer.parseInt(criteria.uniqueResult().toString());
    }

    @Override
    public void remove(String custCode) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, custCode);
        if (customer != null) session.delete(customer);
    }

    @Override
    public void update(Customer customer) {
//        Session session = sessionFactory.getCurrentSession();
//        StringBuilder hql = new StringBuilder(" update Customer ");
//        StringBuilder hqlSet = new StringBuilder(" set ");
//        String hqlWhere = " where custCode = " + "'" + customer.getCustCode() + "'";
//        for (Field field : customer.getClass().getDeclaredFields()) {
//            field.setAccessible(true);
//            try {
//                Object o = field.get(customer);
//                String name = field.getName();
//                if (o != null) {
//                    hqlSet.append(name).append(" = ").append("'").append(o.toString()).append("'").append(" , ");
//                }
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(hqlSet.toString());
//        hqlSet.delete(hqlSet.lastIndexOf(" , "), hqlSet.length() - 1);
//        System.out.println(hqlSet.toString());
//
//        String hqlFinal = hql.append(hqlSet).append(hqlWhere).toString();
//        System.out.println(hqlFinal);
//        Query query = session.createQuery(hqlFinal);
//        query.executeUpdate();


        Session session = sessionFactory.getCurrentSession();
        session.update(customer);
    }
}
