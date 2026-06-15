package com.paymentgateway.apigateway.filter;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingFilter {

    @Bean
    public GlobalFilter customFilter() {

        return (exchange, chain) -> {

            System.out.println(
                    "Incoming Request : "
                            + exchange.getRequest().getURI()
            );

            return chain.filter(exchange);

        };
    }
}