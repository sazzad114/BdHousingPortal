package net.therap.domain;



import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 5/30/12
 * Time: 11:59 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "H_CRITERIA")
public class Criteria {
    private long criteriaId;
    private int numberOfBeds;
    private int area;
    private boolean forRent;
    private int priceOrRent;
    private Customer customer;
    private StandardCriteria standardCriteria;
    private long version;

    @Id
    @SequenceGenerator(name = "H_CRITERIA_SEQ",sequenceName = "H_CRITERIA_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "H_CRITERIA_SEQ")
    public long getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(long criteriaId) {
        this.criteriaId = criteriaId;
    }

    @Column(name = "NUMBER_OF_BEDS")
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }
    @Column(name = "AREA")
    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
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
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "STANDARD_CRITERIA_ID")
    public StandardCriteria getStandardCriteria() {
        return standardCriteria;
    }

    public void setStandardCriteria(StandardCriteria standardCriteria) {
        this.standardCriteria = standardCriteria;
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
