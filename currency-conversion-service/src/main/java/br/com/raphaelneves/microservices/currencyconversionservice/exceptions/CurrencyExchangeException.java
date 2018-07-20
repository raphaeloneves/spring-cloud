package br.com.raphaelneves.microservices.currencyconversionservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CurrencyExchangeException extends RuntimeException {
    public CurrencyExchangeException(String message) {
        super(message);
    }

    public CurrencyExchangeException() {
    }
}
