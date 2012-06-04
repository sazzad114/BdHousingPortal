package net.therap.dao;

import net.therap.domain.User;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/4/12
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {

       public User getUserByEmail(String email);
}
