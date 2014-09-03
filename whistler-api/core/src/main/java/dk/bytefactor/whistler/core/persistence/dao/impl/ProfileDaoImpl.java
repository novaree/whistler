package dk.bytefactor.whistler.core.persistence.dao.impl;

import dk.bytefactor.whistler.core.datamodel.Profile;
import dk.bytefactor.whistler.core.persistence.dao.ProfileDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by casper on 01/09/14.
 */
@Repository
public class ProfileDaoImpl implements ProfileDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Profile createProfile(Profile profile) {
        return null;
    }

    @Override
    public Profile readProfile(String profileId) {
        return null;
    }

    @Override
    public Profile updateProfile(Profile profile) {
        return null;
    }

    @Override
    public void deleteProfile(String profileId) {

    }
}
