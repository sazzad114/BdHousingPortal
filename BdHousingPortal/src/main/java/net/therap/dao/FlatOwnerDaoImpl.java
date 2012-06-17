package net.therap.dao;

import net.therap.domain.FlatOwner;
import net.therap.domain.User;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/3/12
 * Time: 12:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class FlatOwnerDaoImpl extends HibernateDaoSupport implements FlatOwnerDao{

    private static final Logger log = LoggerFactory.getLogger(FlatOwnerDaoImpl.class);

    /*public User getUserByEmail(String email) {

        Object[] objects = new Object[1];
        objects[0] = email;
        List<User> userList = getHibernateTemplate().find(" from User as user where user.email = ? ",objects);

        if(userList.size() == 0){

            return null;
        }
        else {
            return userList.get(0);
        }

    }*/

   public void saveFlatUser(FlatOwner flatOwner) {
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.saveOrUpdate(flatOwner);
        session.flush();
    }

   public FlatOwner getFlatOwnerByUser(User user) {
        Object[] objects = new Object[1];
        objects[0] = user;
        List<FlatOwner> flatOwnerList = getHibernateTemplate().find(" from FlatOwner as flatOwner where flatOwner.user = ? ",objects);

        if(flatOwnerList.size() == 0){

            return null;
        }
        else {
            return flatOwnerList.get(0);
        }
   }

    public FlatOwner getFlatOwnerById(long id) {
        return getHibernateTemplate().get(FlatOwner.class,id);
    }
}
