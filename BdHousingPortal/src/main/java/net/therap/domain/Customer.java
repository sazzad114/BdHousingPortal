package net.therap.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OptimisticLockType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 5/30/12
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL)
@SessionAttributes
@Table(name = "H_CUSTOMER_DETAILS")
public class Customer {

    private long customerId;
    @Pattern(regexp = "([a-zA-Z][a-zA-Z]*\\s)*[a-zA-Z]*", message = "allow only alpha character and no consecutive spaces")
    @Size(min = 5, max = 50, message = "within 5 to 50 characters")
    private String customerName;
    @Pattern(regexp = "([a-zA-Z][a-zA-Z]*\\s)*[a-zA-Z]*", message = "allow only alpha character and no consecutive spaces")
    @Size(min = 5, max = 50, message = "within 5 to 50 characters")
    private String occupation;
    @Size(min = 20, max = 300, message = "within 20 to 100 characters")
    private String occupationDetails;
    private int familyMembers;
    @Pattern(regexp = "[0-9-+]*", message = "only numbers are allowed")
    @Size(min = 10, max = 15, message = "within 10 to 15 characters")
    private String contactNo;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;
    @Size(min = 20, max = 300, message = "within 20 to 100 characters")
    private String description;
    private long version;
    @Valid
    private User user;
    @Valid
    private Address address;
    private List<Criteria> criteriaList = new ArrayList<Criteria>();


    public Customer() {
        this.user = new User();
        this.address = new Address();
    }

    @Id
    @SequenceGenerator(name = "H_CUSTOMER_DETAILS_SEQ", sequenceName = "H_CUSTOMER_DETAILS_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "H_CUSTOMER_DETAILS_SEQ")
    @Column(name = "CUSTOMER_ID")

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "customer")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    public List<Criteria> getCriteriaList() {
        return criteriaList;
    }

    public void setCriteriaList(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_OF_BIRTH")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
