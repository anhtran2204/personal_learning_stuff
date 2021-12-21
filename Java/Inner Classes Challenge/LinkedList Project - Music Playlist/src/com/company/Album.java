package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private final String albumName;
    private final String artist;
    private final ArrayList<Song> album;

    public Album(String albumName, String artist) {
        this.albumName = albumName;
        this.artist = artist;
        this.album = new ArrayList<Song>();
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getArtist() {
        return artist;
    }

    public void addSong(String songName, double songDuration) {
        if (!findSong(songName)) {
            this.album.add(new Song(songName, songDuration));
        }
    }

    public boolean findSong(String songName) {
        for (Song checkSong: this.album) {
            if (checkSong.getSongName().equals(songName)) {
                return true;
            }
        }
        return false;
    }

    public Song getSong(String songName) {
        if (findSong(songName)) {
            for (Song checkSong: this.album) {
                if (checkSong.getSongName().equals(songName)) {
                    return checkSong;
                }
            }
        }
        return null;
    }

    public void removeSong(String songName) {
        for (int i = 0; i < album.size(); i++) {
            Song checkSong = album.get(i);
            if (checkSong.getSongName().equals(songName)) {
                this.album.remove(checkSong);
            }
        }
    }

    public void printSongList() {
        if (album.isEmpty()) {
            System.out.println("\nAlbum is empty.\n");
        }

        System.out.println("\n       ~~~~~~ SONGS LIST ~~~~~~         \n");
        for (int i = 0; i < album.size(); i++) {
            String printSong = album.get(i).getSongName();
            System.out.println("\t\t" + (i+1) + ". " + printSong);
        }
    }

    public void addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= this.album.size())) {
            playlist.add(this.album.get(index));
        }
        System.out.println("This album does not have a track " + trackNumber);
    }

    public void addToPlaylist(String songName, LinkedList<Song> playlist) {
        Song checkSong = getSong(songName);
        if (checkSong != null) {
            playlist.add(checkSong);
        } else {
            System.out.println("The song " + songName + " does not exist in this album");
        }
    }

    public void removeSongFromPlaylist(String songName, LinkedList<Song> playlist) {
        Song deleteSong = getSong(songName);

        if (deleteSong != null) {
            playlist.remove(deleteSong);
            System.out.println("\nThe song " + songName + " has been deleted from the playlist.");
        }
    }

    private static class SongList {
        private String songTitle;
        private double songDuration;
        private ArrayList<Song> songs;

        public void addSong(String songTitle, double songDuration) {
            songs.add(new Song(songTitle, songDuration));
        }

        public Song findSong(String songTitle) {
            for (Song findSong: songs) {
                if (findSong.getSongName().replaceAll(" ","").equalsIgnoreCase(songTitle)) {
                    return findSong;
                }
            }
            return null;
        }
    }
}
