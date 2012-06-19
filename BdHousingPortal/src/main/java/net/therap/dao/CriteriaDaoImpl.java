package net.therap.dao;

import net.therap.domain.Criteria;
import net.therap.domain.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/11/12
 * Time: 4:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class CriteriaDaoImpl extends HibernateDaoSupport implements CriteriaDao {

    public void saveCriteria(Criteria criteria) {
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.saveOrUpdate(criteria);
        session.flush();
    }

    public Criteria getCriteriaById(long id) {
        return getHibernateTemplate().get(Criteria.class, id);
    }

    public void deleteCriteria(Customer customer, Criteria criteria) {
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery("delete Criteria as criteria where criteria.customer = :customer and criteria = :criteria");
        query.setParameter("customer", customer);
        query.setParameter("criteria", criteria);
        query.executeUpdate();
        session.flush();
    }

    public List<Criteria> getCriteriaListByCustomer(Customer customer, int startingResultSet, int pageSize) {
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery("select criteria from Criteria as criteria where criteria.customer = :customer");
        query.setParameter("customer", customer);
        query.setFirstResult(startingResultSet);
        query.setMaxResults(pageSize);
        return query.list();
    }

    public long getCriteriaCountByCustomer(Customer customer) {
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery("select count(*) from Criteria as criteria where criteria.customer = :customer");
        query.setParameter("customer", customer);
        return ((Long) query.iterate().next()).longValue();
    }
}
