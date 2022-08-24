package academy.learnprogramming;

public class Player {
    public String fullName;
    public int health;
    public String weapon;

    public void loseHealth(int damage) {
        this.health = this.health - damage;
        if (this.health <= 0) {
            System.out.println("The player has died");
        }
    }

    public int healthRemain() {
        return this.health;
    }
}
