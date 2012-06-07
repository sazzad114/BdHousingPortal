package net.therap.service;

import net.therap.dao.BuildingDao;
import net.therap.domain.Building;
import net.therap.domain.FlatOwner;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/7/12
 * Time: 2:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class BuildingServiceImpl implements BuildingService{

    BuildingDao buildingDao;

    public BuildingDao getBuildingDao() {
        return buildingDao;
    }

    public void setBuildingDao(BuildingDao buildingDao) {
        this.buildingDao = buildingDao;
    }

    public List<Building> getBuildingList(FlatOwner flatOwner) {
        return buildingDao.getBuildingList(flatOwner);
    }

    public void saveBuilding(Building building) {
        buildingDao.saveBuilding(building);
    }
    public Building getBuildingById(long id){
       return buildingDao.getBuildingById(id);
    }
}
