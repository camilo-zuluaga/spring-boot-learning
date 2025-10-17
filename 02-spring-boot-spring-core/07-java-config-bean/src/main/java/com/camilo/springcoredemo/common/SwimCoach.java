package com.camilo.springcoredemo.common;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.printf("In constructor: %s%n", getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 Meters as a warm up!";
    }
}
