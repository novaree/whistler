package dk.bytefactor.whistler.core.api.rest.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by casper on 04/09/14.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler( Exception.class )
    public String exception( Exception e ) {
        System.out.println( e.getMessage() );
        return "foo";
    }
}
