package net.therap.service;

import net.therap.domain.Criteria;
import net.therap.domain.Customer;
import net.therap.domain.Flat;
import net.therap.domain.FlatOwner;

import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/7/12
 * Time: 5:44 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FlatService {
    public void saveFlat(Flat flat) throws IOException;
    public Flat getFlatById(long id);
    public byte[] getImageData(long id) throws Exception;
    public List<Flat> getFlatListByCriteria(Criteria criteria);
    public List<Flat> getFlatListByCustomer(Customer customer);
    public boolean deleteFlatById(FlatOwner flatOwner,long id);
}
