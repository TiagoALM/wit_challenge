package com.wit.rest.logger;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfig {
    @Bean
    public FilterRegistrationBean<LoggerFilter> servletRegisterBean() {
        final FilterRegistrationBean<LoggerFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        final LoggerFilter loggerFilter = new LoggerFilter();
        filterRegistrationBean.setFilter(loggerFilter);
        filterRegistrationBean.setOrder(1); //priority

        return filterRegistrationBean;
    }
}
