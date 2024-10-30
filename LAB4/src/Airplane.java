public abstract class Airplane {
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


    public String getName() { return name; }
    public double getRange() { return range; }
    public int getCapacity() { return capacity; }
    public double getPayload() { return payload; }
    public double getFuelConsumption() { return fuelConsumption; }


    @Override
    public String toString() {
        return "Airplane{name='" + name + "', range=" + range + ", capacity=" + capacity +
                ", payload=" + payload + ", fuelConsumption=" + fuelConsumption + '}';
    }
}
