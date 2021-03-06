package com.autoplsp.rest.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.autoplsp.rest.constant.Constants;

@Configuration
public class MessageConverterConfig extends WebMvcConfigurationSupport {

    @Bean
    @Override
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter handlerAdapter = super.requestMappingHandlerAdapter();
        List<HttpMessageConverter<?>> converters = handlerAdapter.getMessageConverters();

        for (HttpMessageConverter converter : converters) {

            if (converter instanceof StringHttpMessageConverter) {
                List<MediaType> supported = new ArrayList<MediaType>();
                supported.add(MediaType.parseMediaType(Constants.TEXT_PLAIN_VALUE));
                supported.add(MediaType.parseMediaType(Constants.TEXT_XML_VALUE));
                supported.add(MediaType.parseMediaType(Constants.TEXT_HTML_VALUE));
                ((StringHttpMessageConverter) converter).setSupportedMediaTypes(supported);
            }

            if (converter instanceof MappingJackson2HttpMessageConverter) {
                List<MediaType> supported = new ArrayList<MediaType>();
                supported.add(MediaType.parseMediaType(Constants.APPLICATION_JSON_VALUE));
                ((MappingJackson2HttpMessageConverter) converter).setSupportedMediaTypes(supported);
            }
        }

        return handlerAdapter;
    }
}
