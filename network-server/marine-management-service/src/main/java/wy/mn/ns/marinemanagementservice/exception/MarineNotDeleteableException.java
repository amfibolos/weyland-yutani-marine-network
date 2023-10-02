package wy.mn.ns.marinemanagementservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class MarineNotDeleteableException extends RuntimeException {

    public MarineNotDeleteableException() {
    }

    public MarineNotDeleteableException(String message) {
        super(message);
    }

    public MarineNotDeleteableException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarineNotDeleteableException(Throwable cause) {
        super(cause);
    }

    public MarineNotDeleteableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
