package br.com.raphaelneves.microservices.currencyconversionservice;

import br.com.raphaelneves.microservices.currencyconversionservice.beans.CurrencyConversion;
import br.com.raphaelneves.microservices.currencyconversionservice.integrations.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyConversionConsumer {

    private final CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    @Autowired
    public CurrencyConversionConsumer(CurrencyExchangeServiceProxy currencyExchangeServiceProxy) {
        this.currencyExchangeServiceProxy = currencyExchangeServiceProxy;
    }

    public CurrencyConversion applyCurrencyExchange(String from, String to) {
        return currencyExchangeServiceProxy.getCurrencyExchangeFromTo(from, to);
    }
}
