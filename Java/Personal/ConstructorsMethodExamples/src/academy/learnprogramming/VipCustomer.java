package academy.learnprogramming;

public class VipCustomer {
    public String name;
    public long creditLimit;
    public String email;

    public VipCustomer() {
        this("John Doe", 10000, "johndoe@gmail.com");
        System.out.println("Default bank account was created");
    }

    public VipCustomer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public VipCustomer(String name, long creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public long getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
}
