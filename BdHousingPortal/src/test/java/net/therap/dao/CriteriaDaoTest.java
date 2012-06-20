package net.therap.dao;

import net.therap.domain.Criteria;
import net.therap.domain.Customer;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.orm.hibernate.HibernateUnitils;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/20/12
 * Time: 12:56 PM
 * To change this template use File | Settings | File Templates.
 */
@DataSet
@SpringApplicationContext(value = {"classpath:test-applicationContext.xml"})
public class CriteriaDaoTest extends UnitilsTestNG{

    @SpringBean("criteriaDao")
    CriteriaDao criteriaDao;

    @SpringBean("customerDao")
    CustomerDao customerDao;

    @Test
    public void testMappingToDatabase() {
        HibernateUnitils.assertMappingWithDatabaseConsistent();
    }

    @Test
    @ExpectedDataSet("CriteriaDaoTest-expected-dataset.xml")
    public void testDeleteCriteria(){
        Criteria criteria = criteriaDao.getCriteriaById(1L);
        Customer customer = customerDao.getCustomerById(1L);
        criteriaDao.deleteCriteria(customer,criteria);
    }
}
