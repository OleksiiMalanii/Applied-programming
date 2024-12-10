package command;

import airline.Airline;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class AddAirplaneCommandTest {
    @Test
    public void testAddAirplaneCommand() {
        Airline airline = new Airline();
        String input = "Test Plane\n5000\n200\n100.0\n800\n";
        Scanner scanner = new Scanner(input);

        AddAirplaneCommand command = new AddAirplaneCommand(airline, scanner);
        command.execute();

        assertEquals(1, airline.getAirplanes().size());
        assertTrue(airline.getAirplanes().get(0).toString().contains("Test Plane"));
    }
}
