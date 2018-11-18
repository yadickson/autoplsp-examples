package com.autoplsp.rest.web;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.autoplsp.rest.service.OneService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.autoplsp.rest.controller, com.autoplsp.rest.config"})
public class MockControllerConfig {

    @Bean
    public OneService oneService() {
        return Mockito.mock(OneService.class);
    }

}
