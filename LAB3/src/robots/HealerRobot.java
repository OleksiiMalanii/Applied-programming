package robots;

public class HealerRobot extends Robot {
    public HealerRobot(String name) {
        super(name, 80, 10);
    }

    @Override
    public void attack(Robot opponent) {
        opponent.takeDamage(this.damage);
    }

    public void heal(Robot ally) {
        ally.health += 10;
    }
}