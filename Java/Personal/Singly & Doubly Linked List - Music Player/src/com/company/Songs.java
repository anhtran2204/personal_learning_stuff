package com.company;

public interface Songs {
    boolean isEmpty();
    void displayPlaylist();
    void sortSong();
    void modifySong(String oldTitle, String title, double duration);
    void deleteSong(String title);
    void shuffleSong();
    void playSong(String title);
    void nextSong();
    void prevSong();
    void replaySong();
}
