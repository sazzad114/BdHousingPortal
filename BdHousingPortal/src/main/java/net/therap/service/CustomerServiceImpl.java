package net.therap.service;

import net.therap.dao.CustomerDao;
import net.therap.dao.StandardCriteriaDao;
import net.therap.domain.Criteria;
import net.therap.domain.Customer;
import net.therap.domain.FlatOwner;
import net.therap.domain.StandardCriteria;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/5/12
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerServiceImpl implements CustomerService{

    private CustomerDao customerDao;
    private StandardCriteriaDao standardCriteriaDao;

    public StandardCriteriaDao getStandardCriteriaDao() {
        return standardCriteriaDao;
    }

    public void setStandardCriteriaDao(StandardCriteriaDao standardCriteriaDao) {
        this.standardCriteriaDao = standardCriteriaDao;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    public Customer getCustomerById(long id) {
        return customerDao.getCustomerById(id);
    }

    public List<Customer> getCustomerListByFlatOwner(FlatOwner flatOwner) {
        return customerDao.getCustomerListByFlatOwner(flatOwner);
    }

    public List<Customer> getCustomerListByCriteria(Criteria criteria) {

        StandardCriteria standardCriteria = standardCriteriaDao.getStandardCriteriaByFlatAttributes(criteria.isForRent(),criteria.getNumberOfBeds(),criteria.getPriceOrRent());
        List<Customer> customerList = customerDao.getCustomerListByStdCriteriaAndArea(standardCriteria,criteria.getArea());
        return customerList;
    }
}
