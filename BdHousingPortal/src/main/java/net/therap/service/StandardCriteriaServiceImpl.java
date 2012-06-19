package net.therap.service;


import net.therap.dao.StandardCriteriaDao;
import net.therap.domain.Flat;
import net.therap.domain.StandardCriteria;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/10/12
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class StandardCriteriaServiceImpl implements StandardCriteriaService {

    private StandardCriteriaDao standardCriteriaDao;

    public StandardCriteriaDao getStandardCriteriaDao() {
        return standardCriteriaDao;
    }

    public void setStandardCriteriaDao(StandardCriteriaDao standardCriteriaDao) {
        this.standardCriteriaDao = standardCriteriaDao;
    }

    public StandardCriteria getStandardCriteriaByFlat(Flat flat) {
        return standardCriteriaDao.getStandardCriteriaByFlatAttributes(flat.isForRent(), flat.getNumberOfBeds(), flat.getPriceOrRent());
    }

}
