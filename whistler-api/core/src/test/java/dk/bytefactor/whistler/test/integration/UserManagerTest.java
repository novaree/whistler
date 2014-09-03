package dk.bytefactor.whistler.test.integration;

import dk.bytefactor.whistler.core.datamodel.Profile;
import dk.bytefactor.whistler.core.datamodel.User;
import dk.bytefactor.whistler.core.persistence.manager.UserManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;
import java.util.logging.Logger;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by casper on 31/08/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = "classpath:applicationContext-core-test.xml")
public class UserManagerTest {
    private static final Logger LOG = Logger.getLogger( "UserManagerTest" );

    @Autowired
    UserManager userManager;

    @Test
    public void testCreateUser() {
        System.out.println( "::: Running testCreateUser :::");
        System.out.println( "- Creating user" );
        User user = new User();
        user.setLogin("testUser1");
        user.setPassword("password");
        System.out.println( "User: " + user );
        assertNotNull(userManager.saveUser(user));
        System.out.println( user );
        System.out.println( "- Creating profile" );
        Profile profile = new Profile();
        profile.setFirstName( "Test" );
        profile.setLastName("User");
        profile.setAddress1("42 Foo Street");
        profile.setZipCode("90210");
        profile.setCity("Beverly Hills");
        profile.setState("CA");
        profile.setCountry("'murica");
        profile.setEmailAddress("foo@bar.baz");
        profile.setPublicProfile(true);
        user.setProfile( profile );
        try {
            userManager.saveUser(user);
        } catch( Exception e ) {
            System.out.println( e );
        }
        String id = user.getUserId();
        user = null;
        user = userManager.getUser( id );
        System.out.println( user );
    }
}
