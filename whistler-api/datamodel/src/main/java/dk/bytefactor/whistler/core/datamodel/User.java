package dk.bytefactor.whistler.core.datamodel;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by casper on 31/08/14.
 */
@Entity
@Table( name = "USERS" )
public class User {
    @Id
    private String userId;
    private String login;
    private String password;
    private String token;
    @OneToOne( targetEntity = Profile.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private Profile profile;
    private Date created;

    public User() {
    }

    public User(String login, String password, String token, Profile profile, Date created) {
        this.login = login;
        this.password = password;
        this.token = token;
        this.profile = profile;
        this.created = created;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", profile=" + profile +
                ", created=" + created +
                '}';
    }
}
