package wy.mn.ns.marinemanagementservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MarineNotFoundException extends RuntimeException {

    public MarineNotFoundException() {
    }

    public MarineNotFoundException(String message) {
        super(message);
    }

    public MarineNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarineNotFoundException(Throwable cause) {
        super(cause);
    }

    public MarineNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
