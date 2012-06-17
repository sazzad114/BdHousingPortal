package net.therap.service;

import net.therap.dao.CustomerDao;
import net.therap.domain.Customer;
import net.therap.domain.FlatOwner;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/5/12
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerServiceImpl implements CustomerService{

    CustomerDao customerDao;

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
}
