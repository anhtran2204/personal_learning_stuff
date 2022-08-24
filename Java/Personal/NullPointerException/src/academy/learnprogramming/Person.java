package academy.learnprogramming;

import java.util.ArrayList;

public class Person {
    private String name;
    private ArrayList<Name> person;

    public Person(String name) {
        this.name = name;
        this.person = new ArrayList<Name>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Name> getPerson() {
        return person;
    }
}
