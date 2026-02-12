package com.example.spring_app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final String appData;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public HomeController(@Value("${app.data}") String appData, KafkaTemplate<String, String> kafkaTemplate) {
        this.appData = appData;
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/")
    public String home() {
        return appData;
    }

    @GetMapping("/test-kafka")
    public String testKafka() {
        kafkaTemplate.send("test_topic", "test", "test value");
        return "Message sent to test_topic";
    }
}
