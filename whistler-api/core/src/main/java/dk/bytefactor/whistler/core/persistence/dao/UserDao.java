package dk.bytefactor.whistler.core.persistence.dao;

import dk.bytefactor.whistler.core.datamodel.User;

import java.util.List;

/**
 * Created by casper on 31/08/14.
 */
public interface UserDao {
    public User createUser(User user);
    public User readUser( String userId );
    public List<User> listUsers();
    public User updateUser( User user );
    public void deleteUser( String userId );
}
