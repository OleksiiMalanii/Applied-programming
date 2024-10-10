package droids;

public abstract class Droid {
    protected String name;
    protected int health;
    protected int damage;

    public Droid(String name, int health, int damage) {
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
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Droid{name='" + name + "', health=" + health + ", damage=" + damage + "}";
    }
}