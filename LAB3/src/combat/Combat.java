package combat;

import robots.Robot;
import java.util.List;

public class Combat {
    public static BattleRecord oneOnOne(Robot robot1, Robot robot2) {
        while (robot1.isAlive() && robot2.isAlive()) {
            robot1.attack(robot2);
            if (robot2.isAlive()) {
                robot2.attack(robot1);
            }
        }
        String result = robot1.isAlive() ? robot1.getName() + " wins!" : robot2.getName() + " wins!";
        return new BattleRecord(List.of(robot1, robot2), result);
    }

    public static BattleRecord teamOnTeam(Robot[] team1, Robot[] team2) {
        int team1Index = 0;
        int team2Index = 0;

        while (team1Index < team1.length && team2Index < team2.length) {
            oneOnOne(team1[team1Index], team2[team2Index]);
            if (!team1[team1Index].isAlive()) {
                team1Index++;
            }
            if (!team2[team2Index].isAlive()) {
                team2Index++;
            }
        }
        String result = team1Index < team1.length ? "Team 1 wins!" : "Team 2 wins!";
        return new BattleRecord(List.of(team1), result);
    }
}