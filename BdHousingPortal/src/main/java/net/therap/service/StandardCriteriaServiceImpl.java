package net.therap.service;


import net.therap.dao.StandardCriteriaDao;
import net.therap.domain.Criteria;
import net.therap.domain.Customer;
import net.therap.domain.Flat;
import net.therap.domain.StandardCriteria;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/10/12
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class StandardCriteriaServiceImpl implements StandardCriteriaService{

    public StandardCriteriaDao getStandardCriteriaDao() {
        return standardCriteriaDao;
    }

    public void setStandardCriteriaDao(StandardCriteriaDao standardCriteriaDao) {
        this.standardCriteriaDao = standardCriteriaDao;
    }

    private StandardCriteriaDao standardCriteriaDao;

    public StandardCriteria getStandardCriteriaByFlat(Flat flat) {
       return standardCriteriaDao.getStandardCriteriaByFlatAttributes(flat.isForRent(), flat.getNumberOfBeds(), flat.getPriceOrRent());
    }

    public List<Customer> getCustomerListByCriteria(Criteria criteria) {
        StandardCriteria standardCriteria = standardCriteriaDao.getStandardCriteriaByFlatAttributes(criteria.isForRent(),criteria.getNumberOfBeds(),criteria.getPriceOrRent());
        List<Customer> customerList = standardCriteriaDao.getCustomerListByStdCriteriaAndArea(standardCriteria,criteria.getArea());
        return customerList;
    }

    public List<Flat> getFlatListByCriteria(Criteria criteria) {

        StandardCriteria standardCriteria = standardCriteriaDao.getStandardCriteriaByFlatAttributes(criteria.isForRent(), criteria.getNumberOfBeds(), criteria.getPriceOrRent());
        return standardCriteriaDao.getFlatListByCriteriaAndArea(standardCriteria, criteria.getArea());
    }
}
