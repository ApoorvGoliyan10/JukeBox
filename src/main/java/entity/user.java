package entity;

public class user {
 int userid ;
 String username;
 String passworrd;

    public user(int userid, String username, String passworrd) {
        this.userid = userid;
        this.username = username;
        this.passworrd = passworrd;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassworrd() {
        return passworrd;
    }

    public void setPassworrd(String passworrd) {
        this.passworrd = passworrd;
    }

    @Override
    public String toString() {
        return "user{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", passworrd='" + passworrd + '\'' +
                '}';
    }
}

