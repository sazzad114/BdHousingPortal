package net.therap.dao;

import net.therap.domain.Area;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/11/12
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class AreaDaoImpl extends HibernateDaoSupport implements AreaDao {

    public void saveArea(Area area) {
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.saveOrUpdate(area);
        session.flush();
    }

    public List<Area> getAreaList() {
        return getHibernateTemplate().find("from Area as area");
    }
}
