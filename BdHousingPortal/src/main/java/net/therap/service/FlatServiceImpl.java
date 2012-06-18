package net.therap.service;

import net.therap.dao.BuildingDao;
import net.therap.dao.FlatDao;
import net.therap.dao.StandardCriteriaDao;
import net.therap.domain.*;
import net.therap.exception.ApplicationException;
import org.hibernate.Hibernate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/7/12
 * Time: 5:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class FlatServiceImpl implements FlatService {

    private FlatDao flatDao;
    private StandardCriteriaService standardCriteriaService;
    private BuildingDao buildingDao;
    private StandardCriteriaDao standardCriteriaDao;

    public StandardCriteriaDao getStandardCriteriaDao() {
        return standardCriteriaDao;
    }

    public void setStandardCriteriaDao(StandardCriteriaDao standardCriteriaDao) {
        this.standardCriteriaDao = standardCriteriaDao;
    }



    public BuildingDao getBuildingDao() {
        return buildingDao;
    }

    public void setBuildingDao(BuildingDao buildingDao) {
        this.buildingDao = buildingDao;
    }

    public StandardCriteriaService getStandardCriteriaService() {
        return standardCriteriaService;
    }

    public void setStandardCriteriaService(StandardCriteriaService standardCriteriaService) {
        this.standardCriteriaService = standardCriteriaService;
    }

    public FlatDao getFlatDao() {
        return flatDao;
    }

    public void setFlatDao(FlatDao flatDao) {
        this.flatDao = flatDao;
    }

    public void saveFlat(Flat flat) throws IOException {


        Image image = new Image();
        int flatTypeCount = flat.getBuilding().getFlatTypeCount();
        flat.getBuilding().setFlatTypeCount(flatTypeCount + 1);
        flat.setTypeNumber(flatTypeCount + 1);
        buildingDao.saveBuilding(flat.getBuilding());
        StandardCriteria standardCriteria = standardCriteriaService.getStandardCriteriaByFlat(flat);
        flat.setStandardCriteria(standardCriteria);
        standardCriteria.getFlatList().add(flat);
        image.setImageData(Hibernate.createBlob(flat.getImageFile().getInputStream()));
        flat.setFlatImage(image);
        image.setFlat(flat);
        flatDao.saveFlat(flat);
    }

    public Flat getFlatById(long id) {

        Flat flat = flatDao.getFlatById(id);
        return flat;

    }

    public byte[] getImageData(long id) throws Exception{

            Blob imageData = flatDao.getImageData(id);

            if(imageData == null)
            {
                 throw new Exception();
            }

            byte[] bytes = new byte[(int) imageData.length()];

            imageData.getBinaryStream().read(bytes);
            imageData.getBinaryStream().close();
            return bytes;


    }

    public List<Flat> getFlatListByCriteria(Criteria criteria) {

        StandardCriteria standardCriteria = standardCriteriaDao.getStandardCriteriaByFlatAttributes(criteria.isForRent(), criteria.getNumberOfBeds(), criteria.getPriceOrRent());
        return flatDao.getFlatListByCriteriaAndArea(standardCriteria, criteria.getArea());
    }

       public List<Flat> getFlatListByCustomer(Customer customer) {
        List<Flat> flatList;
        flatList = flatDao.getFlatListByCustomer(customer);
        return flatList;
    }

    public boolean deleteFlatById(FlatOwner flatOwner, long id) {
       Flat flat = flatDao.getFlatById(id);

       if(flat.getBuilding().getFlatOwner().getFlatOwnerId() != flatOwner.getFlatOwnerId()){
          return false;
       }
       else {
          flatDao.deleteFlatById(flatOwner,flat);
          return true;
       }
    }

}
