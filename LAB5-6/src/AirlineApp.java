import manager.CommandManager;
import commands.*;
import airline.Airline;

import java.util.Scanner;

public class AirlineApp {
    public static void main(String[] args) {
        Airline airline = new Airline();
        Scanner scanner = new Scanner(System.in);
        CommandManager commandManager = new CommandManager();

        commandManager.addCommand(1, new AddAirplaneCommand(airline, scanner));
        commandManager.addCommand(2, new ShowAirplanesCommand(airline));
        commandManager.addCommand(3, new CalculateCapacityAndPayloadCommand(airline));
        commandManager.addCommand(4, new SortAirplanesByRangeCommand(airline));
        commandManager.addCommand(5, new FindAirplaneByFuelConsumptionCommand(airline, scanner));
        commandManager.addCommand(6, new ExitCommand());

        boolean running = true;

        while (running) {
            System.out.println("\nАвіакомпанія Меню:");
            System.out.println("1. Додати літак");
            System.out.println("2. Показати літаки");
            System.out.println("3. Підрахувати загальну місткість і вантажопідйомність");
            System.out.println("4. Сортувати літаки за дальністю польоту");
            System.out.println("5. Пошук літака за споживанням пального");
            System.out.println("6. Вихід");
            System.out.print("Виберіть опцію: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 6) {
                running = false;
            }
            commandManager.executeCommand(choice);
        }
        scanner.close();
    }
}
