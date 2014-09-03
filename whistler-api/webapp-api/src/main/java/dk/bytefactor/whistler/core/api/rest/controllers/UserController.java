package dk.bytefactor.whistler.core.api.rest.controllers;

import dk.bytefactor.whistler.core.api.rest.model.CreateUserRequest;
import dk.bytefactor.whistler.core.api.rest.model.CreateUserResponse;
import dk.bytefactor.whistler.core.api.rest.model.ErrorResponse;
import dk.bytefactor.whistler.core.api.rest.model.RestResponse;
import dk.bytefactor.whistler.core.datamodel.User;
import dk.bytefactor.whistler.core.persistence.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by casper on 03/09/14.
 */
@Controller
@RequestMapping( "/user" )
public class UserController {

    @Autowired
    private UserManager userManager;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody RestResponse hello( @RequestBody CreateUserRequest createUserRequest ) {
        User user = userManager.getUserByLogin( createUserRequest.getLogin() );
        if(( null == createUserRequest.getLogin() ) || ( createUserRequest.getLogin().trim().equals("")) ||
                ( null == createUserRequest.getPassword() ) || ( createUserRequest.getPassword().trim().equals(""))) {
            return new ErrorResponse( ErrorResponse.EC_NO_EMPTY_FIELDS_ALLOWED, "No empty values allowed" );
        }
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
}
