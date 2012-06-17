package net.therap.service;

import net.therap.dao.BuildingDao;
import net.therap.dao.FlatDao;
import net.therap.domain.Flat;
import net.therap.domain.Image;
import net.therap.domain.StandardCriteria;
import net.therap.exception.ApplicationException;
import org.hibernate.Hibernate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

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

}
