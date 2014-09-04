package dk.bytefactor.whistler.core.api.rest.model;

import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * Created by casper on 04/09/14.
 */
public class ExceptionResponse implements RestResponse {
    private int status;
    private String message;
    private String developerMessage;
    private List<ObjectError> errors;

    public ExceptionResponse() {}

    public ExceptionResponse( int status, String message, String developerMessage, List errors ) {
        this.status = status;
        this.message = message;
        this.developerMessage = developerMessage;
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }
}
