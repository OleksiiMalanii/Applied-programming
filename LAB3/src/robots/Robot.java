package robots;

import java.io.Serializable;

public abstract class Robot implements Serializable {
    protected String name;
    protected int health;
    protected int damage;

    public Robot(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public abstract void attack(Robot opponent);
}