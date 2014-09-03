package dk.bytefactor.whistler.core.api.rest.model;

import dk.bytefactor.whistler.core.datamodel.User;

import java.util.Date;

/**
 * Created by casper on 03/09/14.
 */
public class CreateUserResponse implements RestResponse {
    private String userId;
    private String login;
    private String token;
    private Date created;

    public CreateUserResponse() {
        super();
    }

    public CreateUserResponse( User user ) {
        this.setUserId( user.getUserId() );
        this.setLogin( user.getLogin() );
        this.setToken( user.getToken() );
        this.setCreated( user.getCreated() );
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
