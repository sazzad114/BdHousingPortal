package net.therap.dao;

import net.therap.domain.StandardCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/10/12
 * Time: 4:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class StandardCriteriaDaoImpl extends HibernateDaoSupport implements StandardCriteriaDao {

    private static final Logger log = LoggerFactory.getLogger(StandardCriteriaDaoImpl.class);

    public StandardCriteria getStandardCriteriaByFlatAttributes(boolean isForRent, int numberOfBeds, int priceOrRent) {
        Object[] objects = new Object[5];
        objects[0] = isForRent;
        objects[1] = numberOfBeds;
        objects[2] = numberOfBeds;
        objects[3] = priceOrRent;
        objects[4] = priceOrRent;
        List<StandardCriteria> standardCriteriaList = getHibernateTemplate().find(" from StandardCriteria as stdcriteria where stdcriteria.forRent = ? " +
                "and stdcriteria.minNumberOfBeds <= ? and stdcriteria.maxNumberOfBeds >= ? and stdcriteria.minPriceOrRent <= ? and stdcriteria.maxPriceOrRent >= ?", objects);

        if (standardCriteriaList.size() == 0) {
            return null;
        } else {
            return standardCriteriaList.get(0);
        }
    }
}
