package net.therap.dao;

import net.therap.domain.Customer;
import net.therap.domain.User;
import org.testng.Assert;

import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;
import org.unitils.orm.hibernate.HibernateUnitils;
import org.unitils.dbunit.annotation.DataSet;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/20/12
 * Time: 9:41 AM
 * To change this template use File | Settings | File Templates.
 */


@DataSet
@SpringApplicationContext(value = {"classpath:test-applicationContext.xml"})
public class CustomerDaoTest extends UnitilsTestNG {

    @SpringBean("customerDao")
    CustomerDao customerDao;

    @Test
    public void testMappingToDatabase() {
        HibernateUnitils.assertMappingWithDatabaseConsistent();
    }

    @Test
    public void testGetCustomerById(){

      Customer actualCustomer = customerDao.getCustomerById(1L);
      Assert.assertEquals(1L,actualCustomer.getCustomerId());

    }

    @Test
    public void testGetCustomerByUser(){
        User user = new User();
        user.setUserId(1);
        user.setUserType(1);
        user.setEmail("sazzad@yahoo.com");
        user.setPassword("12345");

        Customer actualCustomer = customerDao.getCustomerByUser(user);
        Assert.assertEquals(1L,actualCustomer.getCustomerId());

    }


    @Test
    @ExpectedDataSet("CustomerDaoTest-expected-dataset.xml")
    public void testUpdateCustomer(){

        Customer customer = customerDao.getCustomerById(1L);
         customer.setCustomerName("sazzad");
        customerDao.updateCustomer(customer);

    }




}


