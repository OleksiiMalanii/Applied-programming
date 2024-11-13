package manager;
import command.*;
import airline.Airline;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private Airline airline;
    private Scanner scanner;
    private Map<Integer, Command> commandMap = new HashMap<>();

    public CommandManager(Airline airline, Scanner scanner) {
        this.airline = airline;
        this.scanner = scanner;
    }

    public void addCommands() {
        addCommand(1, new AddAirplaneCommand(airline, scanner));
        addCommand(2, new ShowAirplanesCommand(airline));
        addCommand(3, new CalculateCapacityAndPayloadCommand(airline));
        addCommand(4, new SortAirplanesByRangeCommand(airline));
        addCommand(5, new FindAirplaneByFuelConsumptionCommand(airline, scanner));
    }

    public void displayMenu() {
        System.out.println("\nАвіакомпанія Меню:");
        System.out.println("0. Вийти");
        System.out.println("1. Додати літак");
        System.out.println("2. Показати літаки");
        System.out.println("3. Підрахувати загальну місткість і вантажопідйомність");
        System.out.println("4. Сортувати літаки за дальністю польоту");
        System.out.println("5. Пошук літака за споживанням пального");
        System.out.print("Виберіть опцію: ");
    }

    public void run() {
        addCommands();
        while (true) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 0) {
                break;
            }
            executeCommand(choice);
        }
        scanner.close();
    }

    public void addCommand(int number, Command command) {
        commandMap.put(number, command);
    }

    public void executeCommand(int number) {
        Command command = commandMap.get(number);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Invalid command number: " + number);
        }
    }
}