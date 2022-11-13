package org.example.hellomaven;

import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class userSignin {

    static boolean ans=true;

    public static int  Userlogin(Connection con, int user_id ) throws SQLException {
        Scanner sc=new Scanner(System.in);
        try {

            System.out.println("Are You an Existing User  [1 = yes] or [2 = No ]");
            int sa = sc.nextInt();
            if (sa == 1) {

                //for existing customer

                System.out.println("Please enter your credentials to login into Application. ");
                System.out.println("Enter email Address");
                String email = sc.next();
                System.out.println("Enter your password");
                String password = sc.next();
                String finalpassword = null;

                boolean ismatch = Pattern.matches("[a-z]+@[1-9]+", password);

                if (ismatch == false) {
                    System.out.println("wrong credentials");
                }

                if (ismatch) {
                    finalpassword = password;

                }

                Statement stmt = con.createStatement();
                String query1 = "select password from user where email= '" + email + "' ;";
                ResultSet rs1 = stmt.executeQuery(query1);
                String pswrd = null;
                while (rs1.next()) {
                    pswrd = rs1.getString(1);
                }

                if ( finalpassword!=null && finalpassword.equalsIgnoreCase(pswrd)) {
                    System.out.println("Welcome to your Account.");

                    String query3 = "select user_id from user where email= '" + email + "' ;";
                    ResultSet rs3 = stmt.executeQuery(query3);

                    int uId = 0;
                    while (rs3.next()) {
                        uId = rs3.getInt(1);
                    }
                    System.out.println("your user ID is :  " + uId);
                    System.out.println("-----------------------------------------------------------------------");
                    return uId;

                } else {
                    System.out.println("invalid credentials, try again later.");
                    ans = false;
                }
            } else if (sa == 2) {
                //for new customer
                System.out.println("Enter Some basic details : as You are a new Customer ");


                String q1 = "insert into user values(?,?,?,?);";
                PreparedStatement ps1 = con.prepareStatement(q1);
                ps1.setInt(1, user_id);
                System.out.println("Enter  name :");
                String name = sc.next();
                System.out.println("enter the email");
                String email = sc.next();
                ps1.setString(2, name);

                System.out.println("Enter the password");
                String password = sc.next();

                ps1.setString(3, password);

                ps1.setString(4, email);

                int res = ps1.executeUpdate();
                System.out.println(res);
                System.out.println("Your user_id id  :  " + user_id);

                System.out.println("**************************************************");
                return user_id;
            } else {
                System.out.println("Invalid Input");
                ans=false;
            }

        }
        catch (NullPointerException a)
        {
            a.printStackTrace();
        }

        return user_id;
    }

}
