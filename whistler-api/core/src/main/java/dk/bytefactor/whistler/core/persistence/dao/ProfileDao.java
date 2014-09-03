package dk.bytefactor.whistler.core.persistence.dao;

import dk.bytefactor.whistler.core.datamodel.Profile;

/**
 * Created by casper on 01/09/14.
 */
public interface ProfileDao {
    public Profile createProfile( Profile profile );
    public Profile readProfile( String profileId );
    public Profile updateProfile( Profile profile );
    public void deleteProfile( String profileId );
}
