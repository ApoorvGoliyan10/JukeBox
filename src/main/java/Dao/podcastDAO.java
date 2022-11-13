package Dao;


import entity.Podcast;
import org.example.hellomaven.connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class podcastDAO
{
    static List<Podcast> list=null;

    public static  List<Podcast> read() throws SQLException, ClassNotFoundException
    {
        list= new ArrayList<>();
        Connection co = connection.showConnection();

        String query="select * from podcast";
        PreparedStatement ps=co.prepareStatement(query);
        ResultSet rs=ps.executeQuery();

        while(rs.next())
        {
            int podcastId=rs.getInt(1);
            String naam =rs.getString(2);
            String celeb= rs.getString(3);
            String genre=rs.getString(4);
            Date date=rs.getDate(5);
            String url=rs.getString(6);

            Podcast p=new Podcast(podcastId,naam,celeb,genre,date,url);
            list.add(p);
        }
        list.forEach(v-> System.out.println(v));
        return list;
    }
}






