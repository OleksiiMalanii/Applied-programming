package java;

import airline.Airline;
import manager.CommandManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AirlineAppTest {

    private ByteArrayInputStream testInput;
    private ByteArrayOutputStream testOutput;
    private Airline airline;

    @BeforeEach
    void setUp() {
        airline = new Airline();
        testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput));
    }

    @Test
    void testAirlineAppRunExitImmediately() {
        // Simulate user input: "0" to exit immediately
        String input = "0\n";
        testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);

        Scanner scanner = new Scanner(System.in);
        CommandManager commandManager = new CommandManager(airline, scanner);

        // Run the application
        assertDoesNotThrow(commandManager::run);

        // Verify the output contains the menu
        String output = testOutput.toString();
        assertTrue(output.contains("Авіакомпанія Меню:"));
        assertTrue(output.contains("0. Вийти"));
    }

    @Test
    void testAirlineAppRunAndChooseInvalidOption() {
        // Simulate user input: "99\n0\n" (invalid option, then exit)
        String input = "99\n0\n";
        testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);

        Scanner scanner = new Scanner(System.in);
        CommandManager commandManager = new CommandManager(airline, scanner);

        // Run the application
        assertDoesNotThrow(commandManager::run);

        // Verify the output handles invalid input
        String output = testOutput.toString();
        assertTrue(output.contains("Invalid command number"));
    }
}
