package com.nextlogic.scraperservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class ScraperExecutorConfig {

    @Bean(name = "scraperExecutor")
    public Executor scraperExecutor() {
        return Executors.newFixedThreadPool(5);
    }
}
