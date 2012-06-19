package net.therap.service;

import net.therap.dao.CriteriaDao;
import net.therap.dao.StandardCriteriaDao;
import net.therap.domain.Criteria;
import net.therap.domain.Customer;
import net.therap.domain.StandardCriteria;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/11/12
 * Time: 1:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class CriteriaServiceImpl implements CriteriaService {

    private StandardCriteriaDao standardCriteriaDao;
    private CriteriaDao criteriaDao;
    final private int PAGE_SIZE = 3;

    public StandardCriteriaDao getStandardCriteriaDao() {
        return standardCriteriaDao;
    }

    public void setStandardCriteriaDao(StandardCriteriaDao standardCriteriaDao) {
        this.standardCriteriaDao = standardCriteriaDao;
    }

    public CriteriaDao getCriteriaDao() {
        return criteriaDao;
    }

    public void setCriteriaDao(CriteriaDao criteriaDao) {
        this.criteriaDao = criteriaDao;
    }

    public boolean deleteCriteriaById(Customer customer, long id) {
        Criteria criteria = criteriaDao.getCriteriaById(id);
        criteriaDao.deleteCriteria(customer, criteria);
        return true;
    }

    public long getPageCountByCustomer(Customer customer) {
        long criteriaCount = criteriaDao.getCriteriaCountByCustomer(customer);
        if (criteriaCount % PAGE_SIZE != 0) {
            return criteriaCount / PAGE_SIZE + 1;
        }
        return criteriaCount / PAGE_SIZE;
    }

    public List<Criteria> getCriteriaListByCustomer(Customer customer, int currentPage) {
        return criteriaDao.getCriteriaListByCustomer(customer, (currentPage - 1) * PAGE_SIZE, PAGE_SIZE);
    }

    public void saveCriteriaForCustomer(Criteria criteria, Customer customer) {
        StandardCriteria standardCriteria = standardCriteriaDao.getStandardCriteriaByFlatAttributes(criteria.isForRent(), criteria.getNumberOfBeds(), criteria.getPriceOrRent());
        criteria.setCustomer(customer);
        criteria.setStandardCriteria(standardCriteria);
        criteriaDao.saveCriteria(criteria);
    }
}
