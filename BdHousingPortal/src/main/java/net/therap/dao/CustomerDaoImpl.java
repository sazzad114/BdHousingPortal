package net.therap.dao;

import net.therap.domain.Criteria;
import net.therap.domain.Customer;
import net.therap.domain.FlatOwner;
import net.therap.domain.User;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/5/12
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{
    public void saveCustomer(Customer customer) {

        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.saveOrUpdate(customer);
        session.flush();

    }

    public Customer getCustomerByUser(User user) {


        Object[] objects = new Object[1];
        objects[0] = user;
        List<Customer> customerList = getHibernateTemplate().find(" from Customer as customer where customer.user = ? ",objects);

        if(customerList.size() == 0){

            return null;
        }
        else {
            return customerList.get(0);
        }
    }

    public Customer getCustomerById(long id) {

        return getHibernateTemplate().get(Customer.class,id);
    }

    public void updateCustomer(Customer customer) {

       Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.update(customer);
        session.flush();
    }

    public List<Customer> getCustomerListByFlatOwner(FlatOwner flatOwner) {

       String subQuery = "select stdc,flat.building.address.area from StandardCriteria as stdc,Flat as flat where flat.standardCriteria = stdc and flat.building.flatOwner = ?";
       return getHibernateTemplate().find("select distinct customer from Customer as customer,Criteria as criteria where criteria.customer = customer and (criteria.standardCriteria,criteria.area) in (" +subQuery+")", new Object[]{flatOwner});
    }

    public boolean removeCriteria(Customer customer, long criteriaId) {
       Criteria criteriaToRemove = null;
        for (Criteria criteria: customer.getCriteriaList()){
            if(criteria.getCriteriaId() == criteriaId){
              criteriaToRemove = criteria;
                break;
            }
        }

        if(criteriaToRemove == null) {
            return false;
        }

        customer.getCriteriaList().remove(criteriaToRemove);
        updateCustomer(customer);
        return true;
    }
}
