package com.sifterstudios.postmanquiz.part1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String getHello() {
        return "Hello World!";
    }

    @GetMapping("/helloTeapot")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String getHelloTeapot() {
        return "I'm a teapot";
    }

    @GetMapping("/api/v1")
    @ResponseStatus(HttpStatus.OK)
    public String getStatus() {
        return "Service is up and running";
    }
}
