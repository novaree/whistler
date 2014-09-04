package dk.bytefactor.whistler.core.api.rest.model;

/**
 * Created by casper on 04/09/14.
 */
public class ResetPasswordRequest implements RestRequest {
    private String login;
    private String email;

    public ResetPasswordRequest() {
    }

    public ResetPasswordRequest( String login, String email ) {
        this.login = login;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean validate() {
        if(( null == login ) || ( null == email ) ||
                ( login.trim().equals( "" )) || ( email.trim().equals( "" ))) {
            return false;
        }
        return true;
    }
}
