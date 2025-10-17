package com.camilo.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// You can let spring scan in other packages and sub packaged that are out of springcoredemo
/*@SpringBootApplication(
        scanBasePackages = {"com.camilo.springcoredemo",
                			"com.camilo.util"}
)*/

@SpringBootApplication
public class SpringcoredemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcoredemoApplication.class, args);
    }

}
