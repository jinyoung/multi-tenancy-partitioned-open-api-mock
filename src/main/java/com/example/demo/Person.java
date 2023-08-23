package com.example.demo;

import org.hibernate.annotations.TenantId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Person {

    @TenantId
    String TenantId;

    @Id
    @GeneratedValue
    Long id;

    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}