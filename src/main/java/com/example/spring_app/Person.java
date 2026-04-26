package com.example.spring_app;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String firstName;

    private String lastName;

    private Instant dt;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Instant getDt() {
        return dt;
    }

    public void setDt(Instant dt) {
        this.dt = dt;
    }
}
