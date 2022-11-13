


package org.example.hellomaven;

import Dao.podcastDAO;
import Dao.songDao;
import entity.Podcast;
import entity.song;
import operation.podcastOperation;
import operation.songOperation;
import playFunctionality.podcastPLayfunctionality;
import playFunctionality.songPLayfunctionality;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import static org.example.hellomaven.userSignin.Userlogin;

public class App 
{

    public static void playStart() throws UnsupportedAudioFileException, SQLException, LineUnavailableException, IOException, ClassNotFoundException {
          Scanner scan= new Scanner(System.in);
        System.out.println(" what you want to listen \n a.songs s.podcast");
        String  abc= scan.next();
        switch(abc) {
            case "a" :
            songPLayfunctionality.playFunction();
            case "s":
            podcastPLayfunctionality.playFunction();
        }

}

    public static void main( String[] args ) throws SQLException,NullPointerException,ClassNotFoundException {
        connection nw= new connection();
        System.out.println( "Hello !!!!!!!!!! \n WELCOME TO JUKEBOX");
          Connection con = nw.showConnection();

        Scanner scan = new Scanner(System.in);

        Random rm = new Random();
        int user_id = rm.nextInt(50);

       //userSignin o= new userSignin();
        Userlogin(con,user_id); // for login purpose


        System.out.println(" \n HOMEPAGE \n all audio available  ");
       List<song> res=new ArrayList<>();
        res= songDao.read();

        List<Podcast> pod=new ArrayList<>();
        pod= podcastDAO.read();
        int c = 0;

        do {
            System.out.println("\n 1.display all songs \t 2.display podcast \t 3.Sort songs by title \t 4.Search  song \n" +
                    "5.sort podcast by name \t 6. search podcast by artist \t 7.play Audio \t 8.exit");
            System.out.println("enter the choice");
            c = scan.nextInt();

            switch (c) {
                case 1:
                   songDao.read();
                    break;
                case 2:
                    podcastDAO.read();
                    break;
                case 3:
                    List<song> sn=songOperation.sort(res);
                    sn.forEach(v-> System.out.println(v));
                    break;
                case 4:
                    List<song> sln= songOperation.seacrchBySong(res,"Dosti");
                    sln.forEach(v-> System.out.println(v));
                    break;
                case 5:
                    List<Podcast> podd= podcastOperation.sort(pod);
                    podd.forEach(v-> System.out.println(v));
                    break;
                case 6:
                    List<Podcast> fm= podcastOperation.seacrchByCelebrity(pod,"Andrews Books");
                    fm.forEach(v-> System.out.println(v));
                    break;
                case 7:
                    try {
                        App.playStart();
                    } catch (UnsupportedAudioFileException e) {
                        e.printStackTrace();
                    } catch (LineUnavailableException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                case 8:
                    System.exit(0);
                default:
                    System.out.println("not valid choice");
            }

            System.out.println("###########################################");
        }while (c!=8);

    }

}


