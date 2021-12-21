package com.company;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LinkedList playlist = new LinkedList();
    private static final AlbumList albumList = new AlbumList();

    public void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter: ");
            String albumName = scanner.nextLine();
            System.out.print("\nEnter: ");
            String artistName = scanner.nextLine();

            albumList.addAlbum(albumName, artistName);
            System.out.println();
        }

        albumList.displayAlbums();

        
    }
}



