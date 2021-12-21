package com.company;

public class Song {
    private final String songName;
    private final double songDuration;

    public Song(String songName, double songDuration) {
        this.songName = songName;
        this.songDuration = songDuration;
    }

    public String getSongName() {
        return songName;
    }

    @Override
    public String toString() {
        return "Name: " + this.songName + "\n   Duration: " + this.songDuration + " min";
    }
}
