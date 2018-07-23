package br.com.raphaelneves.microservices.currencyconversionservice.integrations;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient("gateway-server")
@RibbonClient("limits-service")
public interface LimitsServiceProxy {
    String BASE_SERVICE_URL = "/limits-service/limits";
    @GetMapping(value = BASE_SERVICE_URL + "/validate/{amount}")
    boolean validateOperationLimit(@PathVariable(value = "amount") BigDecimal amount);
}
