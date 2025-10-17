package com.camilo.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/*
    You have methods for your bean lifecycle, like do some operation when constructed,
    or do something when the bean is being destroyed
*/

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.printf("In constructor: %s%n", getClass().getSimpleName());
    }

    // init method
    @PostConstruct
    public void doStartUpStuff() {
        System.out.printf("We are doing some start up stuff in %s%n", getClass().getSimpleName());
    }

    // destroy method
    // For "prototype" scoped beans, Spring does not call the destroy method.
    @PreDestroy
    public void doCleanupStuff() {
        System.out.printf("We are doing some clean up stuff in %s%n", getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
