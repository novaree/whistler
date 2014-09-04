package dk.bytefactor.whistler.core.api.rest.model;

/**
 * Created by casper on 04/09/14.
 */
public class UpdatePasswordRequest implements RestRequest {
    private String login;
    private String newPassword;

    public UpdatePasswordRequest() {}

    public UpdatePasswordRequest( String login, String newPassword ) {
        this.login = login;
        this.newPassword = newPassword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public boolean validate() {
        return false;
    }
}
