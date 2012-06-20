package net.therap.dao;

import net.therap.domain.Customer;
import net.therap.domain.Flat;
import net.therap.domain.FlatOwner;
import net.therap.domain.StandardCriteria;

import java.sql.Blob;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/7/12
 * Time: 5:42 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FlatDao {

    public void saveFlat(Flat flat);

    public Flat getFlatById(long id);

    public Blob getImageData(long id);

    public List<Flat> getFlatListByCriteriaAndArea(StandardCriteria standardCriteria, String area);

    public List<Flat> getFlatListByCustomer(Customer customer);

    public void deleteFlat(FlatOwner flatOwner, Flat flat);
}
