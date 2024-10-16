package combat;

import robots.Robot;
import java.io.Serializable;
import java.util.List;

public class BattleRecord implements Serializable {
    private List<Robot> robots;
    private String result;

    public BattleRecord(List<Robot> robots, String result) {
        this.robots = robots;
        this.result = result;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public String getResult() {
        return result;
    }
}