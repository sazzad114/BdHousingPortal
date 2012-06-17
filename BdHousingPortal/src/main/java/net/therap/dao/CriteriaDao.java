package net.therap.dao;

import net.therap.domain.Criteria;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/11/12
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CriteriaDao {
    public void saveCriteria(Criteria criteria);
    public Criteria getCriteriaById(long id);
    public void deleteCriteria(Criteria criteria);
}

