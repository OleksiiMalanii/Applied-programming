package airline;

public class Airplane {
    private String name;
    private double range;
    private int capacity;
    private double payload;
    private double fuelConsumption;

    public Airplane(String name, double range, int capacity, double payload, double fuelConsumption) {
        this.name = name;
        this.range = range;
        this.capacity = capacity;
        this.payload = payload;
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }
    public double getRange() {
        return range;
    }
    
    @Override
    public String toString() {
        return String.format("Літак: %s, Дальність: %.2f, Місткість: %d, Вантажопідйомність: %.2f, Споживання пального: %.2f",
                name, range, capacity, payload, fuelConsumption);
    }
    public int getCapacity() {
        return capacity;
    }
    public double getPayload() {
        return payload;
    }
}
