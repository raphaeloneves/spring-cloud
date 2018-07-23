package br.com.raphaelneves.microservices.limitsservice;

import br.com.raphaelneves.microservices.limitsservice.bean.Limit;
import br.com.raphaelneves.microservices.limitsservice.config.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @GetMapping(value = "/fault")
    @HystrixCommand(fallbackMethod = "faultRetrieve")
    public Limit getLimitsConfigurationWithFault(){
        throw new RuntimeException("Service cannot be reached.");
    }

    private final Limit faultRetrieve(){
        return new Limit(9, 999);
    }

}
