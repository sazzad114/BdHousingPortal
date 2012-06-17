package net.therap.dao;

import net.therap.domain.Criteria;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/11/12
 * Time: 4:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class CriteriaDaoImpl extends HibernateDaoSupport implements CriteriaDao{

    public void saveCriteria(Criteria criteria) {
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.saveOrUpdate(criteria);
        session.flush();
    }

    public Criteria getCriteriaById(long id) {
        return getHibernateTemplate().get(Criteria.class,id);
    }

    public void deleteCriteria(Criteria criteria) {
       Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
       session.delete(criteria);
       session.flush();
    }
}
