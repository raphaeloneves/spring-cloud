package br.com.raphaelneves.microservices.currencyexchangeservice.config;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SleuthConfiguration {
    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }
}
