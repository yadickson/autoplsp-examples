/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autoplsp.rest.config;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.common.base.Predicate;

/**
 * Application swagger config class.
 *
 * @author Yadickson Soto
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    /**
     * Package folder.
     */
    static final String BASE = "com.autoplsp.rest.controller";

    /**
     * Build swagger documentation.
     *
     * @return docker documentation api.
     */
    @Bean
    public Docket api() {

        Predicate<RequestHandler> base;
        base = RequestHandlerSelectors.basePackage(BASE);

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(base)
                .paths(PathSelectors.any())
                .build();
    }
}
