package com.lab4tech.config;
import org.springframework.context.annotation.PropertySource;

import com.lab4tech.config.ApplicationConfig;

@PropertySource(value = { "application.DATA.properties","application.test.properties" })
public class ApplicationTestConfig extends ApplicationConfig {

}
