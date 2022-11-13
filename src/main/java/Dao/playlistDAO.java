package Dao;


import entity.Playlist;
import org.example.hellomaven.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class playlistDAO {

    static Connection con;

    static {
        try {
            con = connection.showConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createPlaylist(Playlist pl, int userid) throws SQLException {


        String query="insert into playlist where userid=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,pl.getPlaylistId());
        ps.setString(2, pl.getNm());
        ps.setInt(3,pl.getAudioid());
        ps.setInt(4,pl.getUserid());

        int count= ps.executeUpdate();
        System.out.println(count+"row affected");
    }

    public static void removeFromPlaylist(Playlist pl,int audioid) throws SQLException
    {
        String query="delete from playlist where audioid=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1,audioid);

        int count=ps.executeUpdate();
        System.out.println(count+"rows affected");
    }

}
