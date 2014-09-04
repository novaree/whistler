package dk.bytefactor.whistler.core.api.rest.model;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Created by casper on 04/09/14.
 */
public class CreateProfileRequest implements RestRequest {
    private String login;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String address1;
    @JsonIgnore
    private String address2;
    private String zipCode;
    private String city;
    @JsonIgnore
    private String state;
    private String country;
    private boolean publicProfile;

    public CreateProfileRequest() {}

    public CreateProfileRequest(String login, String firstName, String lastName, String emailAddress, String address1, String address2, String zipCode, String city, String state, String country, boolean publicProfile) {
        this.login = login;
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
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    @Override
    public boolean validate() {
        if(( null == login ) || ( login.trim().equals( "" )) ||
                ( null == firstName ) || ( firstName.trim().equals( "" )) ||
                ( null == lastName ) || ( lastName.trim().equals( "" )) ||
                ( null == emailAddress ) || ( emailAddress.trim().equals( "" )) ||
                ( null == address1 ) || ( address1.trim().equals( "" )) ||
                ( null == zipCode ) || ( zipCode.trim().equals( "" )) ||
                ( null == city ) || ( city.trim().equals( "" )) ||
                ( null == country ) || ( country.trim().equals( "" ))) {
            return false;
        }
        return true;
    }
}
