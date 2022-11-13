package entity;

public class Playlist {


    int playlistId;
    String nm;
    int audioid;
    int userid;

    public Playlist(int playlistId, String nm, int audioid, int userid) {
        this.playlistId = playlistId;
        this.nm = nm;
        this.audioid = audioid;
        this.userid = userid;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public int getAudioid() {
        return audioid;
    }

    public void setAudioid(int audioid) {
        this.audioid = audioid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistId=" + playlistId +
                ", nm='" + nm + '\'' +
                ", audioid=" + audioid +
                ", userid='" + userid + '\'' +
                '}';
    }
}