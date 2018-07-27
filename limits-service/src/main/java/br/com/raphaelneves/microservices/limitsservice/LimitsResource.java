package br.com.raphaelneves.microservices.limitsservice;

import br.com.raphaelneves.microservices.limitsservice.config.LimitConfiguration;
import br.com.raphaelneves.microservices.limitsservice.exceptions.LimitBoundaryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/limits")
public class LimitsResource {

    private final LimitConfiguration configuration;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public LimitsResource(LimitConfiguration configuration) {
        this.configuration = configuration;
    }

    @GetMapping(value = "/validate/{amount}")
    public boolean validateOperationLimit(@PathVariable(value = "amount") BigDecimal amount){
        logger.info("Verifying if amount {} respects limits boundary.", amount);

        boolean isValid = configuration.getMinimum().compareTo(amount) <= 0 && configuration.getMaximum().compareTo(amount) >= 0;
        if(!isValid) {
            logger.error("Amount {} violates limits boundary. Minimum: {} | Maximum: {}", amount, configuration.getMinimum(), configuration.getMaximum());
            throw new LimitBoundaryException("The amount must be between " + configuration.getMinimum() + " and " + configuration.getMaximum());
        }
        return isValid;
    }
}
