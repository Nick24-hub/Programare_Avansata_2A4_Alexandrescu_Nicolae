package com.example.lab11;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persons")
public class PersonController {
    Connection connection = Singleton.getConnection();

    public PersonController() throws SQLException {
        List<Person> persons = new ArrayList<>();
        String sql = "SELECT * FROM person ";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            persons.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("numberOfFriends")));
        }
    }

    @GetMapping
    public List<Person> getPersons() throws SQLException {
        List<Person> persons = new ArrayList<>();
        String sql = "SELECT * FROM person ";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            persons.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("numberOfFriends")));
        }
        return persons;
    }

    @GetMapping("/count")
    public int countPersons() throws SQLException {
        int numberOfPersons = 0;
        String sql = "SELECT COUNT(*) FROM person ";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            numberOfPersons = rs.getInt("COUNT(*)");
        }
        return numberOfPersons;
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) throws SQLException {
        Person person = new Person();
        String sql = "SELECT * from person where id = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            person.setId(id);
            person.setName(rs.getString("name"));
            person.setNumberOfFriends(rs.getInt("numberOfFriends"));
        }
        return person;
    }

    @PostMapping
    public void createPerson(@RequestParam int id, String name) {
        try {
            String sql = "INSERT INTO person values(?,?,?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, name);
            stm.setInt(3, 0);
            stm.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @PostMapping(value = "/obj", consumes = "application/json")
    public ResponseEntity<String>
    createPerson(@RequestBody Person person) {
        int id = person.getId();
        String name = person.getName();
        int nr = person.getNumberOfFriends();
        try {
            String sql = "INSERT INTO person values(?,?,?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, name);
            stm.setInt(3, nr);
            stm.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new ResponseEntity<>(
                "Person created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(
            @PathVariable("id") int id, @RequestParam String name) throws SQLException {
        Person person = findById(id);
        String sql = "UPDATE person SET name=?  where id=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, name);
        stm.setInt(2, id);
        stm.execute();

        if (person == null) {
            throw new CustomNotFoundException("Person not found");
//            return new ResponseEntity<>(
//                    "Person not found", HttpStatus.NOT_FOUND); //or GONE
        }

        return new ResponseEntity<>(
                "Person updated successfully", HttpStatus.OK);
    }

    private Person findById(int id) {
        Person person = null;
        try {
            String sql = "SELECT * from person where id = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                person = new Person(id, rs.getString("name"), rs.getInt("numberOfFriends"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return person;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") int id) throws SQLException {
        Person person = new Person();
        person = findById(id);

        if (person == null) {
            return new ResponseEntity<>(
                    "Person not found", HttpStatus.GONE);
        }
        String sql = "DELETE from person where id = ?";

        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, id);
        stm.execute();

        return new ResponseEntity<>("Person removed", HttpStatus.OK);
    }


    public ResponseEntity<String> addFriend( int id) throws SQLException {
        Person person = findById(id);
        String sql = "UPDATE person SET numberOfFriends=?  where id=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, person.getNumberOfFriends()+1);
        stm.setInt(2, id);
        stm.execute();

        if (person == null) {
            return new ResponseEntity<>(
                    "Person not found", HttpStatus.NOT_FOUND); //or GONE
        }

        return new ResponseEntity<>(
                "Friend added successfully", HttpStatus.OK);
    }


    public ResponseEntity<String> removeFriend( int id) throws SQLException {
        Person person = findById(id);
        String sql = "UPDATE person SET numberOfFriends=?  where id=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, person.getNumberOfFriends()-1);
        stm.setInt(2, id);
        stm.execute();

        if (person == null) {
            return new ResponseEntity<>(
                    "Person not found", HttpStatus.NOT_FOUND); //or GONE
        }

        return new ResponseEntity<>(
                "Friend added successfully", HttpStatus.OK);
    }

    @GetMapping("/most/{k}")
    public Person getMostPopular(int k) throws SQLException {
        List<Person> persons = new ArrayList<>();
       persons=getPersons();
        List<Person> sortedPersons = persons.stream()
                .sorted(Comparator.comparing(Person::getNumberOfFriends))
                .collect(Collectors.toList());
        return sortedPersons.get(k);
    }

    @GetMapping("/least/{k}")
    public Person getLeastPopular(int k) throws SQLException {
        List<Person> persons = new ArrayList<>();
        persons=getPersons();
        List<Person> sortedPersons = persons.stream()
                .sorted(Comparator.comparing(Person::getNumberOfFriends).reversed())
                .collect(Collectors.toList());
        return sortedPersons.get(k);
    }
}
