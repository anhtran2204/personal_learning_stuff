package com.company;

public class Textbook {
    private String title;
    private String author;
    private String publisher;

    public Textbook(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public Textbook(Textbook textbook) {
        title = textbook.title;
        author = textbook.author;
        publisher = textbook.publisher;
    }

    public void set(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return  "\tTitle: " + title
                + "\n\tAuthor: " + author
                + "\n\tPublisher: " + publisher;
    }
}
