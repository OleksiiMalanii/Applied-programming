package command;
import airline.Airline;

public class ShowAirplanesCommand implements Command {
    private Airline airline;
    public ShowAirplanesCommand(Airline airline) {
        this.airline = airline;
    }

    @Override
    public void execute() {
        airline.showAirplanes();
    }
}
