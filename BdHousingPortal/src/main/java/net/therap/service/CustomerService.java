package net.therap.service;

import net.therap.domain.Customer;
import net.therap.domain.FlatOwner;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/5/12
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerService {
       public void saveCustomer(Customer customer);
       public void updateCustomer(Customer customer);
       public Customer getCustomerById(long id);
       public List<Customer> getCustomerListByFlatOwner(FlatOwner flatOwner);
}
