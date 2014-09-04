package dk.bytefactor.whistler.core.api.rest.model;

/**
 * Created by casper on 04/09/14.
 */
public class SimpleResponse implements RestResponse {
    public static final int OK = 200;

    private String message;
    private int status;

    public SimpleResponse() {}

    public SimpleResponse( String msg, int status ) {
        this.message = msg;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
