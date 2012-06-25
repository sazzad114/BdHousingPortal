package net.therap.dao;

import net.therap.domain.Area;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/11/12
 * Time: 11:19 AM
 * To change this template use File | Settings | File Templates.
 */
public interface AreaDao {

    public void saveArea(Area area);

    public List<Area> getAreaList();
}
