package dk.bytefactor.whistler.core.api.rest.model;

/**
 * Created by casper on 03/09/14.
 */
public class ErrorResponse implements RestResponse {
    // Field validation errors
    public static final int EC_NO_EMPTY_FIELDS_ALLOWED = 100;

    // Profile related errors
    public static final int EC_NO_PROFILE_ATTACHED = 200;

    // Entity validation errors
    public static final int EC_LOGIN_ALREADY_REGISTERED = 400;

    private String message;
    private int errorCode;

    public ErrorResponse() {}

    public ErrorResponse( int error, String msg ) {
        this.errorCode = error;
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
