package net.therap.dao;

import net.therap.domain.User;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/4/12
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

    public User getUserByEmail(String email) {

        Object[] objects = new Object[1];
        objects[0] = email;
        List<User> userList = getHibernateTemplate().find(" from User as user where user.email = ? ",objects);

        if(userList.size() == 0){

            return null;
        }
        else {
            return userList.get(0);
        }
    }
}
