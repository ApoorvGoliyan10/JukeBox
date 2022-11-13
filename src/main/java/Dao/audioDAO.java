package Dao;

import entity.Audio;
import org.example.hellomaven.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class audioDAO {

    static List<Audio> list=null;

    public static List<Audio> read() throws SQLException, ClassNotFoundException {
        Connection con = connection.showConnection();

        String query = "select * from audio";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int audioid = rs.getInt(1);
            String audiotype = rs.getString(2);
            int songid = rs.getInt(3);
            int podcastid = rs.getInt(4);

            Audio a = new Audio(audioid, audiotype, songid, podcastid);
            list.add(a);
        }
        return list;
    }
}

