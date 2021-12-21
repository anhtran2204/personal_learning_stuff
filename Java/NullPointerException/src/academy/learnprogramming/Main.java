package academy.learnprogramming;

import java.util.ArrayList;

public class Main {
    private static ArrayList<Person> person = new ArrayList<Person>();
    public static void main(String[] args) {
        findUser("Anh").getName();

    }

    public static Person findUser(String name) {
        for (int i = 0; i < person.size(); i++) {
            Person check = person.get(i);
            if (check.getName().equals(name)) {
                return check;
            }
        }
        return null;
    }
}
