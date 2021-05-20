package com.example.lab11;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/relationships")
public class PersonFriendshipController {
    Connection connection = Singleton.getConnection() ;
    PersonController personController=new PersonController();

    public PersonFriendshipController() throws SQLException {
        List<PersonFriendship> friendships = new ArrayList<>();
        String sql = "SELECT * FROM relationship ";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            friendships.add(new PersonFriendship(rs.getInt("id"),rs.getInt("id1"),rs.getInt("id2")));
        }
    }

    @GetMapping
    public List<PersonFriendship> getFriendships() throws SQLException {
        List<PersonFriendship> friendships = new ArrayList<>();
        String sql = "SELECT * FROM relationship ";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            friendships.add(new PersonFriendship(rs.getInt("id"),rs.getInt("id1"),rs.getInt("id2")));
        }
        return friendships;
    }

    @GetMapping("/{id}")
    public PersonFriendship getFriendship(@PathVariable("id") int id) throws SQLException {
        PersonFriendship friendship = new PersonFriendship();
        String sql = "SELECT * from relationship where id = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1,id);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            friendship.setId(id);
            friendship.setId1(rs.getInt("id1"));
            friendship.setId2(rs.getInt("id2"));
        }
        return friendship;
    }

    @PostMapping
    public void createFriendship(@RequestParam int id,int id1, int id2 ) throws SQLException {
        personController.addFriend(id1);
        personController.addFriend(id2);
        try {
            String sql = "INSERT INTO relationship values(?,?,?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setInt(2, id1);
            stm.setInt(2, id2);
            stm.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @PostMapping(value = "/obj", consumes = "application/json")
    public ResponseEntity<String>
    createFriendship(@RequestBody PersonFriendship friendship) {
        int id=friendship.getId();
        int id1=friendship.getId1();
        int id2= friendship.getId2();
        try {
            String sql = "INSERT INTO relationship values(?,?,?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setInt(2, id1);
            stm.setInt(2, id2);
            stm.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new ResponseEntity<>(
                "Friendship created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteFriendship(@PathVariable("id") int id) throws SQLException {

        PersonFriendship friendship= new PersonFriendship();
        friendship = findById(id);
        if (friendship == null) {
            return new ResponseEntity<>(
                    "Friendship not found", HttpStatus.GONE);
        }
        personController.removeFriend(friendship.getId1());
        personController.removeFriend(friendship.getId2());
        String sql = "DELETE from relationship where id = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, id);
        stm.execute();

        return new ResponseEntity<>("Friendship removed", HttpStatus.OK);
    }

    private PersonFriendship findById(int id) {
        PersonFriendship friendship = null;
        try {
            String sql = "SELECT * from relationship where id = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                friendship = new PersonFriendship(id,rs.getInt("id1"),rs.getInt("id2"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return friendship;
    }

}
