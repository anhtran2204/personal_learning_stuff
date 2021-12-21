package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal("Lucky", 1, 1, 5, 8);
        Dog dog = new Dog("Dean", 3, 8, 2 ,4, 1, 20, "silky");
        Fish fish = new Fish("Goldy", 4, 3, 2, 2, 2);

//        dog.eat();
        dog.walk();
        fish.swim(5);
    }
}
