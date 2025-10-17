package com.cmilo.demo.myapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" endpoint, that handled HTTP requests

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }
}
