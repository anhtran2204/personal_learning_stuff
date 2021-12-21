package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Album {
    private final String albumName;
    private final ArrayList<Song> album;

    private static final Scanner scanner = new Scanner(System.in);

    public Album(String albumName) {
        this.albumName = albumName;
        this.album = new ArrayList<Song>();
    }

    public String getAlbumName() {
        return albumName.toUpperCase();
    }

    public ArrayList<Song> getAlbum() {
        return album;
    }

    public boolean addSong(Song song) {
        Iterator r  = album.iterator();
        while ((r.hasNext())) {
            Song $song = (Song)r.next();
            if ($song.getSongTitle().equals(song.getSongTitle())) {
                System.out.println("Song already in album.");
                return false;
            }
        }
        album.add(song);
        return true;
    }

    public boolean isPresent(Song song) {
        Iterator<Song> i = album.iterator();
        while (i.hasNext()) {
            if (i.next().equals(song)) {
                return true;
            }
        }
        return false;
    }
}