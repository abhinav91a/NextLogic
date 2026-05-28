package com.nextlogic.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()

                // Company
                .route("company-service", r -> r.path("/company-service/**")
                        .filters(f -> f.circuitBreaker(c -> c
                                .setName("companyServiceCB")
                                .setFallbackUri("forward:/fallback/company")))
                        .uri("lb://company-service"))

                // Job
                .route("job-service", r -> r.path("/job-service/**")
                        .filters(f -> f.circuitBreaker(c -> c
                                .setName("jobServiceCB")
                                .setFallbackUri("forward:/fallback/job")))
                        .uri("lb://job-service"))

                // User
                .route("user-service", r -> r.path("/user-service/**")
                        .filters(f -> f.circuitBreaker(c -> c
                                .setName("userServiceCB")
                                .setFallbackUri("forward:/fallback/user")))
                        .uri("lb://user-service"))

                // Scraper
                .route("scraper-service", r -> r.path("/scraper-service/**")
                        .filters(f -> f.circuitBreaker(c -> c
                                .setName("scraperServiceCB")
                                .setFallbackUri("forward:/fallback/scraper")))
                        .uri("lb://scraper-service"))

                .build();
    }

}
