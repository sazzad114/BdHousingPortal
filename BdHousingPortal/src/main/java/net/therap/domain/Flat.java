package net.therap.domain;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Blob;
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
@Table(name = "H_FLAT")
public class Flat {
    private long flatId;
    @Min(value = 1,message = "minimum 1 flat")
    private int numberOfFlats;
    @Min(value = 50,message = "minimum 50 square feet flat")
    private int totalArea;
    @Min(value = 1,message = "minimum 1 room flat")
    private int numberOfRooms;
    @Min(value = 1,message = "minimum 1 bed flat")
    private int numberOfBeds;
    private boolean forRent;
    @Min(value = 1,message = "value should be greater than 1")
    private int priceOrRent;
    @Size(min = 10,max = 100)
    private String description;
    private long version;
    private StandardCriteria standardCriteria;
    private Building building;
    private int typeNumber;
    private List<Integer> flatInFloors = new ArrayList<Integer>();
    private MultipartFile imageFile;
    private Image flatImage;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "flat")
    public Image getFlatImage() {
        return flatImage;
    }

    public void setFlatImage(Image flatImage) {
        this.flatImage = flatImage;
    }

    /*private Image flatImage;*/





    @Transient
    public MultipartFile getImageFile() {
        return imageFile;
    }


    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

/*    @Basic(fetch = FetchType.LAZY,optional = true)*/




    @Id
    @SequenceGenerator(name = "H_FLAT_SEQ", sequenceName = "H_FLAT_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "H_FLAT_SEQ")
    @Column(name = "FLAT_ID")
    public long getFlatId() {
        return flatId;
    }

    public void setFlatId(long flatId) {
        this.flatId = flatId;
    }

    @CollectionOfElements
    @JoinTable(name = "H_FLAT_FLOOR", joinColumns = {@JoinColumn(name = "FLAT_ID")})
    @Column(name = "FLOOR")
    public List<Integer> getFlatInFloors() {
        return flatInFloors;
    }
    public void setFlatInFloors(List<Integer> flatInFloors) {
        this.flatInFloors = flatInFloors;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "H_BUILDING_FLAT", joinColumns = @JoinColumn(name = "FLAT_ID"),
            inverseJoinColumns = @JoinColumn(name = "BUILDING_ID"))
    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Column(name = "TYPE_NUMBER")
    public int getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(int typeNumber) {
        this.typeNumber = typeNumber;
    }

    @Column(name = "NUMBER_OF_FLATS")
    public int getNumberOfFlats() {
        return numberOfFlats;
    }

    public void setNumberOfFlats(int numberOfFlats) {
        this.numberOfFlats = numberOfFlats;
    }

    @Column(name = "TOTAL_AREA")
    public int getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(int totalArea) {
        this.totalArea = totalArea;
    }

    @Column(name = "NUMBER_OF_ROOMS")
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Column(name = "NUMBER_OF_BEDS")
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    @Column(name = "IS_FOR_RENT")
    @Type(type = "true_false")
    public boolean isForRent() {
        return forRent;
    }

    public void setForRent(boolean forRent) {
        this.forRent = forRent;
    }

    @Column(name = "PRICE_OR_RENT")
    public int getPriceOrRent() {
        return priceOrRent;
    }

    public void setPriceOrRent(int priceOrRent) {
        this.priceOrRent = priceOrRent;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Version
    @Column(name = "VERSION")
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @ManyToOne
    @JoinColumn(name = "STANDARD_CRITERIA_ID")
    public StandardCriteria getStandardCriteria() {
        return standardCriteria;
    }

    public void setStandardCriteria(StandardCriteria standardCriteria) {
        this.standardCriteria = standardCriteria;
    }



}
