package command;
import airline.Airline;
import java.util.Comparator;

public class SortAirplanesByRangeCommand implements Command {
    private Airline airline;
    public SortAirplanesByRangeCommand(Airline airline) {
        this.airline = airline;
    }

    @Override
    public void execute() {
        airline.getAirplanes().sort(Comparator.comparingDouble(a -> a.getRange()));
        System.out.println("Літаки відсортовано за дальністю польоту.");
    }
}
