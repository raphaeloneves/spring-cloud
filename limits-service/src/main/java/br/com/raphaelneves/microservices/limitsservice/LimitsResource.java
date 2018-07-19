package br.com.raphaelneves.microservices.limitsservice;

import br.com.raphaelneves.microservices.limitsservice.bean.Limit;
import br.com.raphaelneves.microservices.limitsservice.config.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/limits")
public class LimitsResource {

    private final LimitConfiguration configuration;

    @Autowired
    public LimitsResource(LimitConfiguration configuration) {
        this.configuration = configuration;
    }

    @GetMapping(value = "")
    public Limit getLimitsConfiguration(){
        return new Limit(configuration.getMinimum(), configuration.getMaximum());
    }

}
