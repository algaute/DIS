package com.lab4tech.web.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.lab4tech.config.ApplicationConfig;

@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.lab4tech" })
@Import({ ApplicationConfig.class, SecurityConfig.class}) //, WebMvcConfiguration.class })
@PropertySource(value = { "application.DATA.properties","application.REST.properties"})
public class AppConfig {

}
