package net.therap.service;

import net.therap.domain.Criteria;
import net.therap.domain.Customer;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/11/12
 * Time: 1:08 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CriteriaService {

    public void saveCriteriaForCustomer(Criteria criteria, Customer customer);

    public boolean deleteCriteriaById(Customer customer, long id);

    public List<Criteria> getCriteriaListByCustomer(Customer customer, int currentPage);

    public long getPageCountByCustomer(Customer customer);
}
