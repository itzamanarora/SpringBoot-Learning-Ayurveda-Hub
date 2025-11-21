package networkArora.ayurvedaHub.exception;

import org.springframework.http.HttpStatus;

public class apiException extends RuntimeException{

    private final HttpStatus status;

    public apiException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
