// AirlineApp.java
import manager.CommandManager;
import airline.Airline;
import java.util.Scanner;

public class AirlineApp {
    public static void main(String[] args) {
        Airline airline = new Airline();
        Scanner scanner = new Scanner(System.in);
        CommandManager commandManager = new CommandManager(airline, scanner);
        commandManager.run();
    }
}