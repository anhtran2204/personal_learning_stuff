package com.company;

public interface Albums {
    void displaySongs();
    void addSong(String title, double duration);
    void sortSong();
    void deleteSong(String title);
    boolean findSong(String title);
    int indexOf(String title);
    Album.Song getSong(String title);
}
