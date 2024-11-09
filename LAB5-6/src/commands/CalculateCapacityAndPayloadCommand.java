package commands;

import manager.Command;
import airline.Airline;
import airline.Airplane;

public class CalculateCapacityAndPayloadCommand implements Command {
    private Airline airline;

    public CalculateCapacityAndPayloadCommand(Airline airline) {
        this.airline = airline;
    }

    @Override
    public void execute() {
        int totalCapacity = 0;
        double totalPayload = 0.0;

        for (Airplane airplane : airline.getAirplanes()) {
            totalCapacity += airplane.getCapacity();
            totalPayload += airplane.getPayload();
        }

        System.out.printf("Загальна місткість: %d пасажирів, Загальна вантажопідйомність: %.2f тонн%n", totalCapacity, totalPayload);
    }
}
