package com.zgx.bootdemo.dao.impl;

import com.zgx.bootdemo.dao.CustomerDao;
import com.zgx.bootdemo.entity.Bank;
import com.zgx.bootdemo.entity.Customer;
import com.zgx.bootdemo.entity.KeywordPage;
import com.zgx.bootdemo.entity.Page;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImp implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Customer read(Long id) throws RuntimeException {
        return sessionFactory.getCurrentSession().get(Customer.class, id);
    }

    @Override
    public List listPage(KeywordPage keywordPage)  throws RuntimeException{
        String keyword= keywordPage.getKeyword();
        Page page = keywordPage.getPage();
        int offset =0;
        int limit = 10;
        String sortField = "";
        Integer sortBy = 1;
        if (page != null) {
            if (page.getOffset() != null)
                offset=page.getOffset();
            if (page.getLimit() != null)
                limit = page.getLimit();
            if (page.getLimit() != null)
                limit = page.getLimit();
            if (page.getSortField() != null) {
                sortField = page.getSortField();
                sortBy = page.getSortBy();
            }
        }
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        Disjunction dis = Restrictions.disjunction();
        dis.add(Restrictions.sqlRestriction("CAST(CUST_CODE AS CHAR) like ?", keyword, StandardBasicTypes.STRING));
//        dis.add(Restrictions.like("custCode",String.valueOf(keyword), MatchMode.ANYWHERE));
        dis.add(Restrictions.like("custName",keyword, MatchMode.ANYWHERE));
        dis.add(Restrictions.like("mnemonicCode",keyword, MatchMode.ANYWHERE));
        if (!"".equals(sortField)) {
            criteria.addOrder(sortBy>0?Order.asc(sortField):Order.desc(sortField));
        }
        criteria.add(dis).setFirstResult(offset).setMaxResults(limit);
        List list = criteria.list();
        return list;
    }


    public List listByType(Long custTypeCode)  throws RuntimeException{
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        if(custTypeCode!=null)
            criteria.add(Restrictions.eq("customerType.custTypeCode",custTypeCode));
        return criteria.list();
    }

    @Override
    public List listByTypeAndKeyword(Long custTypeCode, String keyword) throws RuntimeException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        if(custTypeCode!=null)
            criteria.add(Restrictions.eq("customerType.custTypeCode",custTypeCode));
        Disjunction dis = Restrictions.disjunction();
        dis.add(Restrictions.sqlRestriction("CAST(CUST_CODE AS CHAR) like ?", keyword, StandardBasicTypes.STRING));
//        dis.add(Restrictions.like("custCode",String.valueOf(keyword), MatchMode.ANYWHERE));
        dis.add(Restrictions.like("custName",keyword, MatchMode.ANYWHERE));
        dis.add(Restrictions.like("mnemonicCode",keyword, MatchMode.ANYWHERE));
        criteria.add(dis);
        return criteria.list();
    }

    @Override
    public void save(Customer customer)  throws RuntimeException{
        Session session = sessionFactory.getCurrentSession();
        if (customer.getBank() == null||customer.getBank().getBankCode()==null) {
            Bank bank = new Bank();
            bank.setBankCode(0L);
            customer.setBank(bank);
        }
        session.save(customer);
    }

    @Override
    public Long count(String keyword)  throws RuntimeException{
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        Disjunction dis = Restrictions.disjunction();
//        dis.add(Restrictions.like("custCode",keyword, MatchMode.ANYWHERE));
        dis.add(Restrictions.sqlRestriction("CAST(CUST_CODE AS CHAR) like ?", keyword, StandardBasicTypes.STRING));
        dis.add(Restrictions.like("custName",keyword, MatchMode.ANYWHERE));
        dis.add(Restrictions.like("mnemonicCode",keyword, MatchMode.ANYWHERE));
        criteria.add(dis);
        criteria.setProjection(Projections.rowCount());
        return (Long)criteria.uniqueResult();
    }

    @Override
    public void delete(Long custCode)  throws RuntimeException{
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
