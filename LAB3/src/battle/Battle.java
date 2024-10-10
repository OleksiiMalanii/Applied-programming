package battle;

import droids.BattleDroid;
import droids.Droid;
import droids.SupportDroid;

import java.util.List;

public class Battle {
    public static void oneOnOne(Droid droid1, Droid droid2) {
        while (droid1.isAlive() && droid2.isAlive()) {
            droid1.takeDamage(droid2.getDamage());
            if (!droid1.isAlive()) {
                break;
            }
            droid2.takeDamage(droid1.getDamage());
            if (droid1 instanceof SupportDroid) {
                ((SupportDroid) droid1).heal(droid1);
            }
            if (droid2 instanceof SupportDroid) {
                ((SupportDroid) droid2).heal(droid2);
            }
        }
    }
    public static void teamOnTeam(List<Droid> team1, List<Droid> team2) {
        int roundLimit = 100;
        int round = 0;
        while (team1.stream().anyMatch(Droid::isAlive) && team2.stream().anyMatch(Droid::isAlive) && round < roundLimit) {
            for (Droid droid1 : team1) {
                for (Droid droid2 : team2) {
                    if (droid1.isAlive() && droid2.isAlive()) {
                        if (droid1 instanceof SupportDroid && team1.stream().anyMatch(droid -> droid instanceof BattleDroid && droid.isAlive())) {
                            ((SupportDroid) droid1).heal(team1.stream().filter(droid -> droid instanceof BattleDroid && droid.isAlive()).findFirst().get());
                        } else {
                            droid1.takeDamage(droid2.getDamage());
                        }
                        if (droid2 instanceof SupportDroid && team2.stream().anyMatch(droid -> droid instanceof BattleDroid && droid.isAlive())) {
                            ((SupportDroid) droid2).heal(team2.stream().filter(droid -> droid instanceof BattleDroid && droid.isAlive()).findFirst().get());
                        } else {
                            droid2.takeDamage(droid1.getDamage());
                        }
                    }
                }
            }
            round++;
        }
        if (round == roundLimit) {
            System.out.println("The battle ended in a draw after reaching the round limit.");
        }
    }
}