package com.camilo.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Primary annotation means if we do not specify any bean (having multiple implementations) while injection
// It will use this one as the primary one
// So no need Qualifier annotation in the constructor or setter injection, although if you use it, it has higher priority
// So Qualifier will override Primary annotation

// Lazy initialization, when spring boot runs, it will instantiate every bean, so it will create every object it can see
// With @Lazy, we can say, don't instantiate this object until it's needed (for injection for example)
// You should really think of the trade-offs

@Component
@Primary
@Lazy
public class TrackCoach implements Coach {

    public TrackCoach() {
        System.out.printf("In constructor: %s%n", getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }
}
