package net.therap.service;

import net.therap.dao.CriteriaDao;
import net.therap.dao.CustomerDao;
import net.therap.dao.StandardCriteriaDao;
import net.therap.domain.Criteria;
import net.therap.domain.Customer;
import net.therap.domain.Flat;
import net.therap.domain.StandardCriteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/11/12
 * Time: 1:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class CriteriaServiceImpl implements CriteriaService{
    StandardCriteriaService standardCriteriaService;
    StandardCriteriaDao standardCriteriaDao;
    CriteriaDao criteriaDao;
    CustomerDao customerDao;

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

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

    public StandardCriteriaService getStandardCriteriaService() {
        return standardCriteriaService;
    }

    public void setStandardCriteriaService(StandardCriteriaService standardCriteriaService) {
        this.standardCriteriaService = standardCriteriaService;
    }

    public List<Flat> getFlatListByCriteria(Criteria criteria){
        return standardCriteriaService.getFlatListByCriteria(criteria);
    }


    public boolean deleteCriteriaById(Customer customer, long id) {
        return customerDao.removeCriteria(customer,id);
    }

    public void saveCriteriaForCustomer(Criteria criteria, Customer customer) {

        StandardCriteria standardCriteria = standardCriteriaDao.getStandardCriteriaByFlatAttributes(criteria.isForRent(),criteria.getNumberOfBeds(),criteria.getPriceOrRent());
        customer.getCriteriaList().add(criteria);
        criteria.setCustomer(customer);
        criteria.setStandardCriteria(standardCriteria);
        criteriaDao.saveCriteria(criteria);
    }

    public List<Customer> getCustomerListByCriteria(Criteria criteria) {

        List<Customer> customerList = standardCriteriaService.getCustomerListByCriteria(criteria);
        return customerList;
    }

    public List<Flat> getFlatListByCustomer(Customer customer) {
        List<Flat> flatList;
        flatList = standardCriteriaDao.getFlatListByCustomer(customer);
        return flatList;
    }



}
