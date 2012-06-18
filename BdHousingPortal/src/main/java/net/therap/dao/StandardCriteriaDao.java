package net.therap.dao;

import net.therap.domain.Criteria;
import net.therap.domain.Customer;
import net.therap.domain.Flat;
import net.therap.domain.StandardCriteria;
import org.hibernate.property.Getter;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/10/12
 * Time: 4:48 PM
 * To change this template use File | Settings | File Templates.
 */
public interface StandardCriteriaDao {

    public StandardCriteria getStandardCriteriaByFlatAttributes(boolean isForRent,int numberOfBeds,int priceOrRent);

}
