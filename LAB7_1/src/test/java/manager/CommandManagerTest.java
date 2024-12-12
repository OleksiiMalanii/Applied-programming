package manager;

import airline.Airline;
import command.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CommandManagerTest {

    private Airline testAirline;
    private Scanner testScanner;
    private CommandManager commandManager;

    @BeforeEach
    void setUp() {
        testAirline = new Airline();
        testScanner = new Scanner("");
        commandManager = new CommandManager(testAirline, testScanner);
    }

    @Test
    void testAddCommands() {
        commandManager.addCommand(1, () -> System.out.println("AddAirplaneCommand executed"));
        commandManager.addCommand(2, () -> System.out.println("ShowAirplanesCommand executed"));
        commandManager.addCommand(3, () -> System.out.println("CalculateCapacityAndPayloadCommand executed"));
        commandManager.addCommand(4, () -> System.out.println("SortAirplanesByRangeCommand executed"));
        commandManager.addCommand(5, () -> System.out.println("FindAirplaneByFuelConsumptionCommand executed"));
        assertDoesNotThrow(() -> commandManager.executeCommand(1));
        assertDoesNotThrow(() -> commandManager.executeCommand(2));
        assertDoesNotThrow(() -> commandManager.executeCommand(3));
        assertDoesNotThrow(() -> commandManager.executeCommand(4));
        assertDoesNotThrow(() -> commandManager.executeCommand(5));
    }

    @Test
    void testExecuteValidCommand() {
        Command sampleCommand = () -> System.out.println("Sample command executed");
        commandManager.addCommand(1, sampleCommand);

        assertDoesNotThrow(() -> commandManager.executeCommand(1));
    }

    @Test
    void testExecuteInvalidCommand() {
        assertDoesNotThrow(() -> commandManager.executeCommand(99));
    }

    @Test
    void testRunAndExit() {
        String input = "0\n";
        testScanner = new Scanner(input);
        commandManager = new CommandManager(testAirline, testScanner);

        assertDoesNotThrow(() -> commandManager.run());
    }
}
