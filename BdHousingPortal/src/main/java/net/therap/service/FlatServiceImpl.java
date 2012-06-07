package net.therap.service;

import net.therap.dao.FlatDao;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/7/12
 * Time: 5:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class FlatServiceImpl implements FlatService{

    private FlatDao flatDao;

    public FlatDao getFlatDao() {
        return flatDao;
    }

    public void setFlatDao(FlatDao flatDao) {
        this.flatDao = flatDao;
    }
}
