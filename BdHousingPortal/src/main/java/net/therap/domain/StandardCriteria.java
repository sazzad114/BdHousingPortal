package net.therap.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 5/30/12
 * Time: 11:59 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "H_STANDARD_CRITERIA")
public class StandardCriteria {

    private long standardCriteriaId;
    private boolean forRent;
    private int minNumberOfBeds;
    private int maxNumberOfBeds;
    private int minPriceOrRent;
    private int maxPriceOrRent;
    private long version;
    private List<Flat> flatList = new ArrayList<Flat>();
    private List<Criteria> criteriaList = new ArrayList<Criteria>();

    @Id
    @SequenceGenerator(name = "H_STANDARD_CRITERIA_SEQ", sequenceName = "H_STANDARD_CRITERIA_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "H_STANDARD_CRITERIA_SEQ")
    @Column(name = "STANDARD_CRITERIA_ID")
    public long getStandardCriteriaId() {
        return standardCriteriaId;
    }

    public void setStandardCriteriaId(long standardCriteriaId) {
        this.standardCriteriaId = standardCriteriaId;
    }

    @OneToMany(mappedBy = "standardCriteria")
    public List<Flat> getFlatList() {
        return flatList;
    }

    public void setFlatList(List<Flat> flatList) {
        this.flatList = flatList;
    }

    @OneToMany(mappedBy = "standardCriteria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Criteria> getCriteriaList() {
        return criteriaList;
    }

    public void setCriteriaList(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Column(name = "IS_FOR_RENT")
    @Type(type = "true_false")
    public boolean getForRent() {
        return forRent;
    }

    public void setForRent(boolean forRent) {
        this.forRent = forRent;
    }

    @Column(name = "MIN_NUMBER_OF_BEDS")
    public int getMinNumberOfBeds() {
        return minNumberOfBeds;
    }

    public void setMinNumberOfBeds(int minNumberOfBeds) {
        this.minNumberOfBeds = minNumberOfBeds;
    }

    @Column(name = "MAX_NUMBER_OF_BEDS")
    public int getMaxNumberOfBeds() {
        return maxNumberOfBeds;
    }

    public void setMaxNumberOfBeds(int maxNumberOfBeds) {
        this.maxNumberOfBeds = maxNumberOfBeds;
    }

    @Column(name = "MIN_PRICE_OR_RENT")
    public int getMinPriceOrRent() {
        return minPriceOrRent;
    }

    public void setMinPriceOrRent(int minPriceOrRent) {
        this.minPriceOrRent = minPriceOrRent;
    }

    @Column(name = "MAX_PRICE_OR_RENT")
    public int getMaxPriceOrRent() {
        return maxPriceOrRent;
    }

    public void setMaxPriceOrRent(int maxPriceOrRent) {
        this.maxPriceOrRent = maxPriceOrRent;
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
