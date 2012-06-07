package net.therap.dao;

import net.therap.domain.Building;
import net.therap.domain.FlatOwner;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/7/12
 * Time: 2:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class BuildingDaoImpl extends HibernateDaoSupport implements BuildingDao{

    public void saveBuilding(Building building) {

        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.saveOrUpdate(building);
        session.flush();
    }

    public List<Building> getBuildingList(FlatOwner flatOwner) {
        return getHibernateTemplate().find("from Building as building where building.flatOwner = ?",new Object[]{flatOwner});
    }

    public Building getBuildingById(long id) {
        return getHibernateTemplate().get(Building.class,id);
    }
}
