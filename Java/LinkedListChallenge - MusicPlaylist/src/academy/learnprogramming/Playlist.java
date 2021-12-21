package academy.learnprogramming;

public class Playlist {
    private final String albumName;
    private final Song song;

    public Playlist(String albumName, Song song) {
        this.albumName = albumName;
        this.song = song;
    }

    public String getAlbumName() {
        return albumName.toUpperCase();
    }

    public Song getSong() {
        return song;
    }
}