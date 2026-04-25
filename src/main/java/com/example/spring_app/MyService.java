package com.example.spring_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private static final Logger log = LoggerFactory.getLogger(MyService.class);

    public Person getPerson() {
        log.info("Called getPerson");
        Person person = new Person("Jirka", "Pinkas");
        return person;
    }

}
