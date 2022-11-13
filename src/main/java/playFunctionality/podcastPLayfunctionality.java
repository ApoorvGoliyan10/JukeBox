package playFunctionality;

import org.example.hellomaven.connection;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class podcastPLayfunctionality {


        static int repeat=0,id=0;

        public static void playFunction() throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, IOException, LineUnavailableException {


            Connection con = connection.showConnection();
            Scanner scan = new Scanner(System.in);

            if (repeat == 0) {

                System.out.println("enter the podcastId to play the podcast ");
                id = scan.nextInt();
            }

            String query = "select url from podcast where podcastId=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            String url = "";
            while (rs.next()) {
                url = rs.getString(1);
                System.out.println(url);
            }


            File file = new File(url);
            AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audiostream);
            clip.start();
            System.out.println("your podcast is  playing.....");

            String response = "";

            while (!response.equals("C")) {
                System.out.println("x=repeat same , S=stop , R=reset , N= Next , P= previous,C=close");
                System.out.println("enter your choice: ");
                response = scan.next();
                response = response.toUpperCase();

                switch (response) {
                    case ("X"):
                        clip.start();
                        System.out.println("podcast play ");
                        break;
                    case ("S"):
                        clip.stop();
                        System.out.println("podcast stop");
                        break;
                    case ("R"):
                        clip.setMicrosecondPosition(0);
                        System.out.println("podcast restart");
                        break;
                    case ("N"): {
                        id++;
                        repeat++;
                        clip.stop();
                        if (id==102 ){
                            id=100;
                        }
                        playFunction();
                        break;

                    }
                    case ("P") : {
                        id--;
                        repeat++;
                        clip.stop();
                        if (id==99 ){
                            id=101;
                        }
                        playFunction();
                        break;

                    }
                    case ("C"):
                        for(int i=0;i<=repeat;i++){
                        clip.close();
                        System.exit(0);}
                        break;

                    default:
                        System.out.println("not a valid response");

                }
            }
            System.out.println("Thanks for playing ");
        }
    }