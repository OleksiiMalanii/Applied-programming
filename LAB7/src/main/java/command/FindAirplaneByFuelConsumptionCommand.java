package command;

import airline.Airline;
import airline.Airplane;

import java.util.Scanner;

public class FindAirplaneByFuelConsumptionCommand implements Command {
    private Airline airline;
    private Scanner scanner;

    public FindAirplaneByFuelConsumptionCommand(Airline airline, Scanner scanner) {
        this.airline = airline;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Введіть мінімальне споживання пального: ");
        double minConsumption = Double.parseDouble(scanner.nextLine());

        System.out.print("Введіть максимальне споживання пального: ");
        double maxConsumption = Double.parseDouble(scanner.nextLine());

        for (Airplane airplane : airline.getAirplanes()) {
            double consumption = airplane.getFuelConsumption();
            if (consumption >= minConsumption && consumption <= maxConsumption) {
                System.out.println(airplane);
            }
        }
    }
}
