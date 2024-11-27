package test.command;

import airline.Airline;
import airline.Airplane;
import command.SortAirplanesByRangeCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SortAirplanesByRangeCommandTest {
    @Test
    public void testSortAirplanesByRange() {
        Airline airline = new Airline();
        airline.addAirplane(new Airplane("Plane1", 6000, 200, 100.0, 800));
        airline.addAirplane(new Airplane("Plane2", 5000, 150, 75.0, 900));

        new SortAirplanesByRangeCommand(airline).execute();

        assertEquals(5000, airline.getAirplanes().get(0).getRange());
        assertEquals(6000, airline.getAirplanes().get(1).getRange());
    }
}
