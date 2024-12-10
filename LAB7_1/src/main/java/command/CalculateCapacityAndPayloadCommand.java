package command;
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

        System.out.printf("Total capacity: %d passengers, Total payload: %.2f tons%n", totalCapacity, totalPayload);
    }
}
