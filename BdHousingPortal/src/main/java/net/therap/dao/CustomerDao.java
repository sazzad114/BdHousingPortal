package net.therap.dao;

import net.therap.domain.Customer;
import net.therap.domain.FlatOwner;
import net.therap.domain.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/5/12
 * Time: 3:31 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerDao {
        public void saveCustomer(Customer customer);
        public Customer getCustomerByUser(User user);
        public Customer getCustomerById(long id);
        public void updateCustomer(Customer customer);
        public List<Customer> getCustomerListByFlatOwner(FlatOwner flatOwner);
        public boolean removeCriteria(Customer customer,long criteriaId);
}
