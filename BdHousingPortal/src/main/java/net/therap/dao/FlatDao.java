package net.therap.dao;

import net.therap.domain.Flat;

import java.sql.Blob;

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
}
