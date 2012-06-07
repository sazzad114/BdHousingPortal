package net.therap.service;

import net.therap.domain.Building;
import net.therap.domain.FlatOwner;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/7/12
 * Time: 2:16 PM
 * To change this template use File | Settings | File Templates.
 */
public interface BuildingService {

    public void saveBuilding(Building building);
    public List<Building> getBuildingList(FlatOwner flatOwner);
    public Building getBuildingById(long id);
}
