package net.therap.dao;

import net.therap.controller.anonymous.FlatOwnerRegController;
import net.therap.domain.Criteria;
import net.therap.domain.Customer;
import net.therap.domain.Flat;
import net.therap.domain.StandardCriteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/10/12
 * Time: 4:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class StandardCriteriaDaoImpl extends HibernateDaoSupport implements StandardCriteriaDao{

    private static final Logger log = LoggerFactory.getLogger(StandardCriteriaDaoImpl.class);

    public List<Flat> getFlatListByCriteriaAndArea(StandardCriteria standardCriteria,String area) {
      return  getHibernateTemplate().find("select flat from Flat as flat where flat.standardCriteria = ? and  flat.building.address.area = ?",new Object[]{standardCriteria,area});
    }

    public List<Customer> getCustomerListByStdCriteriaAndArea(StandardCriteria standardCriteria, String area) {

       String subQuery = "select criteria from Criteria as criteria where criteria.standardCriteria = ? and criteria.area = ?";
       return getHibernateTemplate().find("select distinct customer from Customer as customer,Criteria as criteria where criteria in elements(customer.criteriaList) and criteria in("+subQuery+")",new Object[]{standardCriteria,area});

    }

    public List<Flat> getFlatListByCustomer(Customer customer) {
       String subQuery = "select stdc,criteria.area from StandardCriteria as stdc,Criteria as criteria where criteria.standardCriteria = stdc and criteria.customer = ?";
       return getHibernateTemplate().find("select distinct flat from Flat as flat where (flat.standardCriteria,flat.building.address.area) in (" +subQuery+")", new Object[]{customer});
    }

    public StandardCriteria getStandardCriteriaByFlatAttributes(boolean isForRent, int numberOfBeds, int priceOrRent) {
        Object[] objects = new Object[5];
        objects[0] = isForRent;
        objects[1] =numberOfBeds;
        objects[2] = numberOfBeds;
        objects[3] =priceOrRent;
        objects[4] = priceOrRent;
        List<StandardCriteria> standardCriteriaList = getHibernateTemplate().find(" from StandardCriteria as stdcriteria where stdcriteria.forRent = ? " +
                "and stdcriteria.minNumberOfBeds <= ? and stdcriteria.maxNumberOfBeds >= ? and stdcriteria.minPriceOrRent <= ? and stdcriteria.maxPriceOrRent >= ?",objects);

        if(standardCriteriaList.size() == 0){

            return null;
        }
        else {
            return standardCriteriaList.get(0);
        }

    }
}
