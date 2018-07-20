package br.com.raphaelneves.microservices.currencyconversionservice.integrations;

import br.com.raphaelneves.microservices.currencyconversionservice.beans.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {
    String BASE_SERVICE_URL = "currency-exchange";

    @GetMapping(value = BASE_SERVICE_URL + "/from/{from}/to/{to}")
    CurrencyConversion getCurrencyExchangeFromTo(@PathVariable("from") String from, @PathVariable("to") String to);
}
