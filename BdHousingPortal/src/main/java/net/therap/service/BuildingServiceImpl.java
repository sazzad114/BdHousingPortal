package net.therap.service;

import net.therap.dao.AreaDao;
import net.therap.dao.BuildingDao;
import net.therap.domain.Area;
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
public class BuildingServiceImpl implements BuildingService {

    private BuildingDao buildingDao;
    private AreaDao areaDao;

    public AreaDao getAreaDao() {
        return areaDao;
    }

    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }

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
        areaDao.saveArea(new Area(building.getAddress().getArea()));
        buildingDao.saveBuilding(building);
    }

    public Building getBuildingById(FlatOwner flatowner, long id) {
        return buildingDao.getBuildingById(flatowner, id);
    }

    public Building getBuildingById(long id) {
        return buildingDao.getBuildingById(id);
    }

    public boolean deleteBuildingById(FlatOwner flatOwner, long id) {
        return buildingDao.deleteBuildingById(flatOwner, id);
    }
}
