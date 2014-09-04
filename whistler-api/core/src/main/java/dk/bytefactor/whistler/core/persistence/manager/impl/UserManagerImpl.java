package dk.bytefactor.whistler.core.persistence.manager.impl;

import dk.bytefactor.whistler.core.datamodel.User;
import dk.bytefactor.whistler.core.persistence.dao.UserDao;
import dk.bytefactor.whistler.core.persistence.manager.UserManager;
import dk.bytefactor.whistler.core.persistence.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by casper on 31/08/14.
 */
@Service
public class UserManagerImpl implements UserManager {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public User saveUser(User user) {
        if( null == user.getUserId() ) {
            user.setUserId( UUID.randomUUID().toString() );
            user.setPassword(MD5.getMD5( user.getPassword() ));
            user.setToken(UUID.randomUUID().toString().replace( "-", "" ));
            user.setCreated(new Date());
            System.out.println( "User: " + user );
            userDao.createUser( user );
            return user;
        } else {
            System.out.println( "Updating user" );
            user.setPassword(MD5.getMD5( user.getPassword() ));
            return userDao.updateUser( user );
        }

    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDao.listUsers();
    }

    @Override
    @Transactional
    public void deleteUser(String userId) {
        userDao.deleteUser( userId );
    }

    @Override
    public User getUser(String userId) {
        User user = userDao.readUser( userId );
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        List<User> all = getUsers();
        for( User user : all ) {
            if( user.getLogin().toUpperCase().equals( login.toUpperCase() ))  {
                return user;
            }
        }
        return null;
    }
}
