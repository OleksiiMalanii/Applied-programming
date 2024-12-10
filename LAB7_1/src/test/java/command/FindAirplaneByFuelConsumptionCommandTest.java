package command;

import airline.Airline;
import airline.Airplane;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class FindAirplaneByFuelConsumptionCommandTest {
    @Test
    public void testFindAirplaneByFuelConsumption() {
        Airline airline = new Airline();
        airline.addAirplane(new Airplane("Plane1", 5000, 150, 75.0, 900));
        airline.addAirplane(new Airplane("Plane2", 7000, 200, 100.0, 1200));

        String input = "800\n1000\n";
        Scanner scanner = new Scanner(input);

        FindAirplaneByFuelConsumptionCommand command = new FindAirplaneByFuelConsumptionCommand(airline, scanner);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        command.execute();
        assertTrue(output.toString().contains("Plane1"));
        assertFalse(output.toString().contains("Plane2"));
    }
}
