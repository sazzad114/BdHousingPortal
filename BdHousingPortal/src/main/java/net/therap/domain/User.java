package net.therap.domain;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 5/30/12
 * Time: 10:40 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
@Entity
@Table(name = "H_USER")
public class User implements Serializable {

    public static final int FLATOWNERTYPE = 2;
    public static final int CUSTOMERTYPE = 1;
    public static final int DEVELOPERTYPE = 3;
    private long userId;

    @Email(message = "email should follow the format email@domain.com")
    @Size(min = 10, max = 50, message = "within 10 to 50 characters")
    private String email;

    @Pattern(regexp = "[^\\s]*", message = "space is not allowed")
    @Size(min = 8, max = 30, message = "within 8 to 30 characters")
    private String password;

    @Pattern(regexp = "[^\\s]*", message = "space is not allowed")
    @Size(min = 8, max = 30, message = "within 8 to 30 characters")
    private String confirmPassword;
    private int userType;
    private long version;

    @Id
    @SequenceGenerator(name = "H_USER_SEQ", sequenceName = "H_USER_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "H_USER_SEQ")
    @Column(name = "USER_ID")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "USER_TYPE")
    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Version
    @Column(name = "VERSION")
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Transient
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
