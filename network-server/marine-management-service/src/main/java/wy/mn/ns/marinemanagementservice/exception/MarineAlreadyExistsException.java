package wy.mn.ns.marinemanagementservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MarineAlreadyExistsException extends RuntimeException {

    public MarineAlreadyExistsException() {
    }

    public MarineAlreadyExistsException(String message) {
        super(message);
    }

    public MarineAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarineAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public MarineAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
