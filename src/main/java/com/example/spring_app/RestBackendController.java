package com.example.spring_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestBackendController {

    private final RestClient restClient;

    public RestBackendController(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("http://backend-rest-dev")
                .build();
    }

    @GetMapping("/api/callRest")
    public String callRest() {
        return restClient.get()
                .uri("/api/call")
                .retrieve()
                .body(String.class);
    }

}
