package com.company;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Yorkie");
        dog.breathe();
        dog.eat();

        Parrot parrot = new Parrot("Australian ringneck");
        parrot.eat();
        parrot.breathe();
        parrot.fly();

        Penguin penguin = new Penguin("Emperor Penguin");
        penguin.eat();
        penguin.breathe();
        penguin.fly();
    }
}
