package Dao;

import entity.song;
import org.example.hellomaven.connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class songDao {

    static List<song> list;

    public static List<song> read() throws SQLException, ClassNotFoundException {
        list = new ArrayList<>();
        Connection co = connection.showConnection();
        String query = "Select * from song";
        PreparedStatement ps = co.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int songid = rs.getInt(1);
            String title = rs.getString(2);
            String artist = rs.getString(3);
            String album = rs.getString(4);
            int releaseYear = rs.getInt(5);
            String genre = rs.getString(6);
            Time duration = rs.getTime(7);
            String url = rs.getString(8);

            song s = new song(songid, title, artist, album, releaseYear, genre, duration, url);
            list.add(s);
        }
        list.forEach(v -> System.out.println(v));
        return list;

    }

}