package com.company;

import java.util.Random;

public class LinkedList implements Songs{

    public void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public static class Node {
        Album.Song song;
        String title;
        double duration;
        Node next;
        Node prev;

        public Node(String title, double duration) {
            this.title = title;
            this.duration = duration;
        }

        @Override
        public String toString() {
            return "Title: " +  song.getTitle()+
                    "\n   Duration: " + song.getDuration();
        }
    }

    Node head;
    Node tail;
    boolean forward = true;

    @Override
    public boolean isEmpty() {
        if (head == null || tail == null) {
            System.out.println("\nError: #Playlist is empty#");
            return true;
        }
        return false;
    }

    public boolean hasPrevious() {
        return tail.prev != null;
    }

    public boolean hasNext() {
        return head.next != null;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }

        int count = 0;
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    @Override
    public void displayPlaylist() {
        Node cur = head;

        if (isEmpty()) {
            System.out.println("\nError: #Playlist is empty#");
            return;
        }

        int count = 0;
        while (cur != null) {
            count++;
            System.out.println("\n" + count + ". " + cur.toString());
            cur = cur.next;
        }
    }

    @Override
    public void sortSong() {
        if (isEmpty()) {
            System.out.println("\nError: #Playlist is empty#");
            return;
        }

        Node cur = head;
        while (cur.next != null) {
            int comparison = cur.title.compareToIgnoreCase(cur.next.title);
            if (comparison > 0) {
                cur.next = cur;
            } else if (comparison < 0){
                cur = cur.next;
            }
        }
    }

    @Override
    public void modifySong(String oldTitle, String title, double duration) {
        if (head == null) {
            head= new Node(title, duration);
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.title.equals(oldTitle)) {
                current.title = title;
                System.out.println("\nSong " + oldTitle + " changed to " + title);
                return;
            }
        }
    }

    public Node getSong(String title) {
        if (isEmpty()) {
            System.out.println("\nError: #Playlist is empty#");
            return null;
        }

        Node cur = head;

        while (cur.next != null) {
            if (cur.title.equals(title)) {
                return cur;
            }
        }
        System.out.println("\nError: #Song not found#");
        return null;
    }

    @Override
    public void deleteSong(String title) {
        if (isEmpty()) {
            System.out.println("\nError: #Playlist is empty#");
            return;
        }

        Node cur = head;

        while (cur.next != null) {
            if (cur.title.equalsIgnoreCase(title)) {
                System.out.println("\nSong " + title + " has been deleted.");
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
    }

    @Override
    public void playSong(String title) {
        if (isEmpty()) {
            System.out.println("\nError: #Playlist is empty#");
            return;
        }

        Node cur = head;
        while (cur.next != null) {
            if (cur.title.equalsIgnoreCase(title)) {
                System.out.println("\nNow playing " + title);
                return;
            }
            cur = cur.next;
        }
        System.out.println("\nError: #Song not found#");
    }

    @Override
    public void shuffleSong() {
        if (isEmpty()) {
            System.out.println("\nError: #Playlist is empty#");
            return;
        }

        Node cur = head;
        Random random = new Random();
        int num = random.nextInt(size());
        int count = 0;

        while (cur.next != null) {
            if (num == count) {
                System.out.println("\nNow playing " + cur.title);
                return;
            }
            count++;
            cur = cur.next;
        }
        System.out.println("\nError: #Playlist is empty#");
    }

    @Override
    public void nextSong() {
        Node cur = head;

        if (!forward) {
            cur = cur.next;
            forward = true;
        }

        if (cur.next == null) {
            cur.next = head;
        }
        cur = cur.next;
    }

    @Override
    public void prevSong() {
        Node cur = head;

        if (forward) {
            cur = cur.prev;
            forward = false;
        }

        if (cur.prev != null) {
            cur = cur.prev;
        } else {
            head.prev = tail;
        }
    }

    @Override
    public void replaySong() {
        if (isEmpty()) {
            System.out.println("\nError: #Playlist is empty#");
            return;
        }

        Node cur = head;

        if (!forward) {
            if (hasNext()) {
                cur = cur.next;
            }
        } else {
            if (hasPrevious()) {
                cur = cur.prev;
            }
        }
    }
}
