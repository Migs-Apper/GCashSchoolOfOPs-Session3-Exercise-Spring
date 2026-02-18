package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class DemoController {
    private final Random random = new Random();

    @GetMapping("/fast")
    public String fastRequest() {
        return "That was fast!";
    }

    @GetMapping("/slow")
    public String slowRequest() throws InterruptedException {
        // Simulate a delay between 0 and 500ms
        Thread.sleep(random.nextInt(500));
        return "Sorry I'm late!";
    }

    @GetMapping("/error")
    public String errorRequest() {
        if (random.nextBoolean()) {
            throw new RuntimeException("Something went wrong!");
        }
        return "Lucky this time!";
    }
}
