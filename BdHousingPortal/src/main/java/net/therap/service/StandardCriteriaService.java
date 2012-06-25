package net.therap.service;

import net.therap.domain.Criteria;
import net.therap.domain.Customer;
import net.therap.domain.Flat;
import net.therap.domain.StandardCriteria;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/10/12
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */
public interface StandardCriteriaService {

    public StandardCriteria getStandardCriteriaByFlat(Flat flat);
}
