package net.therap.service;

import net.therap.dao.FlatOwnerDao;
import net.therap.dao.UserDao;
import net.therap.domain.FlatOwner;
import net.therap.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/3/12
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class FlatOwnerServiceImpl implements FlatOwnerService {

    private FlatOwnerDao flatOwnerDao;

    public FlatOwnerDao getFlatOwnerDao() {
        return flatOwnerDao;
    }

    public void setFlatOwnerDao(FlatOwnerDao flatOwnerDao) {
        this.flatOwnerDao = flatOwnerDao;
    }

    public void saveFlatOwner(FlatOwner flatOwner) {
        flatOwnerDao.saveFlatUser(flatOwner);
    }

    public FlatOwner getFlatOwnerById(long id) {
        return flatOwnerDao.getFlatOwnerById(id);
    }
}
