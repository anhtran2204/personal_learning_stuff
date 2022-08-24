package academy.learnprogramming;

public class Song {
    private final String songTitle;
    private final double songDuration;

    public Song(String songTitle, double songDuration) {
        this.songTitle = songTitle;
        this.songDuration = songDuration;
    }

    public String getSongTitle() {
        return songTitle.toUpperCase();
    }

    public double getSongDuration() {
        return songDuration;
    }

    public Song createSongs(String songTitle, double songDuration) {
        return new Song(songTitle, songDuration);
    }
}
