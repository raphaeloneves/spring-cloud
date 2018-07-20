package br.com.raphaelneves.microservices.currencyconversionservice;

import br.com.raphaelneves.microservices.currencyconversionservice.beans.CurrencyConversion;
import br.com.raphaelneves.microservices.currencyconversionservice.exceptions.CurrencyExchangeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class CurrencyConversionConsumer {

    public CurrencyConversion applyCurrencyExchange(String from, String to) {
        final String url = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";
        Map<String, String> params = new HashMap<>();
        params.put("from", from);
        params.put("to", to);
        ResponseEntity<CurrencyConversion> forEntity = new RestTemplate().getForEntity(url, CurrencyConversion.class, params);
        if(forEntity.getStatusCode().equals(HttpStatus.OK))
            return forEntity.getBody();
        throw new CurrencyExchangeException("Could not apply currency exchange");
    }
}
