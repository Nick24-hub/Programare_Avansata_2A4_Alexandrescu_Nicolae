package com.example.lab11;

import java.util.ArrayList;
import java.util.List;

public class Person {
    int id;

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
