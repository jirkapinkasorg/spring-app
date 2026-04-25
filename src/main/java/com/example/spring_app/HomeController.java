package com.example.spring_app;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private MyService myService;

    @GetMapping("/")
    public String home() {
        return appData;
    }

    @GetMapping("/person")
    public Person getPerson() {
        return myService.getPerson();
    }

    @GetMapping("/test-kafka")
    public String testKafka() {
        kafkaTemplate.send("test_topic", "test", "test value");
        return "Message sent to test_topic";
    }
}
