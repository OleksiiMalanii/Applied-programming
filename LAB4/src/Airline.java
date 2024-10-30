import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Airline {
    private List<Airplane> airplanes;

    public Airline() {
        this.airplanes = new ArrayList<>();
    }

    public void addAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }

    public void removeAirplane(Airplane airplane) {
        airplanes.remove(airplane);
    }

    public double calculateTotalCapacity() {
        return airplanes.stream().mapToInt(Airplane::getCapacity).sum();
    }

    public double calculateTotalPayload() {
        return airplanes.stream().mapToDouble(Airplane::getPayload).sum();
    }

    public void sortAirplanesByRange() {
        airplanes.sort(Comparator.comparingDouble(Airplane::getRange));
    }

    public List<Airplane> findAirplanesByFuelConsumption(double minConsumption, double maxConsumption) {
        List<Airplane> result = new ArrayList<>();
        for (Airplane airplane : airplanes) {
            if (airplane.getFuelConsumption() >= minConsumption && airplane.getFuelConsumption() <= maxConsumption) {
                result.add(airplane);
            }
        }
        return result;
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }
}
