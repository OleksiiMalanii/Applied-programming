package commands;
import manager.Command;
import airline.Airline;
import airline.Airplane;

import java.util.Scanner;

public class AddAirplaneCommand implements Command {
    private Airline airline;
    private Scanner scanner;

    public AddAirplaneCommand(Airline airline, Scanner scanner) {
        this.airline = airline;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Введіть назву літака: ");
        String name = scanner.nextLine();

        System.out.print("Введіть дальність польоту: ");
        double range = Double.parseDouble(scanner.nextLine());

        System.out.print("Введіть місткість пасажирів: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        System.out.print("Введіть вантажопідйомність: ");
        double payload = Double.parseDouble(scanner.nextLine());

        System.out.print("Введіть споживання пального: ");
        double fuelConsumption = Double.parseDouble(scanner.nextLine());

        Airplane airplane = new Airplane(name, range, capacity, payload, fuelConsumption);
        airline.addAirplane(airplane);

        System.out.println("Літак успішно додано.");
    }
}
