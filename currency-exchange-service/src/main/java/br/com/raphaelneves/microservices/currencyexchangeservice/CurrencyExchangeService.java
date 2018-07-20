package br.com.raphaelneves.microservices.currencyexchangeservice;

import br.com.raphaelneves.microservices.currencyexchangeservice.bean.ExchangeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

    private final CurrencyExchangeRepository repository;

    @Autowired
    public CurrencyExchangeService(CurrencyExchangeRepository repository) {
        this.repository = repository;
    }

    public ExchangeValue getCurrencyFromTo(String from, String to){
        return repository.findByFromAndTo(from, to);
    }
}
