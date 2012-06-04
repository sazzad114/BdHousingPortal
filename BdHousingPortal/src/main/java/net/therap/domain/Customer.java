package net.therap.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 5/30/12
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "H_CUSTOMER_DETAILS")
public class Customer {

    private long customerId;
    private String customerName;
    private String occupation;
    private String occupationDetails;
    private int familyMembers;
    private String contactNo;
    private int age;
    private String description;
    private long version;
    private User user;
    private Address address;
    private List<Criteria> criteriaList = new ArrayList<Criteria>();



    @Id
    @SequenceGenerator(name = "H_CUSTOMER_DETAILS_SEQ",sequenceName = "H_CUSTOMER_DETAILS_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "H_CUSTOMER_DETAILS_SEQ")
    @Column(name = "CUSTOMER_ID")


    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @OneToMany(mappedBy = "customer")
    public List<Criteria> getCriteriaList() {
        return criteriaList;
    }

    public void setCriteriaList(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @OneToOne
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Version
    @Column(name = "VERSION")
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Column(name = "AGE")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Column(name = "CONTACT_NO")
    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Column(name = "FAMILY_MEMBERS")
    public int getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(int familyMembers) {
        this.familyMembers = familyMembers;
    }

    @Column(name = "OCCUPATION_DETAILS")
    public String getOccupationDetails() {
        return occupationDetails;
    }

    public void setOccupationDetails(String occupationDetails) {
        this.occupationDetails = occupationDetails;
    }
    @Column(name = "OCCUPATION")
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    @Column(name = "CUSTOMER_NAME")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
