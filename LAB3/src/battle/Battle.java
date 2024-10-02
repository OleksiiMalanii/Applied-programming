package battle;

import droids.Droid;
import java.util.List;

public class Battle {
    public static void oneOnOne(Droid droid1, Droid droid2) {
        while (droid1.isAlive() && droid2.isAlive()) {
            droid1.takeDamage(droid2.getDamage());
            if (droid1.isAlive()) {
                droid2.takeDamage(droid1.getDamage());
            }
        }
    }

    public static void teamOnTeam(List<Droid> team1, List<Droid> team2) {
        while (team1.stream().anyMatch(Droid::isAlive) && team2.stream().anyMatch(Droid::isAlive)) {
            for (Droid droid1 : team1) {
                for (Droid droid2 : team2) {
                    if (droid1.isAlive() && droid2.isAlive()) {
                        droid1.takeDamage(droid2.getDamage());
                        if (droid1.isAlive()) {
                            droid2.takeDamage(droid1.getDamage());
                        }
                    }
                }
            }
        }
    }
}