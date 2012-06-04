package net.therap.domain;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 5/30/12
 * Time: 11:40 AM
 * To change this template use File | Settings | File Templates.
 */

@Component
@Embeddable
public class Address {
    @Size(min = 1,max = 8,message = "within 2 to 8 characters")
    private String houseNo;
    @Size(min = 1,max = 8,message = "within 2 to 8 characters")
    private String roadNo;
    @Size(min = 4,max = 30,message = "within 8 to 30 characters")
    private String area;
    @Size(min = 4,max = 30,message = "within 8 to 30 characters")
    private String thana;
    @Size(min = 4,max = 30,message = "within 8 to 30 characters")
    private String district;

    @Column(name = "THANA")
    public String getThana() {
        return thana;
    }

    public void setThana(String thana) {
        this.thana = thana;
    }
    @Column(name = "DISTRICT")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
    @Column(name = "AREA")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    @Column(name = "ROAD_NO")
    public String getRoadNo() {
        return roadNo;
    }

    public void setRoadNo(String roadNo) {
        this.roadNo = roadNo;
    }
    @Column(name = "HOUSE_NO")
    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }
}
