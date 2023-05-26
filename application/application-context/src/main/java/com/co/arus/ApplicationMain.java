package com.co.arus;

import org.reactivecommons.async.impl.config.annotations.EnableDirectAsyncGateway;
import org.reactivecommons.async.impl.config.annotations.EnableDomainEventBus;
import org.reactivecommons.async.impl.config.annotations.EnableMessageListeners;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDomainEventBus
@EnableDirectAsyncGateway
@EnableMessageListeners
public class ApplicationMain {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(ApplicationMain.class, args);
    }
}
