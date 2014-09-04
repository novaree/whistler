package dk.bytefactor.whistler.core.api.rest.model;

import dk.bytefactor.whistler.core.datamodel.User;

/**
 * Created by casper on 04/09/14.
 */
public class ViewProfileResponse implements RestResponse {
    private User user;

    public ViewProfileResponse() {}

    public ViewProfileResponse( User user ) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
