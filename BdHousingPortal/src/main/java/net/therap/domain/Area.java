package net.therap.domain;

import org.springframework.stereotype.Controller;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/11/12
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "H_AREA")
public class Area {

    long areaId;
    String areaName;
    public Area(String areaName){
       this.areaName = areaName;
    }
    public Area(){
        super();
    }

    @Id
    @SequenceGenerator(name = "H_AREA_SEQ",sequenceName = "H_AREA_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "H_AREA_SEQ")
    @Column(name = "AREA_ID")
    public long getAreaId() {
        return areaId;
    }

    public void setAreaId(long areaId) {
        this.areaId = areaId;
    }
    @Column(name = "AREA_NAME")
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }



}
