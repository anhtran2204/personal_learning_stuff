package com.company;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static final ArrayList<Album> albums = new ArrayList<>();
    private static final LinkedList<Song> playlist = new LinkedList<>();

    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Turning on Spotify.....\n");
        pause(2000);

        boolean quit = false;
        boolean forward = true;

        while (!quit) {
            printMenu();
            System.out.print("\nEnter your choice: ");
            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                int action = scanner.nextInt();
                scanner.nextLine();
                switch (action) {
                    /* Print out the options */
                    case 0:
                        printMenu();
                        break;

                    /* Access the playlist */
                    case 1:
                        boolean loop = true;
                        ListIterator<Song> songs = playlist.listIterator();

                        while (loop) {
                            playlistMenu();

                            System.out.print("\nEnter your choice: ");
                            hasNextInt = scanner.hasNextInt();
                            if (hasNextInt) {
                                int playlistAction = scanner.nextInt();
                                scanner.nextLine();
                                switch (playlistAction) {
                                    /* Print out the options */
                                    case 0:
                                        pause(1000);
                                        playlistMenu();
                                        break;

                                    /* Print out list of songs in playlist */
                                    case 1:
                                        if (playlist.isEmpty()) {
                                            pause(1000);
                                            System.out.println("\nError: #No songs in playlist#\n");
                                        } else {
                                            while (songs.hasNext()) {
                                                System.out.println("\t\t- " + songs.next().getSongName() + ".");
                                                pause(1000);
                                            }
                                            songs = playlist.listIterator();
                                        }

                                        System.out.println("Do you want to go back? Y/N?");
                                        String goBack = scanner.nextLine();
                                        if (goBack.equalsIgnoreCase("y")) {
                                            break;
                                        } else if (goBack.equalsIgnoreCase("n")) {
                                            continue;
                                        }

                                    /* Shuffle the songs and play */
                                    case 2:
                                        playSong(playlist);
                                        break;

                                    /* Skip to the next songs */
                                    case 3:
                                        if (playlist.isEmpty()) {
                                            System.out.println("\nError: #No songs in playlist#\n");
                                        } else {
                                            if (!forward) {
                                                if (songs.hasNext()) {
                                                    songs.next();
                                                }
                                                forward = true;
                                            }

                                            if (songs.hasNext()) {
                                                System.out.println("\nNow playing " + songs.next().getSongName() + ".");
                                            } else {
                                                System.out.println("\nYou reached the end of the list.");
                                                forward = false;
                                            }
                                        }
                                        break;

                                    /* Skip to previous song */
                                    case 4:
                                        if (playlist.isEmpty()) {
                                            System.out.println("\nNo songs in playlist.\n");
                                        } else {
                                            if (forward) {
                                                if (songs.hasPrevious()) {
                                                    songs.previous();
                                                }
                                                forward = false;
                                            }

                                            if (songs.hasPrevious()) {
                                                System.out.println("\nNow playing " + songs.previous().getSongName() + ".");
                                            } else {
                                                System.out.println("\nYou reached the start of the list.");
                                                forward = true;
                                            }
                                        }
                                        break;

                                    /* Replay the song */
                                    case 5:
                                        if (playlist.isEmpty()) {
                                            System.out.println("\nNo songs in playlist.\n");
                                        } else {
                                            if (forward) {
                                                if (songs.hasPrevious()) {
                                                    System.out.println("\nNow playing " + songs.previous().getSongName() + ".");
                                                    forward = false;
                                                }
                                            } else {
                                                if (songs.hasNext()) {
                                                    System.out.println("\nNow playing " + songs.next().getSongName() + ".");
                                                    forward = true;
                                                }
                                            }
                                        }
                                        break;

                                    /* Add a song from an album
                                    *  into the playlist */
                                    case 6:
                                        if (albums.isEmpty()) {
                                            pause(1000);
                                            printAlbumList();
                                        } else {
                                            pause(1000);
                                            printAlbumList();

                                            System.out.print("\nEnter the album's name: ");
                                            String albumChoice = scanner.nextLine().toUpperCase();
                                            Album checkAlbum = getAlbum(albumChoice);

                                            assert checkAlbum != null;
                                            pause(1000);
                                            checkAlbum.printSongList();

                                            System.out.print("\nEnter the song to put in the playlist: ");
                                            String findSong = scanner.nextLine().toUpperCase();

                                            if (checkAlbum.findSong(findSong)) {
                                                checkAlbum.addToPlaylist(findSong, playlist);
                                                System.out.println("\nSong " + findSong + " added to playlist.");
                                            } else {
                                                System.out.println("\nError: #Song not found#");
                                            }

                                            while (continueAction()) {
                                                System.out.print("\nEnter the album's name: ");
                                                albumChoice = scanner.nextLine().toUpperCase();
                                                checkAlbum = getAlbum(albumChoice);

                                                assert checkAlbum != null;
                                                pause(1000);
                                                checkAlbum.printSongList();

                                                System.out.print("\nEnter the song to put in the playlist: ");
                                                findSong = scanner.nextLine().toUpperCase();

                                                if (checkAlbum.findSong(findSong)) {
                                                    checkAlbum.addToPlaylist(findSong, playlist);
                                                    System.out.println("\nSong " + findSong + " added to playlist.");
                                                } else {
                                                    System.out.println("\nError: #Song not found#");
                                                }
                                            }
                                        }
                                        break;

                                    /* Delete a song from the playlist */
                                    case 7:
                                        if (albums.isEmpty()) {
                                            pause(1000);
                                            printAlbumList();
                                        } else {
                                            pause(1000);
                                            printAlbumList();

                                            System.out.print("\nEnter the album's name: ");
                                            String albumChoice = scanner.nextLine().toUpperCase();
                                            Album checkAlbum = getAlbum(albumChoice);

                                            assert checkAlbum != null;
                                            checkAlbum.printSongList();

                                            System.out.print("\nEnter the song to delete from the playlist: ");
                                            String findSong = scanner.nextLine().toUpperCase();

                                            if (checkAlbum.findSong(findSong)) {
                                                checkAlbum.removeSongFromPlaylist(findSong, playlist);
                                                System.out.println("\nSong " + findSong + " deleted from playlist.");
                                            } else {
                                                System.out.println("\nError: #Song not found#");
                                            }

                                            while (continueAction()) {
                                                System.out.print("\nEnter the album's name: ");
                                                albumChoice = scanner.nextLine().toUpperCase();
                                                checkAlbum = getAlbum(albumChoice);

                                                assert checkAlbum != null;
                                                checkAlbum.printSongList();

                                                System.out.print("\nEnter the song to delete from the playlist: ");
                                                findSong = scanner.nextLine().toUpperCase();

                                                if (checkAlbum.findSong(findSong)) {
                                                    checkAlbum.removeSongFromPlaylist(findSong, playlist);
                                                    System.out.println("\nSong " + findSong + " deleted from playlist.");
                                                } else {
                                                    System.out.println("\nError: #Song not found#");
                                                }
                                            }
                                        }
                                        break;

                                    /* Search song from playlist */
                                    case 8:
                                        System.out.print("\nEnter the song's name: ");
                                        String songName = scanner.nextLine();

                                        System.out.println(findSong(songName, playlist));

                                        while (continueAction()) {
                                            System.out.print("Enter the song's name: ");
                                            songName = scanner.nextLine();

                                            System.out.println(findSong(songName, playlist));
                                        }
                                        break;

                                    /* Go back to main page */
                                    case 9:
                                        loop = false;
                                }
                            } else {
                                System.out.println("\nInvalid Input.");
                            }
                        }
                        break;

                    /* Access the album lists and album functions */
                    case 2:
                        loop = true;

                        while (loop) {
                            pause(1000);
                            albumMenu();

                            System.out.print("\nEnter your choice: ");
                            hasNextInt = scanner.hasNextInt();
                            if (hasNextInt) {
                                int albumChoice = scanner.nextInt();
                                scanner.nextLine();
                                switch (albumChoice) {
                                    /* Print out the options */
                                    case 0:
                                        albumMenu();
                                        break;

                                    /* Print out list of albums */
                                    case 1:
                                        pause(1000);
                                        printAlbumList();
                                        break;

                                    /* Add new album to the arrayList */
                                    case 2:
                                        System.out.print("\nEnter new album's name: ");
                                        String newAlbum = scanner.nextLine().toUpperCase();
                                        System.out.print("\nEnter album's artist: ");
                                        String artistName = scanner.nextLine().toUpperCase();

                                        if (!findAlbum(newAlbum, artistName)) {
                                            addAlbum(newAlbum, artistName);
                                            System.out.println("\nAlbum " + newAlbum + " by " + artistName + " has been added.");
                                        } else {
                                            System.out.println("\nError: #Album already exists#");
                                        }

                                        while (continueAction()) {
                                            System.out.print("\nEnter new album's name: ");
                                            newAlbum = scanner.nextLine().toUpperCase();
                                            System.out.print("\nEnter album's artist: ");
                                            artistName = scanner.nextLine().toUpperCase();

                                            if (!findAlbum(newAlbum, artistName)) {
                                                addAlbum(newAlbum, artistName);
                                                pause(1000);
                                                System.out.println("\nAlbum " + newAlbum + " by " + artistName + " has been added.");
                                            } else {
                                                pause(1000);
                                                System.out.println("\nError: #Album already exists#");
                                            }
                                        }
                                        break;

                                    /* Delete an album from the arrayList */
                                    case 3:
                                        pause(1000);
                                        if (albums.isEmpty()) {
                                            System.out.println("\nError: #No albums are present#\n");
                                            pause(1000);
                                        } else {
                                            printAlbumList();

                                            System.out.print("\nEnter album's name: ");
                                            String deleteAlbum = scanner.nextLine().toUpperCase();
                                            System.out.print("\nEnter artist's name: ");
                                            artistName = scanner.nextLine();

                                            if (findAlbum(deleteAlbum, artistName)) {
                                                removeAlbum(deleteAlbum);
                                                System.out.println("\nAlbum " + deleteAlbum + " has been removed.");
                                            } else {
                                                System.out.println("\nError: #Album not found#");
                                            }

                                            while (continueAction()) {
                                                printAlbumList();

                                                System.out.print("\nEnter album's name: ");
                                                deleteAlbum = scanner.nextLine().toUpperCase();

                                                if (findAlbum(deleteAlbum, artistName)) {
                                                    removeAlbum(deleteAlbum);
                                                    System.out.println("\nAlbum " + deleteAlbum + " has been removed.");
                                                } else {
                                                    System.out.println("\nError: #Album not found#");
                                                }
                                            }
                                        }
                                        break;

                                    /* Search an album */
                                    case 4:
                                        System.out.print("\nEnter album's name: ");
                                        String searchAlbum = scanner.nextLine().toUpperCase();
                                        System.out.print("\nEnter artist's name: ");
                                        artistName = scanner.nextLine();

                                        if (findAlbum(searchAlbum, artistName)) {
                                            System.out.println("Found album " + searchAlbum + " by "
                                                    + artistName);
                                        } else {
                                            System.out.println("\nError: #Album not found#");
                                        }

                                        while (continueAction()) {
                                            System.out.print("\nEnter album's name: ");
                                            searchAlbum = scanner.nextLine().toUpperCase();
                                            System.out.print("\nEnter artist's name: ");
                                            artistName = scanner.nextLine();

                                            if (findAlbum(searchAlbum, artistName)) {
                                                System.out.println("Found album " + searchAlbum + " by "
                                                        + artistName);
                                            } else {
                                                System.out.println("\nError: #Album not found#");
                                            }
                                        }
                                        break;

                                    /* Print list of songs from an album */
                                    case 5:
                                        pause(1000);
                                        if (albums.isEmpty()) {
                                            System.out.println("\nError: #No albums are present#\n");
                                            pause(1000);
                                        } else {
                                            printAlbumList();

                                            System.out.print("Enter album's name: ");
                                            String findAlbum = scanner.nextLine();

                                            Album album = getAlbum(findAlbum);
                                            assert album != null;
                                            album.printSongList();

                                            System.out.println("Do you want to go back? Y/N?");
                                            String goBack = scanner.nextLine();
                                            if (goBack.equalsIgnoreCase("y")) {
                                                break;
                                            } else if (goBack.equalsIgnoreCase("n")) {
                                                continue;
                                            }
                                        }

                                    /* Add new song to an album */
                                    case 6:
                                        pause(1000);
                                        if (albums.isEmpty()) {
                                            System.out.println("\nError: #No albums are present#\n");
                                            pause(1000);
                                        } else {
                                            printAlbumList();

                                            System.out.print("Choose which album to add new song: ");
                                            String addSong = scanner.nextLine().toUpperCase();
                                            System.out.print("\nEnter the artist's name: ");
                                            artistName = scanner.nextLine();

                                            if (findAlbum(addSong, artistName)) {
                                                System.out.print("\nEnter the song's name: ");
                                                String songName = scanner.nextLine().toUpperCase();
                                                System.out.print("\nEnter the song's duration: ");
                                                boolean hasNextDouble = scanner.hasNextDouble();
                                                if (hasNextDouble) {
                                                    double songDuration = scanner.nextDouble();

                                                    Album album = getAlbum(addSong);
                                                    assert album != null;
                                                    if (!album.findSong(songName)) {
                                                        album.addSong(songName, songDuration);
                                                        System.out.println("\nSong " + songName + " has been added to album "
                                                                + addSong + ".");
                                                    } else {
                                                        System.out.println("\nError: #Album not found#");
                                                    }

                                                    while (continueAction()) {
                                                        printAlbumList();

                                                        System.out.print("Choose which album to add new song: ");
                                                        addSong = scanner.nextLine().toUpperCase();

                                                        System.out.print("\nEnter the song's name: ");
                                                        songName = scanner.nextLine().toUpperCase();
                                                        System.out.print("\nEnter the song's duration: ");
                                                        songDuration = scanner.nextDouble();

                                                        album = getAlbum(addSong);
                                                        assert album != null;
                                                        if (!album.findSong(songName)) {
                                                            album.addSong(songName, songDuration);
                                                            System.out.println("\nSong " + songName + " has been added to album "
                                                                    + addSong + ".");
                                                        } else {
                                                            System.out.println("\nError: #Album not found#");
                                                        }
                                                    }
                                                } else {
                                                    System.out.println("Error: #Invalid Input#");
                                                    continue;
                                                }
                                            } else {
                                                System.out.println("\nError: #Album not found#");
                                            }
                                        }
                                        break;

                                    /* Remove song from an album */
                                    case 7:
                                        pause(1000);
                                        if (albums.isEmpty()) {
                                            System.out.println("\nNo albums are present.\n");
                                            pause(1000);
                                        } else {
                                            printAlbumList();

                                            System.out.print("\nChoose which album to remove song: ");
                                            String removeSong = scanner.nextLine().toUpperCase();
                                            System.out.print("\nEnter the artist's name: ");
                                            artistName = scanner.nextLine();

                                            if (findAlbum(removeSong, artistName)) {
                                                Album album = getAlbum(removeSong);
                                                assert album != null;
                                                album.printSongList();

                                                System.out.print("Enter the song's name: ");
                                                String songName = scanner.nextLine().toUpperCase();

                                                if (album.findSong(songName)) {
                                                    album.removeSong(songName);
                                                    System.out.println("Song " + songName + " has been removed from album " + removeSong);
                                                } else {
                                                    System.out.println("\nError: #Song not found#");
                                                }
                                            } else {
                                                System.out.println("\nError: #Album not found#");
                                            }

                                            while (continueAction()) {
                                                pause(1000);
                                                printAlbumList();

                                                System.out.print("\nChoose which album to remove song: ");
                                                removeSong = scanner.nextLine().toUpperCase();
                                                System.out.print("\nEnter the artist's name: ");
                                                artistName = scanner.nextLine();

                                                if (findAlbum(removeSong, artistName)) {
                                                    Album album = getAlbum(removeSong);
                                                    assert album != null;
                                                    album.printSongList();

                                                    System.out.print("Enter the song's name: ");
                                                    String songName = scanner.nextLine().toUpperCase();

                                                    if (album.findSong(songName)) {
                                                        album.removeSong(songName);
                                                        System.out.println("Song " + songName + " has been removed from album " + removeSong);
                                                    } else {
                                                        System.out.println("\nError: #Song not found#");
                                                    }
                                                } else {
                                                    System.out.println("\nError: #Album not found#");
                                                }
                                            }
                                        }
                                        break;

                                    /* Search song from an album */
                                    case 8:
                                        System.out.print("\nEnter album's name: ");
                                        String albumName = scanner.nextLine();
                                        System.out.print("\nEnter artist name: ");
                                        artistName = scanner.nextLine();

                                        if (findAlbum(albumName, artistName)) {
                                            System.out.println("Found album " + albumName + " by " + artistName);
                                        } else {
                                            System.out.println("\nError: #Album not found#");
                                        }

                                        while (continueAction()) {
                                            System.out.print("\nEnter album's name: ");
                                            albumName = scanner.nextLine();
                                            System.out.print("\nEnter artist name: ");
                                            artistName = scanner.nextLine();

                                            if (findAlbum(albumName, artistName)) {
                                                System.out.println("Found album " + albumName + " by " + artistName);
                                            } else {
                                                System.out.println("\nError: #Album not found#");
                                            }
                                        }
                                        break;

                                    /* Go back to main page */
                                    case 9:
                                        loop = false;
                                        pause(1000);
                                }
                            } else {
                                System.out.println("\nInvalid Input.");
                            }
                        }
                        break;

                    /* Leaving the music player. */
                    case 3:
                        pause(1000);
                        System.out.println("\nLeaving Spotify......");
                        quit = true;

                }
            } else {
                System.out.println("\nInvalid Input.");
            }
        }
    }

//    public static void main1(String[] args) {
//        Album newAlbum = new Album("Album", "Anh");
//        albums.add(newAlbum);
//
//        System.out.print("Enter song name: ");
//        String songName = scanner.nextLine();
//        newAlbum.addSong(songName, 3.0);
//        System.out.print("Enter song name: ");
//        songName = scanner.nextLine();
//        newAlbum.addSong(songName, 3.0);
//        System.out.print("Enter song name: ");
//        songName = scanner.nextLine();
//        newAlbum.addSong(songName, 3.0);
//
//        LinkedList<Song> playlist = new LinkedList<>();
//
//        System.out.print("\nEnter song name: ");
//        songName = scanner.nextLine();
//        albums.get(0).addToPlaylist(songName, playlist);
//
//        System.out.print("Enter song name: ");
//        songName = scanner.nextLine();
//        albums.get(0).addToPlaylist(songName, playlist);
//
//        System.out.print("Enter song name: ");
//        songName = scanner.nextLine();
//        albums.get(0).addToPlaylist(songName, playlist);
//
//
//        ListIterator<Song> songs = playlist.listIterator();
//        int i = 0;
//        System.out.println("");
//        while (songs.hasNext()) {
//            i++;
//            System.out.println(i + ". " + songs.next().toString());
//        }
//
//        songs = playlist.listIterator();
//        boolean forward = true;
//        if (playlist.isEmpty()) {
//            System.out.println("\nNo songs in playlist.\n");
//        } else {
//            System.out.println("\nNow playing " + songs.next().getSongName());
//
//            boolean quit = true;
//            while (quit) {
//                System.out.println("\nEnter 1 to skip song, 2 to skip back, 3 to replay.");
//                int action = scanner.nextInt();
//                scanner.nextLine();
//                switch (action) {
//                    case 1:
//                        if (playlist.isEmpty()) {
//                            System.out.println("\nNo songs in playlist.\n");
//                        } else {
//                            if (!forward) {
//                                if (songs.hasNext()) {
//                                    songs.next();
//                                }
//                                forward = true;
//                            }
//
//                            if (songs.hasNext()) {
//                                System.out.println("\nNow playing " + songs.next().getSongName() + ".");
//                            } else {
//                                System.out.println("\nYou reached the end of the list.");
//                                forward = false;
//                            }
//                        }
//                        break;
//
//                    case 2:
//                        if (forward) {
//                            if (songs.hasPrevious()) {
//                                songs.previous();
//                            }
//                            forward = false;
//                        }
//
//                        if (songs.hasPrevious()) {
//                            System.out.println("\nNow playing " + songs.previous().getSongName() + ".");
//                        } else {
//                            System.out.println("\nYou reached the start of the list.");
//                            forward = true;
//                        }
//                        break;
//
//                    case 3:
//                        if (playlist.isEmpty()) {
//                            System.out.println("\nNo songs in playlist.\n");
//                        } else {
//                            if (forward) {
//                                if (songs.hasPrevious()) {
//                                    System.out.println("\nNow playing " + songs.previous().getSongName() + ".");
//                                    forward = false;
//                                }
//                            } else if (!forward){
//                                if (songs.hasNext()) {
//                                    System.out.println("\nNow playing " + songs.next().getSongName() + ".");
//                                    forward = true;
//                                }
//                            }
//                        }
//                        break;
//
//                    default:
//                        quit = false;
//                }
//            }
//        }
//    }

    /* Print out lists of albums in arrayList*/
    public static void printAlbumList() {
        pause(1000);
        System.out.println("\n       ~~~~~~ ALBUM LIST ~~~~~~         \n");
        for (int i = 0; i < albums.size(); i++) {
            Album checkAlbum = albums.get(i);
            System.out.println("\t\t" + (i + 1) + ". " + checkAlbum.getAlbumName());
        }
        System.out.println("\n");
    }

    /* Add new album into arraylist */
    public static void addAlbum(String albumName, String artistName) {
        if (!findAlbum(albumName, artistName)) {
            albums.add(new Album(albumName, artistName));
        }
    }

    /* Get the specified album with input name */
    public static Album getAlbum(String albumName) {
        if (albums.isEmpty()) {
            System.out.println("\nNo albums are present.\n");
        }

        for (Album checkAlbum : albums) {
            if (checkAlbum.getAlbumName().equalsIgnoreCase(albumName)) {
                return checkAlbum;
            }
        }
        return null;
    }

    /* Find the specified album given the input name. */
    public static boolean findAlbum(String albumName, String artistName) {
        for (Album checkAlbum : albums) {
            if (checkAlbum.getAlbumName().equalsIgnoreCase(albumName) && checkAlbum.getArtist().equalsIgnoreCase(artistName)) {
                return true;
            }
        }
        return false;
    }

    /* Delete the specified album given the input name. */
    public static void removeAlbum(String albumName) {
        for (int i = 0; i < albums.size(); i++) {
            Album findAlbum = albums.get(i);
            if (findAlbum.getAlbumName().equals(albumName)) {
                albums.remove(findAlbum);
            }
        }
    }

    /* Turn the linked list into an array to randomly
    *  play the songs in playlist */
    public static void playSong(LinkedList<Song>  playlist) {
        Song[] playSong = playlist.toArray(new Song[0]);

        if (playSong.length == 0) {
            System.out.println("\nNo songs in playlist.\n");
            return;
        }
        Random random = new Random();
        int shuffle = random.nextInt(playSong.length);
        System.out.println("\nNow playing " + playSong[shuffle].getSongName());
    }

    public static String findSong(String songName, LinkedList<Song> playlist) {
        for (Song checkSong : playlist) {
            if (checkSong.getSongName().replaceAll(" ", "").equalsIgnoreCase(songName)) {
                return "\nFound song " + songName + " in the playlist.";
            }
        }
        return "\nNo songs were found with name.";
    }

    /* Function to decide if user
       want to continue their action */
    public static boolean continueAction() {
        while (true) {
            pause(1000);
            System.out.print("\nDo you want to continue? Y/N? \n");
            String choice = scanner.nextLine();

            if (choice.replaceAll(" ", "").equalsIgnoreCase("y")) {
                return true;
            } else if (choice.replaceAll(" ", "").equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Invalid Input.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("\n~~~~~~~ WELCOME TO YOUR PLAYLIST ~~~~~~~\n");
        pause(1000);
        System.out.println("     ++++++++ MENU OPTIONS ++++++++       \n");
        pause(1000);
        System.out.println("\t\t0. Print menu options.");
        pause(1000);
        System.out.println("\t\t1. Go to playlist. ");
        pause(1000);
        System.out.println("\t\t2. Go to albums list. ");
        pause(1000);
        System.out.println("\t\t3. Quit application.");
        pause(1000);
    }

    public static void playlistMenu() {
        System.out.println("\n   ++++++++ PLAYLIST OPTIONS ++++++++   \n");
        pause(1000);
        System.out.println("\t\t0. Print menu options.");
        pause(1000);
        System.out.println("\t\t1. Print playlist. ");
        pause(1000);
        System.out.println("\t\t2. Play playlist. ");
        pause(1000);
        System.out.println("\t\t3. Skip to next song.");
        pause(1000);
        System.out.println("\t\t4. Skip to previous song.");
        pause(1000);
        System.out.println("\t\t5. Replay song.");
        pause(1000);
        System.out.println("\t\t6. Add song to playlist.");
        pause(1000);
        System.out.println("\t\t7. Remove song from playlist.");
        pause(1000);
        System.out.println("\t\t8. Search song from playlist.");
        pause(1000);
        System.out.println("\t\t9. Go back to main page.");
        pause(1000);
    }

    public static void albumMenu() {
        System.out.println("\n   ++++++++ ALBUMS OPTIONS +++++++++   \n");
        pause(1000);
        System.out.println("\t\t0. Print menu options.");
        pause(1000);
        System.out.println("\t\t1. Print albums list. ");
        pause(1000);
        System.out.println("\t\t2. Add new album.");
        pause(1000);
        System.out.println("\t\t3. Delete album.");
        pause(1000);
        System.out.println("\t\t4. Search album.");
        pause(1000);
        System.out.println("\t\t5. Print songs in album.");
        pause(1000);
        System.out.println("\t\t6. Add song to album.");
        pause(1000);
        System.out.println("\t\t7. Delete song from album.");
        pause(1000);
        System.out.println("\t\t8. Search song from album.");
        pause(1000);
        System.out.println("\t\t9. Go back to main page.");
        pause(1000);
    }
}
