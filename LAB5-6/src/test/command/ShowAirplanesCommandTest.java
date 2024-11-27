package test.command;

import airline.Airline;
import airline.Airplane;
import command.ShowAirplanesCommand;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ShowAirplanesCommandTest {
    @Test
    public void testShowAirplanesCommand() {
        Airline airline = new Airline();
        airline.addAirplane(new Airplane("Boeing 747", 10000, 400, 200.5, 2500));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        new ShowAirplanesCommand(airline).execute();

        assertTrue(output.toString().contains("Boeing 747"));
    }
}
