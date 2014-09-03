package dk.bytefactor.whistler.core.datamodel;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by casper on 31/08/14.
 */
@Entity
@Table( name = "PROFILES" )
public class Profile {
    @Id
    private String profileId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String address1;
    private String address2;
    private String zipCode;
    private String city;
    private String state;
    private String country;
    private boolean publicProfile;
    private Date created;
    private Date updated;

    public Profile() {
        this.profileId = UUID.randomUUID().toString();
        this.created = new Date();
    }

    public Profile(String firstName, String lastName, String emailAddress, String address1, String address2, String zipCode, String city, String state, String country, boolean publicProfile, Date created, Date updated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address1 = address1;
        this.address2 = address2;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.publicProfile = publicProfile;
        this.created = created;
        this.updated = updated;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isPublicProfile() {
        return publicProfile;
    }

    public void setPublicProfile(boolean publicProfile) {
        this.publicProfile = publicProfile;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileId='" + profileId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", publicProfile=" + publicProfile +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
