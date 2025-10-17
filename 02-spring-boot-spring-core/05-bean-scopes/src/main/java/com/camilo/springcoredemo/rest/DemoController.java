package com.camilo.springcoredemo.rest;

import com.camilo.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;

    /*
        Bean scopes - How long they live? How are they shared? How many instances? Lifecycle.
        By default, they are a singleton (Single bean, one instance globally and shared)
    */
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach myCoach,
                          @Qualifier("cricketCoach") Coach anotherCoach) {
        System.out.printf("In constructor: %s%n", getClass().getSimpleName());
        this.myCoach = myCoach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        // Default: Singleton scope
        // Another scope type: Prototype, meaning it will create a new bean each injection
        return "Comparing beans: myCoach == anotherCoach, -> %s".formatted(myCoach == anotherCoach);
    }
}
