package net.therap.service;

import net.therap.dao.FlatOwnerDao;
import net.therap.dao.UserDao;
import net.therap.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/4/12
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImpl implements UserService{


    private UserDao userDao;


    private FlatOwnerDao flatOwnerDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public FlatOwnerDao getFlatOwnerDao() {
        return flatOwnerDao;
    }

    public void setFlatOwnerDao(FlatOwnerDao flatOwnerDao) {
        this.flatOwnerDao = flatOwnerDao;
    }

    public Object getUserByEmailAndPass(String email, String password) {

        User user = userDao.getUserByEmail(email);
        if( user == null || !user.getPassword().equals(password) ){

           return null;
        }
        else {

            switch (user.getUserType()){
                case User.CUSTOMERTYPE:
                case User.FLATOWNERTYPE:
                {
                   return flatOwnerDao.getFlatOwnerByUser(user);
                }
                case User.DEVELOPERTYPE:
                default:
                    return null;

            }

        }

    }

    public boolean isEmailExists(String email) {

        User user = userDao.getUserByEmail(email);
        if(user == null)
        {
            return false;
        }
        else {
            return true;
        }
    }
}
