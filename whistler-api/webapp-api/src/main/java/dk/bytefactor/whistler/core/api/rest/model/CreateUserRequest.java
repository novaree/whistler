package dk.bytefactor.whistler.core.api.rest.model;

/**
 * Created by casper on 03/09/14.
 */
public class CreateUserRequest {
    private String login;
    private String password;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String login, String password) {
        this.login = login;
        this.password = password;
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
}
