package dk.bytefactor.whistler.core.persistence.manager;

import dk.bytefactor.whistler.core.datamodel.User;

import java.util.List;

/**
 * Created by casper on 31/08/14.
 */
public interface UserManager {
    public User saveUser( User user );
    public List<User> getUsers();
    public void deleteUser( String userId );
    public User getUser( String userId );
    public User getUserByLogin( String login );
}
