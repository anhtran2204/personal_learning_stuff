package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Album implements Albums{
    private String title;
    private String artist;
    private final List<Song> album;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.album = new ArrayList<Song>();
    }

    public void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n   Artist: " + artist;
    }

    @Override
    public void displaySongs() {
        if (album.isEmpty()) {
            System.out.println("\nError: #Album is empty#");
        } else {
            for (int i = 0; i < album.size(); i++) {
                String song = album.get(i).toString();
                System.out.println((i + 1) + ". " + song);
            }
        }
    }

    @Override
    public void addSong(String title, double duration) {
        if (findSong(title)) {
            System.out.println("\nError: #Song already exists#");
        } else {
            album.add(new Song(title, duration));
            System.out.println("\nSong " + title + " has been added to album.");
        }
        sortSong();
    }

    @Override
    public void sortSong() {
        if (album.isEmpty()) {
            System.out.println("\nError: #Album is empty#");
            return;
        }

        album.sort(new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                return o1.getTitle().compareToIgnoreCase(o2.getTitle());
            }
        });
    }

    @Override
    public void deleteSong(String title) {
        if (album.isEmpty()) {
            System.out.println("\nError: #Album is empty#");
            return;
        }

        for (Song song: album) {
            String songName = song.getTitle();
            if (songName.replaceAll(" ", "").equalsIgnoreCase(title)) {
                album.remove(song);
                System.out.println("\nSong " + songName +  " has been removed from album.");
            } else {
                System.out.println("\nError: #Song not found#");
            }
        }
    }

    @Override
    public boolean findSong(String title) {
        if (album.isEmpty()) {
            System.out.println("\nError: #Album is empty#");
            return false;
        }

        for (Song findSong: album) {
            String findName = findSong.getTitle()
                    .replaceAll(" ", "").toLowerCase();
            if (findName.equalsIgnoreCase(title)) {
                System.out.println("\nFound song " + title + " in the album.");
                return true;
            } else {
                System.out.println("\nError: #Song not found#");
            }
        }
        return false;
    }

    @Override
    public int indexOf(String title) {
        if (album.isEmpty()) {
            System.out.println("\nError: #Album is empty#");
            return -1;
        }

        for (int i = 0; i < album.size(); i++) {
            String songName = album.get(i).getTitle();
            if (songName.replaceAll(" ", "").equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Song getSong(String title) {
        if (album.isEmpty()) {
            System.out.println("\nError: #Album is empty#");
            return null;
        }

        if (indexOf(title) == -1) {
            System.out.println("\nError: #Song doesn't exist#");
            return null;
        }
        return album.get(indexOf(title));
    }

    public static class Song {
        private final String title;
        private final double duration;

        public Song(String title, double duration) {
            this.title = title;
            this.duration = duration;
        }

        public String getTitle() {
            return title;
        }

        public double getDuration() {
            return duration;
        }

        @Override
        public String toString() {
            return "Title: " + title +
                    "\n   Duration: " + duration;
        }
    }
}

