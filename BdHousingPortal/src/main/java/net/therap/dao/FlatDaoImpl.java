package net.therap.dao;

import net.therap.domain.Flat;
import org.hibernate.Session;
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

    public void saveFlat(Flat flat) {

        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.saveOrUpdate(flat);
        session.flush();
    }

    public Flat getFlatById(long id) {
        return getHibernateTemplate().get(Flat.class,id);
    }

    public Blob getImageData(long id) {
       List<Blob> blobList = getHibernateTemplate().find("select image.imageData from Image as image where image.flat.flatId = ?", new Object[]{id});
       if(blobList.size() != 0){
           return blobList.get(0);
       }
       else {
           return null;
       }
    }
}
