package com.camilo.springcoredemo;

import org.springframework.stereotype.Component;

/*
    The component annotation marks the class as a Spring bean
    A Spring bean is a regular java class that will be managed by Spring
    Makes it available for dependency injection
*/

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
