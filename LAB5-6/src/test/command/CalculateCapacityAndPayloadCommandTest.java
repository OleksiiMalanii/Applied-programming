package test.command;

import airline.Airline;
import airline.Airplane;
import command.CalculateCapacityAndPayloadCommand;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculateCapacityAndPayloadCommandTest {
    @Test
    public void testCalculateCapacityAndPayload() {
        Airline airline = new Airline();
        airline.addAirplane(new Airplane("Plane1", 5000, 100, 50.0, 800));
        airline.addAirplane(new Airplane("Plane2", 7000, 200, 100.0, 1000));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        new CalculateCapacityAndPayloadCommand(airline).execute();

        assertTrue(output.toString().contains("300 passengers"));
        assertTrue(output.toString().contains("150.00 tons"));


    }
}