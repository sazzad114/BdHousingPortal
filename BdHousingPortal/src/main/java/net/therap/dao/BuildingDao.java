package net.therap.dao;

import net.therap.domain.Building;
import net.therap.domain.FlatOwner;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/7/12
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */
public interface BuildingDao {

    public void saveBuilding(Building building);
    public List<Building> getBuildingList(FlatOwner flatOwner);
    public Building getBuildingById(FlatOwner flatowner,long id);
    public Building getBuildingById(long id);

}
