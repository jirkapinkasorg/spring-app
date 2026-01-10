package com.example.spring_app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${app.data}")
    private String appData;

    @GetMapping("/")
    public String home() {
        return appData;
    }
}
