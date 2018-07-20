package br.com.raphaelneves.microservices.currencyconversionservice;

import br.com.raphaelneves.microservices.currencyconversionservice.beans.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class CurrencyConversionService {

    private final CurrencyConversionConsumer consumer;

    @Autowired
    public CurrencyConversionService(CurrencyConversionConsumer consumer) {
        this.consumer = consumer;
    }

    public CurrencyConversion converteCurrencyFromTo(String from, String to, BigDecimal amount){
        CurrencyConversion currencyConversion = consumer.applyCurrencyExchange(from, to);
        currencyConversion.setAmount(amount);
        currencyConversion.setConversionDate(new Date());
        currencyConversion.setConvertedAmount(amount.multiply(currencyConversion.getConvertionMultiple()));
        return currencyConversion;
    }
}
