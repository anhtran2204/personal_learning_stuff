package academy.learnprogramming;

public class EnhancedPlayer {
    private String name;
    private int health = 100;
    private String weapon;

    public EnhancedPlayer(String name, int health, String weapon) {
        this.name = name;
        if (health > 0 && health <= 100) {
            this.health = health;
        }
        this.weapon = weapon;
    }

    public String getName(String name) {
        return name;
    }

    public String getWeapon(String weapon) {
        return weapon;
    }

    public int getHealth() {
        return health;
    }

    public void addHealth(int recovery) {
        this.health = this.health + recovery;
        if (this.health > 100) {
            System.out.println("Maximum health reached");
            this.health = 100;
        }
    }
    public void loseHealth(int damage) {
        this.health = this.health - damage;
        System.out.println("The player took "  + damage + " damage");
        if (this.health <= 0) {
            System.out.println("The player has died");
        }
    }

    public int healthRemain() {
        return this.health;
    }
}
