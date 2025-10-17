package com.camilo.springcoredemo.rest;

import com.camilo.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    /*
        Spring will start to search @Component classes and see which one implements the interface we want
        Qualifiers helps us to specify which (Component: spring bean) to inject if we have more than one!
        Use the bean id: same class name, but first letter in lowercase
    */

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach myCoach) {
        System.out.printf("In constructor: %s%n", getClass().getSimpleName());
        this.myCoach = myCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
