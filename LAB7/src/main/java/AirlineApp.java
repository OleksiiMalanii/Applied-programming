// AirlineApp.java

import airline.Airline;
import manager.CommandManager;

import java.util.Scanner;

public class AirlineApp {
    public static void main(String[] args) {
        Airline airline = new Airline();
        Scanner scanner = new Scanner(System.in);
        CommandManager commandManager = new CommandManager(airline, scanner);
        commandManager.run();
    }
}