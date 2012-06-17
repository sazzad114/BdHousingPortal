package net.therap.service;

import net.therap.domain.Flat;

import java.io.IOException;

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
}
