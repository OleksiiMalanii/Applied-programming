package droids;

public class SupportDroid extends Droid {
    public SupportDroid(String name) {
        super(name, 80, 10);
    }
    public void heal(Droid droid) {
        int healAmount = 10;
        int newHealth = droid.getHealth() + healAmount;
        if (newHealth > 100) {
            newHealth = 100; //
        }
        droid.setHealth(newHealth);
    }
}