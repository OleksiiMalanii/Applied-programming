package robots;

public class WarriorRobot extends Robot {
    public WarriorRobot(String name) {
        super(name, 100, 20);
    }

    @Override
    public void attack(Robot opponent) {
        opponent.takeDamage(this.damage);
    }
}