package net.therap.service;

import net.therap.dao.FlatOwnerDao;
import net.therap.domain.FlatOwner;
import net.therap.domain.User;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/3/12
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class FlatOwnerServiceImpl implements FlatOwnerService {

    public FlatOwnerDao getFlatOwnerDao() {
        return flatOwnerDao;
    }

    public void setFlatOwnerDao(FlatOwnerDao flatOwnerDao) {
        this.flatOwnerDao = flatOwnerDao;
    }

    private FlatOwnerDao flatOwnerDao;

    public boolean isEmailExists(String email) {
        User user = flatOwnerDao.getUserByEmail(email);
        if(user == null)
        {
            return false;
        }
        else {
            return true;
        }
    }

    public void saveFlatOwner(FlatOwner flatOwner) {
        flatOwnerDao.saveFlatUser(flatOwner);
    }
}
