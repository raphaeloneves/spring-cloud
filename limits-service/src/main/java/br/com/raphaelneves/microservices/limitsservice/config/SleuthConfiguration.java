package br.com.raphaelneves.microservices.limitsservice.config;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SleuthConfiguration {
    @Bean
    public Sampler deafultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }
}
