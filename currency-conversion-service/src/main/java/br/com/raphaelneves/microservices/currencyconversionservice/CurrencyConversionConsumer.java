package br.com.raphaelneves.microservices.currencyconversionservice;

import br.com.raphaelneves.microservices.currencyconversionservice.beans.CurrencyConversion;
import br.com.raphaelneves.microservices.currencyconversionservice.integrations.CurrencyExchangeServiceProxy;
import br.com.raphaelneves.microservices.currencyconversionservice.integrations.LimitsServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CurrencyConversionConsumer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
    private final LimitsServiceProxy limitsServiceProxy;

    @Autowired
    public CurrencyConversionConsumer(CurrencyExchangeServiceProxy currencyExchangeServiceProxy, LimitsServiceProxy limitsServiceProxy) {
        this.currencyExchangeServiceProxy = currencyExchangeServiceProxy;
        this.limitsServiceProxy = limitsServiceProxy;
    }

    public CurrencyConversion applyCurrencyExchange(String from, String to) {
        return currencyExchangeServiceProxy.getCurrencyExchangeFromTo(from, to);
    }

    public void validateLimitBeforeExchange(BigDecimal amount){
        logger.info("Connecting to limits microservice");
        try{
            limitsServiceProxy.validateOperationLimit(amount);
        }catch(Exception ex){
            logger.error(ex.getMessage());
        }
    }
}
