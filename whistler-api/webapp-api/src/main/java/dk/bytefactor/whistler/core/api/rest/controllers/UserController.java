package dk.bytefactor.whistler.core.api.rest.controllers;

import dk.bytefactor.whistler.core.api.rest.model.*;
import dk.bytefactor.whistler.core.datamodel.Profile;
import dk.bytefactor.whistler.core.datamodel.User;
import dk.bytefactor.whistler.core.persistence.manager.UserManager;
import dk.bytefactor.whistler.core.persistence.util.MD5;
import dk.bytefactor.whistler.core.persistence.util.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

/**
 * Created by casper on 03/09/14.
 */
@Controller
@RequestMapping( "/user" )
public class UserController {

    @Autowired
    private UserManager userManager;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody RestResponse createUser( @RequestBody CreateUserRequest createUserRequest ) {
        if( !createUserRequest.validate() ) {
            return new ErrorResponse( ErrorResponse.EC_NO_EMPTY_FIELDS_ALLOWED, "No empty values allowed" );
        }
        User user = userManager.getUserByLogin( createUserRequest.getLogin() );
        if( null != user ) {
            return new ErrorResponse( ErrorResponse.EC_LOGIN_ALREADY_REGISTERED, "Login already registered" );
        } else {
            user = new User();
            user.setLogin( createUserRequest.getLogin() );
            user.setPassword( createUserRequest.getPassword() );
            user = userManager.saveUser( user );
            CreateUserResponse response = new CreateUserResponse( user );
            return response;
        }
    }

    @RequestMapping( value = "/resetPassword", method = RequestMethod.POST)
    public @ResponseBody RestResponse resetPassword( @RequestBody ResetPasswordRequest resetPasswordRequest ) {
        if( !resetPasswordRequest.validate() ) {
            return new ErrorResponse( ErrorResponse.EC_NO_EMPTY_FIELDS_ALLOWED, "No empty values allowed" );
        }
        User user = userManager.getUserByLogin( resetPasswordRequest.getLogin() );
        if( null == user.getProfile() ) {
            return new ErrorResponse( ErrorResponse.EC_NO_PROFILE_ATTACHED, "Cannot validate email address, no profile created." );
        }
        // TODO: Refactor to own class
        // TODO: Reconsider approach..
        // Set new password
        String password = RandomString.randomString( 8 );
        user.setPassword(MD5.getMD5(password) );
        userManager.saveUser( user );
        System.out.println( "Updated " + resetPasswordRequest.getLogin() + "s password to " + password );
        return new SimpleResponse( "Password changed", SimpleResponse.OK );
    }

    @RequestMapping( value = "/updatePassword", method = RequestMethod.POST )
    public @ResponseBody RestResponse updatePassword( @RequestBody UpdatePasswordRequest updatePasswordRequest ) {
        if( !updatePasswordRequest.validate() ) {
            return new ErrorResponse( ErrorResponse.EC_NO_EMPTY_FIELDS_ALLOWED, "No empty values allowed" );
        }
        User user = userManager.getUserByLogin(updatePasswordRequest.getLogin());
        if( null == user ) {
            return new ErrorResponse( ErrorResponse.EC_NO_PROFILE_ATTACHED, "Cannot find user, no password updated." );
        }
        user.setPassword( MD5.getMD5( updatePasswordRequest.getNewPassword() ));
        userManager.saveUser( user );
        return new SimpleResponse( "Password changed", SimpleResponse.OK );
    }

    @RequestMapping( value = "/createProfile", method = RequestMethod.POST )
    public @ResponseBody RestResponse createProfile( @RequestBody CreateProfileRequest createProfileRequest ) {
        if( !createProfileRequest.validate() ) {
            return new ErrorResponse( ErrorResponse.EC_NO_EMPTY_FIELDS_ALLOWED, "No empty values allowed" );
        }
        User user = userManager.getUserByLogin(createProfileRequest.getLogin());
        if( null == user ) {
            return new ErrorResponse( ErrorResponse.EC_NO_PROFILE_ATTACHED, "Cannot find user, no profile created." );
        }
        Profile profile = new Profile( createProfileRequest.getFirstName(),
                createProfileRequest.getLastName(),
                createProfileRequest.getEmailAddress(),
                createProfileRequest.getAddress1(),
                createProfileRequest.getAddress2(),
                createProfileRequest.getZipCode(),
                createProfileRequest.getCity(),
                createProfileRequest.getState(),
                createProfileRequest.getCountry(),
                createProfileRequest.isPublicProfile(),
                new Date(),
                null );
        profile.setProfileId(UUID.randomUUID().toString() );
        user.setProfile( profile );
        userManager.saveUser( user );
        return new CreateProfileResponse( user );
    }

    @RequestMapping( value = "/updateProfile", method = RequestMethod.POST )
    public @ResponseBody RestResponse updateProfile( @RequestBody UpdateProfileRequest updateProfileRequest ) {
        if( !updateProfileRequest.validate() ) {
            return new ErrorResponse( ErrorResponse.EC_NO_EMPTY_FIELDS_ALLOWED, "No empty values allowed" );
        }
        User user = userManager.getUserByLogin(updateProfileRequest.getLogin());
        if( null == user ) {
            return new ErrorResponse( ErrorResponse.EC_NO_PROFILE_ATTACHED, "Cannot find user, no profile updated." );
        }
        Profile profile = user.getProfile();
        profile.setPublicProfile( updateProfileRequest.isPublicProfile() );
        profile.setEmailAddress( updateProfileRequest.getEmailAddress() );
        profile.setCountry( updateProfileRequest.getCountry() );
        profile.setAddress1( updateProfileRequest.getAddress1() );
        profile.setAddress2( updateProfileRequest.getAddress2() );
        profile.setFirstName( updateProfileRequest.getFirstName() );
        profile.setCity( updateProfileRequest.getCity() );
        profile.setLastName( updateProfileRequest.getLastName() );
        profile.setState( updateProfileRequest.getState() );
        profile.setZipCode( updateProfileRequest.getZipCode() );
        profile.setUpdated( new Date() );
        userManager.saveUser( user );
        return new UpdateProfileResponse( user );
    }

    @RequestMapping( value = "/viewProfile/{login}", method = RequestMethod.GET )
    public @ResponseBody RestResponse viewProfile( @PathVariable( value = "login" ) String login ) {
        if(( null == login )  || ( login.trim().equals( "" ))) {
            return new ErrorResponse( ErrorResponse.EC_NO_EMPTY_FIELDS_ALLOWED, "No empty values allowed" );
        }
        User user = userManager.getUserByLogin( login );
        if( null == user ) {
            return new ErrorResponse( ErrorResponse.EC_NO_PROFILE_ATTACHED, "Cannot find user, no profile updated." );
        }
        return new ViewProfileResponse( user );
    }
}
