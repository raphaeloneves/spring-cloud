package br.com.raphaelneves.microservices.currencyconversionservice;

import br.com.raphaelneves.microservices.currencyconversionservice.beans.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/currency-converter")
public class CurrencyConversionResource {


    private final CurrencyConversionService service;

    @Autowired
    public CurrencyConversionResource(CurrencyConversionService service) {
        this.service = service;
    }

    @GetMapping(value = "/from/{from}/to/{to}/amount/{amount}")
    public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal amount){
        return service.converteCurrencyFromTo(from, to, amount);
    }
}
