package br.com.raphaelneves.microservices.currencyexchangeservice;

import br.com.raphaelneves.microservices.currencyexchangeservice.bean.ExchangeValue;
import br.com.raphaelneves.microservices.currencyexchangeservice.exceptions.CurrencyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Objects;

@RestController
@RequestMapping(value = "/currency-exchange")
public class CurrencyExchangeResource {

    private final Environment environment;
    private final CurrencyExchangeService service;

    @Autowired
    public CurrencyExchangeResource(Environment environment, CurrencyExchangeService service) {
        this.environment = environment;
        this.service = service;
    }

    @GetMapping(value = "/from/{from}/to/{to}")
    public ExchangeValue calculateCurrencyFromTo(@PathVariable String from, @PathVariable String to){
        ExchangeValue exchangeValue = service.getCurrencyFromTo(from.toUpperCase(), to.toUpperCase());
        if(Objects.isNull(exchangeValue))
            throw new CurrencyNotFoundException("Currency exchange " + from + " -> " + to + " not found");
        int port = Integer.parseInt(environment.getProperty("local.server.port"));
        exchangeValue.setPort(port);
        exchangeValue.setCotationDate(new Date());
        return exchangeValue;
    }


}
