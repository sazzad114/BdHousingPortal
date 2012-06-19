package net.therap.dao;

import net.therap.domain.*;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.sql.Blob;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/7/12
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class FlatDaoImpl extends HibernateDaoSupport implements FlatDao {

    private static final Logger log = LoggerFactory.getLogger(FlatDaoImpl.class);

    public void saveFlat(Flat flat) {

        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.saveOrUpdate(flat);
        session.flush();
    }

    public Flat getFlatById(long id) {
        return getHibernateTemplate().get(Flat.class, id);
    }

    public void deleteFlatById(FlatOwner flatOwner, Flat flat) {

        log.debug("#####" + flat.getFlatId() + "###" + flatOwner.getFlatOwnerId());
        Building building = flat.getBuilding();
        building.setFlatTypeCount(building.getFlatTypeCount() - 1);
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.delete(flat);
        session.update(building);
        session.flush();
    }

    public Blob getImageData(long id) {
        List<Blob> blobList = getHibernateTemplate().find("select image.imageData from Image as image where image.flat.flatId = ?", new Object[]{id});
        if (blobList.size() != 0) {
            return blobList.get(0);
        } else {
            return null;
        }
    }

    public List<Flat> getFlatListByCriteriaAndArea(StandardCriteria standardCriteria, String area) {
        return getHibernateTemplate().find("select flat from Flat as flat where flat.standardCriteria = ? and  flat.building.address.area = ?", new Object[]{standardCriteria, area});
    }

    public List<Flat> getFlatListByCustomer(Customer customer) {
        String subQuery = "select stdc,criteria.area from StandardCriteria as stdc,Criteria as criteria where criteria.standardCriteria = stdc and criteria.customer = ?";
        return getHibernateTemplate().find("select distinct flat from Flat as flat where (flat.standardCriteria,flat.building.address.area) in (" + subQuery + ")", new Object[]{customer});
    }
}
