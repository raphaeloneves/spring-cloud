package br.com.raphaelneves.microservices.limitsservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LimitBoundaryException extends RuntimeException {
    public LimitBoundaryException() {
    }

    public LimitBoundaryException(String message) {
        super(message);
    }
}
