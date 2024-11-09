package manager;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private Map<Integer, Command> commands = new HashMap<>();

    public void addCommand(int option, Command command) {
        commands.put(option, command);
    }

    public void executeCommand(int option) {
        Command command = commands.get(option);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Невірний вибір, спробуйте ще раз.");
        }
    }
}
