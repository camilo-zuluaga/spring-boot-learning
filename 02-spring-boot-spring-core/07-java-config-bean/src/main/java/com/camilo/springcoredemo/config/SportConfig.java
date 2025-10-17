package com.camilo.springcoredemo.config;

import com.camilo.springcoredemo.common.Coach;
import com.camilo.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuring a bean with java code
// The @Bean annotation is useful when we want to make third-party classes work within the spring framework, and cant
// directly be a @Component

@Configuration
public class SportConfig {

    // custom bean ID
    @Bean("phelps")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
