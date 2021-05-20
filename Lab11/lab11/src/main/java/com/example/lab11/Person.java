package com.example.lab11;


public class Person {
    private int id;
    private String name;
    private int numberOfFriends;

    public int getNumberOfFriends() {
        return numberOfFriends;
    }

    public void setNumberOfFriends(int numberOfFriends) {
        this.numberOfFriends = numberOfFriends;
    }

    public Person(int id, String name, int numberOfFriends) {
        this.id = id;
        this.name = name;
        this.numberOfFriends=numberOfFriends;
    }

    public Person() {

    }

    public void setName(String name) {
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
