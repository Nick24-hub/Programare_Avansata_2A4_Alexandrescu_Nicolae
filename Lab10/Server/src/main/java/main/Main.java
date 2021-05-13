package main;

import server.SimpleServer;
import socialnetwork.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        SimpleServer server = new SimpleServer();
        List<Person> personList = server.getSocialNetwork();
        for (Person person : personList) {
            System.out.println(person.getName());
        }
    }
}
