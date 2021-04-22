package DAO;

import connection.DBConnection;
import tables.Actor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorDAO {
    static Connection con = DBConnection.getConnection();

    public void add(Actor actor, int actorID) throws SQLException {
        String query = "insert into actors values (?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, actorID);
        ps.setString(2, actor.getName());
        ps.executeUpdate();
    }

    public Actor getActor(int id) throws SQLException {

        String query = "select * from actors where id= ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);
        Actor actor = new Actor();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            actor.setName(rs.getString("name"));
        }

        if (check) {
            return actor;
        } else
            return null;
    }
}
