package airline;
import java.util.ArrayList;
import java.util.List;

public class Airline {
    private List<Airplane> airplanes = new ArrayList<>();
    public void addAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }
    public List<Airplane> getAirplanes() {
        return airplanes;
    }
    public void showAirplanes() {
        if (airplanes.isEmpty()) {
            System.out.println("Немає літаків у авіакомпанії.");
        } else {
            airplanes.forEach(System.out::println);
        }
    }
}
