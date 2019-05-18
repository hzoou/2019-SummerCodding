package com.pjt.web.summercoding.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.pjt.web.summercoding.dao",  "com.pjt.web.summercoding.service"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
