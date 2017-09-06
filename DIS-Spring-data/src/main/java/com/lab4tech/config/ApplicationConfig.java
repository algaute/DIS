package com.lab4tech.config;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Application configuration.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.lab4tech" })
@EnableJpaRepositories(basePackages = { "com.lab4tech.repositories", "com.lab4tech.security" })
@EntityScan(basePackages = { "com.lab4tech.entities", "com.lab4tech.security" })
@PropertySource(value = { "application.DATA.properties"})
public class ApplicationConfig {

}
