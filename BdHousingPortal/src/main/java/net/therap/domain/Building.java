package net.therap.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 5/30/12
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */


@Entity
@Table(name ="H_BUILDING")
public class Building {

   private long buildingId;
   private int numberOfFloors;
   @Size(min = 3,max = 50,message = "within 3 to 50 characters")
   private String buildingName;
   @Valid
   private Address address;
   private FlatOwner flatOwner;
   private long version;



    private List<Flat> flatList = new ArrayList<Flat>();

    @Id
    @SequenceGenerator(name = "H_BUILDING_SEQ",sequenceName = "H_BUILDING_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "H_BUILDING_SEQ")
    @Column(name = "BUILDING_ID")
    public long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(long buildingId) {
        this.buildingId = buildingId;
    }

    @OneToMany(mappedBy = "building")
    public List<Flat> getFlatList() {
        return flatList;
    }

    public void setFlatList(List<Flat> flatList) {
        this.flatList = flatList;
    }
    @Column(name = "NUMBER_OF_FLOORS")
    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Column(name = "BUILDING_NAME")
    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToOne
    @JoinColumn(name = "FLAT_OWNER_ID")
    public FlatOwner getFlatOwner() {
        return flatOwner;
    }

    public void setFlatOwner(FlatOwner flatOwner) {
        this.flatOwner = flatOwner;
    }

    @Version
    @Column(name = "VERSION")
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
