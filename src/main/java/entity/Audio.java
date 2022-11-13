package entity;

public class Audio {
int audioid;
String audiotype;
int songid;
int podcastid;

    public Audio(int audioid, String audiotype, int songid, int podcastid) {
        this.audioid = audioid;
        this.audiotype = audiotype;
        this.songid = songid;
        this.podcastid = podcastid;
    }

    public int getAudioid() {
        return audioid;
    }

    public void setAudioid(int audioid) {
        this.audioid = audioid;
    }

    public String getAudiotype() {
        return audiotype;
    }

    public void setAudiotype(String audiotype) {
        this.audiotype = audiotype;
    }

    public int getSongid() {
        return songid;
    }

    public void setSongid(int songid) {
        this.songid = songid;
    }

    public int getPodcastid() {
        return podcastid;
    }

    public void setPodcastid(int podcastid) {
        this.podcastid = podcastid;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "audioid=" + audioid +
                ", audiotype='" + audiotype + '\'' +
                ", songid=" + songid +
                ", podcastid=" + podcastid +
                '}';
    }
}
