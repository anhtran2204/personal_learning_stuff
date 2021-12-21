package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AlbumList {
    private final List<Album> albums = new ArrayList<Album>();
    private final LinkedList playlist = new LinkedList();

    public void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public void displayAlbums() {
        for (int i = 0; i < albums.size(); i++) {
            String album = albums.get(i).toString();
            System.out.println((i+1) + ". " + album);
        }
    }

    public void addAlbum(String title, String artist) {
        if (findAlbum(title, artist)) {
            System.out.println("\nError: #Album already exists#");
        }
        else {
            albums.add(new Album(title, artist));
            System.out.println("\nAlbum " + title + " by " + artist + " has been added.");
            sortAlbum();
        }
        pause(1000);
    }

    public void modifyAlbum(String oldTitle, String oldArtist, String newTitle) {
        if (albums.isEmpty()) {
            System.out.println("\nError: #Album is empty#");
            pause(1000);
            return;
        }

        if (findAlbum(oldTitle, oldArtist)) {
            Album album = getAlbum(oldTitle, oldArtist);
            album.setTitle(newTitle);
            System.out.println("\nAlbum " + oldTitle + " has been changed to " + newTitle);
            pause(1000);
        }
        else {
            System.out.println("\nError: #Album not found#");
            pause(1000);
        }
    }

    public void sortAlbum() {
        if (albums.isEmpty()) {
            return;
        }

        albums.sort(new Comparator<Album>() {
            @Override
            public int compare(Album o1, Album o2) {
                if (!o1.getTitle().equals(o2.getTitle())) {
                    return o1.getTitle().compareToIgnoreCase(o2.getTitle());
                } else {
                    return o1.getArtist().compareToIgnoreCase(o2.getArtist());
                }
            }
        });
    }

    public void deleteAlbum(String title, String artist) {
        if (!findAlbum(title, artist)) {
            System.out.println("\nError: #Album not found#");
            return;
        }

        else {
            for (Album album: albums) {
                String albumName = album.getTitle();
                String artistName = album.getArtist();
                if (albumName.replaceAll(" ", "").equalsIgnoreCase(title) &&
                        artistName.replaceAll(" ", "").equalsIgnoreCase(artist)) {
                    albums.remove(album);
                    System.out.println("\nAlbum " + title + " by " + artist + " has been removed.");
                    pause(1000);
                    return;
                }
            }
        }
        System.out.println("\nError: #Album not found#");
    }

    public boolean findAlbum(String title, String artist) {
        if (albums.isEmpty()) {
            System.out.println("\nError: #No album found#");
            pause(1000);
            return false;
        }

        else {
            for (Album album: albums) {
                String albumName = album.getTitle();
                String artistName = album.getArtist();
                if (albumName.replaceAll(" ", "").equalsIgnoreCase(title) &&
                        artistName.replaceAll(" ", "").equalsIgnoreCase(artist)) {
                    System.out.println("\nFound album " + title + " by " + artist);
                    pause(1000);
                    return true;
                }
            }
        }
        pause(1000);
        return false;
    }

    public Album getAlbum(String title, String artist) {
        if (!findAlbum(title, artist)) {
            System.out.println("\nError: #No album found#");
            pause(1000);
            return null;
        }

        for (Album album: albums) {
            String albumName = album.getTitle();
            String artistName = album.getArtist();
            if (albumName.replaceAll(" ", "").equalsIgnoreCase(title) &&
                    artistName.replaceAll(" ", "").equalsIgnoreCase(artist)) {
                return album;
            }
        }
        return null;
    }

    public void addSongToPlaylist(LinkedList playlist, String albumTitle, String artistName, String songTitle, double songDuration) {
        LinkedList.Node newNode = new LinkedList.Node(songTitle, songDuration);

        if (playlist.isEmpty()) {
            playlist.head = playlist.tail = newNode;
            playlist.head.prev = null;
            playlist.tail = null;
            System.out.println("\nSong " + songTitle + " has been added to playlist.");
            pause(1000);
            return;
        }

        for (Album album: albums) {
            String title = album.getTitle();
            String artist = album.getTitle();
            if (title.replaceAll(" ", "").equalsIgnoreCase(albumTitle) &&
                    artist.replaceAll(" ", "").equalsIgnoreCase(artistName)) {
                playlist.tail.next = newNode;
                newNode.prev = playlist.tail;
                playlist.tail = newNode;
                playlist.tail.next = null;
                System.out.println("\nSong " + songTitle + " has been added to playlist.");
                pause(1000);
                return;
            }
        }
        playlist.sortSong();
        System.out.println("\nError: #Song not found#");
        pause(1000);
    }
}
