
package org.example.hellomaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {

    static Connection co=null;
    static Statement stmt=null;
    public static  Connection showConnection() throws ClassNotFoundException, SQLException {
        //1. Load the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully");

        //2.Establish a connecion

        co= DriverManager.getConnection("jdbc:mysql://localhost:3306/Jukebox","root","root1");
        System.out.println("Connection established");

        return co;


    }
}

