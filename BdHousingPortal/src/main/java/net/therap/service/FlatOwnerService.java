package net.therap.service;

import net.therap.domain.FlatOwner;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/3/12
 * Time: 12:48 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FlatOwnerService {

    public void saveFlatOwner(FlatOwner flatOwner);

    public FlatOwner getFlatOwnerById(long id);

}
