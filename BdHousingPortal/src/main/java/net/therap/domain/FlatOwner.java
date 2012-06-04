package net.therap.domain;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 5/30/12
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
@Entity
@Table(name = "H_FLAT_OWNER")
public class FlatOwner {

    private long flatOwnerId;

    @Pattern(regexp = "([a-zA-Z][a-zA-Z]*\\s)*[a-zA-Z]*",message = "allow only alpha character and no consecutive spaces")
    @Size(min = 5,max = 50,message = "within 5 to 50 characters")
    private String flatOwnerName;

    @Pattern(regexp = "([a-zA-Z][a-zA-Z]*\\s)*[a-zA-Z]*",message = "allow only alpha character and no consecutive spaces")
    @Size(min = 5,max = 50,message = "within 5 to 50 characters")
    private String occupation;

    @Size(min = 20,max = 300,message = "within 20 to 100 characters")
    private String occupationDetails;

    @Pattern(regexp = "[0-9-+]*",message = "only numbers are allowed")
    @Size(min = 10,max = 15,message = "within 10 to 15 characters")
    private String contactNo;

    private int age;

    @Size(min = 20,max = 300,message = "within 20 to 100 characters")
    private String description;

    private long version;

    @Valid
    private User user;
    @Valid
    private Address address;

    public FlatOwner(){
        this.user = new User();
        this.address = new Address();
    }

    @Id
    @SequenceGenerator(name = "H_FLAT_OWNER_SEQ",sequenceName = "H_FLAT_OWNER_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "H_FLAT_OWNER_SEQ")
    @Column(name = "FLAT_OWNER_ID")
    public long getFlatOwnerId() {
        return flatOwnerId;
    }

    public void setFlatOwnerId(long flatOwnerId) {
        this.flatOwnerId = flatOwnerId;
    }
    @OneToOne(cascade = CascadeType.ALL)
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
    @Column(name = "FLAT_OWNER_NAME")
    public String getFlatOwnerName() {
        return flatOwnerName;
    }

    public void setFlatOwnerName(String flatOwnerName) {
        this.flatOwnerName = flatOwnerName;
    }

    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
