package airline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AirlineTest {
    @Test
    public void testAddAirplane() {
        Airline airline = new Airline();
        Airplane airplane = new Airplane("Boeing 747", 10000, 400, 200.5, 2500);
        airline.addAirplane(airplane);
        assertEquals(1, airline.getAirplanes().size());
        assertEquals(airplane, airline.getAirplanes().get(0));
    }

    @Test
    public void testShowAirplanesEmpty() {
        Airline airline = new Airline();
        assertTrue(airline.getAirplanes().isEmpty());
    }
}
