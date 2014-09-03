package dk.bytefactor.whistler.core.persistence.dao.impl;

import dk.bytefactor.whistler.core.datamodel.User;
import dk.bytefactor.whistler.core.persistence.dao.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Created by casper on 31/08/14.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public User createUser(User user) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().persist( user );
        sessionFactory.getCurrentSession().getTransaction().commit();
        return user;
    }

    @Override
    @Transactional
    public User readUser(String userId) {
        sessionFactory.getCurrentSession().beginTransaction();
        User user = (User)sessionFactory.getCurrentSession().get( User.class, userId );
        sessionFactory.getCurrentSession().getTransaction().commit();
        return user;
    }

    @Override
    public List<User> listUsers() {
        sessionFactory.getCurrentSession().beginTransaction();
        List<User> out = sessionFactory.getCurrentSession().createQuery( "from User" ).list();
        return out;
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().update( user );
        sessionFactory.getCurrentSession().getTransaction().commit();
        return user;
    }

    @Override
    @Transactional
    public void deleteUser(String userId) {
        User user = readUser( userId );
        if( null != user ) {
            sessionFactory.getCurrentSession().delete( user );
        }
    }
}
