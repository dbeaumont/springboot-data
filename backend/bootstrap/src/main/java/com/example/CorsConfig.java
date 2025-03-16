package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Value("${spring.web.cors.allowed.origins}")
    private String[] allowedOrigins;

    @Value("${spring.web.cors.allowed.methods}")
    private String[] allowedMethods;

    @Value("${spring.web.cors.allowed.headers}")
    private String[] allowedHeaders;

    @Value("${spring.web.cors.exposed.headers}")
    private String[] exposedHeaders;

    @Value("${spring.web.cors.max-age}")
    private long maxAge;

    @Value("${spring.web.cors.allow-credentials}")
    private boolean allowCredentials;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(allowedOrigins)
                .allowedMethods(allowedMethods)
                .allowedHeaders(allowedHeaders)
                .exposedHeaders(exposedHeaders)
                .maxAge(maxAge)
                .allowCredentials(allowCredentials);
    }
}
