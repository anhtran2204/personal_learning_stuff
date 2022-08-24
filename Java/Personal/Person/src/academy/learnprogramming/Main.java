package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        Person jason = new Person();
        Person john = new Person();
        jason.setFirstName("Jason");
        jason.setLastName("Tran");
        jason.setAge(-5);
        john.setFirstName("John");
        john.setLastName("");
        john.setAge(20);
        System.out.println("fullName= " + jason.getFullName());
        System.out.println("teen= " + jason.isTeen());
        System.out.println("fullName= " + john.getFullName());
        System.out.println("teen= " + john.isTeen());
    }
}
