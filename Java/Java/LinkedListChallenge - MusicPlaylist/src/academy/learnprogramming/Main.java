package academy.learnprogramming;

import java.util.*;

public class Main {

    private static final ArrayList<Album> albumList = new ArrayList<Album>();
    private static final ArrayList<Playlist> playlist = new ArrayList<Playlist>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isPlaying = false;
        Playlist currentSongOnPlay = new Playlist(null, null);
        boolean quit = false;
        turnOnMusicPlayer();
        options();

        while (!quit) {
            System.out.println("\n Enter choice: (9 to show available actions)");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Album's name:");
                    String albumName = scanner.nextLine();
                    addAlbum(albumList, albumName);
                    break;

                case 2:
                    System.out.println("Enter Album's name:");
                    String $albumName = scanner.nextLine();
                    System.out.println("Enter song title:");
                    String songTitle = scanner.nextLine();
                    double duration= scanner.nextDouble();
                    Song song = new Song(songTitle, duration);
                    addSongToAlbum(albumList, $albumName, song);
                    break;

                case 3:
                    System.out.println("Enter album name:");
                    String theAlbumName=scanner.nextLine();
                    Album theAlbum = new Album(theAlbumName);
                    ListIterator g = albumList.listIterator();
                    while (g.hasNext()){
                        Album checkAlbum = (Album)g.next();
                        if(checkAlbum.getAlbumName().equals(theAlbumName) ){
                            theAlbum=checkAlbum;
                            break;
                        }
                    }
                    if(theAlbum.getAlbum()==null) {
                        System.out.println("Album does not exist");
                    }else {
                        listSongsInAlbum(theAlbum);
                    }
                    break;

                case 4:
                    System.out.println("Enter AlbumName");
                    String playAlbumName=scanner.nextLine();
                    System.out.println("Enter Song Title");
                    String $songTitle=scanner.nextLine();
                    System.out.println("Enter Song Duration");
                    double $duration= scanner.nextDouble();
                    Song $song = new Song($songTitle,$duration);
                    addSongToPlaylist(playlist, $song, albumList, playAlbumName);
                    break;

                case 5:
                    System.out.println("Enter name of song to be removed from the playlist:");
                    String songName = scanner.nextLine();
                    System.out.println("Enter song duration");
                    double songDuration = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Enter song album name");
                    String nameOfAlbum = scanner.nextLine();

                    removeSongFromPlaylist(playlist,nameOfAlbum,songName,songDuration);
                    break;

                case 6:
                case 9:
                    currentSongOnPlay=playPlaylist(playlist,currentSongOnPlay);
                    if(currentSongOnPlay!=null){
                        isPlaying=true;
                    }
                    break;

                case 7:
                    currentSongOnPlay= playNextSong(playlist,isPlaying,currentSongOnPlay);
                    break;

                case 8:
                    currentSongOnPlay=playPreviousSong(playlist,isPlaying,currentSongOnPlay);
                    break;

                case 10:
                    options();
                    break;
                case 0:
                    quit = true;
            }
        }
    }

    public static boolean isAlbumPresent(ArrayList<Album> albumList, String albumName) {
        Iterator i = albumList.iterator();
        while(i.hasNext()) {
            Album checkAlbum = (Album)i.next();
            if (checkAlbum.getAlbumName().equals(albumName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSongPresentInPlaylist(ArrayList<Playlist> playlist, Song song, String albumName) {
        Playlist $item = new Playlist(albumName, song);
        Iterator i = playlist.iterator();
        while (i.hasNext()) {
            Playlist item = (Playlist)i.next();
            if (item.getAlbumName().equals(albumName) && item.getSong().getSongTitle().equals(song.getSongTitle())) {
                return true;
            }
        }
        return false;
    }

    public static Album getAlbum(ArrayList<Album> albumList, String albumName) {
        Iterator i = albumList.iterator();
        while (i.hasNext()) {
            Album checkAlbum = (Album)i.next();
            if (checkAlbum.getAlbumName().equals(albumName)) {
                return checkAlbum;
            }
        }
        return null;
    }

    public static boolean getSong(Album album, String songTitle) {
        Iterator b = album.getAlbum().iterator();
        while (b.hasNext()) {
            Song song = (Song) b.next();
            if (song.getSongTitle().equals(songTitle)) {
                return true;
            }
        }
        return false;
    }

    public static void addAlbum(ArrayList<Album> albumList, String albumName) {
        if (isAlbumPresent(albumList, albumName)) {
            System.out.println("Album already exists.");
        } else {
            Album album = new Album(albumName);
            albumList.add(album);
            System.out.println("Album " + album.getAlbumName() + " added to list.");
        }
    }

    public static void addSongToAlbum(ArrayList<Album> albumList, String albumName, Song song) {
        Album album = getAlbum(albumList, albumName);
        if (album != null) {
            if (album.addSong(song)) {
                System.out.println("Song " + song.getSongTitle() + " added to album " + album.getAlbumName());
            }
        } else {
            System.out.println("Album " + album.getAlbumName() + " does not exist.");
        }
    }

    public static void listSongsInAlbum(Album album) {
        Iterator i = album.getAlbum().iterator();
        while (i.hasNext()) {
            Song song = (Song) i.next();
            System.out.println("Song Title: " + song.getSongTitle() +
                    "\nDuration: " + song.getSongDuration());
        }
    }

    public static void addSongToPlaylist(ArrayList<Playlist> playlist, Song song, ArrayList<Album> albumList, String albumName) {
        if (isSongPresentInPlaylist(playlist, song, albumName)) {
            System.out.println("Song " + song.getSongTitle() + " already in playlist.");
        }
        if (getAlbum(albumList, albumName) != null) {
            Album album = getAlbum(albumList, albumName);
            if (getSong(album, song.getSongTitle())) {
                Playlist yourPlaylist = new Playlist(albumName, song);
                playlist.add(yourPlaylist);
                System.out.println("Song has been added to playlist.");
            }
        }
    }

    public static void removeSongFromPlaylist(ArrayList<Playlist> playlist, String albumName, String songTitle, Double duration) {
        Song song = new Song(songTitle, duration);
        Playlist yourPlaylist = new Playlist(albumName, song);
        Iterator i = playlist.iterator();
        if (isSongPresentInPlaylist(playlist, song, albumName)) {
            playlist.remove(yourPlaylist);
            System.out.println(songTitle + " in album " + albumName + " has been removed from the playlist.");
        } else {
            System.out.println("Song " + songTitle + " not in playlist.");
        }
    }

    public static Playlist playPlaylist(ArrayList<Playlist> playlist, Playlist currentSongOnPlay) {
        Iterator i = playlist.iterator();
        if (playlist.isEmpty()) {
            System.out.println("There is no song in playlist.");
            return null;
        } else {
            if (currentSongOnPlay.getSong() == null) {
                Playlist yourPlaylist = (Playlist) i.next();
                currentSongOnPlay = yourPlaylist;
            }
            System.out.println("Now playing " + currentSongOnPlay.getSong().getSongTitle() + " in album " +
                    currentSongOnPlay.getAlbumName());
            return currentSongOnPlay;
        }
    }

    public static Playlist playNextSong(ArrayList<Playlist> playlist, boolean checkIfPlaylistIsPlaying, Playlist currentSongOnPlay) {
        if (checkIfPlaylistIsPlaying) {
            int index = playlist.indexOf(currentSongOnPlay);
            Playlist nextSong = playlist.get(index + 1);
            System.out.println("Now playing the next song: " + nextSong.getSong().getSongTitle() + " in album " +
                    nextSong.getAlbumName());
            currentSongOnPlay = nextSong;
        } else {
            System.out.println("Playlist not started.");
        }
        return currentSongOnPlay;
    }

    public static Playlist playPreviousSong(ArrayList<Playlist> playlist, boolean checkIfPlaylistIsPlaying, Playlist currentSongOnPlay) {
        if (checkIfPlaylistIsPlaying) {
            int index = playlist.indexOf(currentSongOnPlay);
            Playlist previousSong = playlist.get(index - 1);
            System.out.println("Now playing the previous song: " + previousSong.getSong().getSongTitle() + " in album " +
                    previousSong.getAlbumName());
            currentSongOnPlay = previousSong;
        } else {
            System.out.println("Playlist not started.");
        }
        return currentSongOnPlay;
    }

    public static void turnOnMusicPlayer() {
        System.out.println("Turning on Spotify.....\n");
        System.out.println("====== THIS IS YOUR PLAYLIST ======");
    }

    public static void options(){
        System.out.println("Choose an option from  the following:" +
                "\n1: Add album"+
                "\n2: Add song to album"+
                "\n3: List songs in album"+
                "\n4: Add song to playlist"+
                "\n5: Remove song from playlist"+
                "\n6: Play Playlist"+
                "\n7: Skip to next song on playlist"+
                "\n8: Skip to previous song on playlist"+
                "\n9: Replay current song on playlist"+
                "\n10: List Options"+
                "\n0: Quit");
    }
}