package com.simple.springbootbasic.basic.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "simple")
@Data
public class SimpleProperies {
    private String example;
}
