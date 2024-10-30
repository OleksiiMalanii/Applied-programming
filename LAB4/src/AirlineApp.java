import java.util.Scanner;
import java.util.List;
public class AirlineApp {
    public static void main(String[] args) {
        Airline airline = new Airline();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nАвіакомпанія:");
            System.out.println("1. Додати літак");
            System.out.println("2. Показати літаки");
            System.out.println("3. Підрахувати загальну місткість і вантажопідйомність");
            System.out.println("4. Сортувати літаки за дальністю польоту");
            System.out.println("5. Пошук літака за споживанням пального");
            System.out.println("6. Вихід");
            System.out.print("Виберіть опцію: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addAirplane(airline, scanner);
                    break;
                case 2:
                    showAirplanes(airline);
                    break;
                case 3:
                    calculateCapacityAndPayload(airline);
                    break;
                case 4:
                    airline.sortAirplanesByRange();
                    System.out.println("Літаки відсортовані за дальністю польоту.");
                    break;
                case 5:
                    findAirplaneByFuelConsumption(airline, scanner);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Невірний вибір, спробуйте ще раз.");
            }
        }
        scanner.close();
    }

    private static void addAirplane(Airline airline, Scanner scanner) {
        System.out.print("Введіть назву літака: ");
        String name = scanner.next();
        System.out.print("Введіть дальність польоту: ");
        double range = scanner.nextDouble();
        System.out.print("Введіть місткість пасажирів: ");
        int capacity = scanner.nextInt();
        System.out.print("Введіть вантажопідйомність: ");
        double payload = scanner.nextDouble();
        System.out.print("Введіть споживання пального: ");
        double fuelConsumption = scanner.nextDouble();

        Airplane airplane = new PassengerPlane(name, range, capacity, payload, fuelConsumption);
        airline.addAirplane(airplane);
        System.out.println("Літак додано.");
    }

    private static void showAirplanes(Airline airline) {
        for (Airplane airplane : airline.getAirplanes()) {
            System.out.println(airplane);
        }
    }

    private static void calculateCapacityAndPayload(Airline airline) {
        System.out.println("Загальна місткість: " + airline.calculateTotalCapacity());
        System.out.println("Загальна вантажопідйомність: " + airline.calculateTotalPayload());
    }

    private static void findAirplaneByFuelConsumption(Airline airline, Scanner scanner) {
        System.out.print("Введіть мінімальне споживання пального: ");
        double minConsumption = scanner.nextDouble();
        System.out.print("Введіть максимальне споживання пального: ");
        double maxConsumption = scanner.nextDouble();

        List<Airplane> result = airline.findAirplanesByFuelConsumption(minConsumption, maxConsumption);
        if (result.isEmpty()) {
            System.out.println("Немає літаків, що відповідають заданому діапазону.");
        } else {
            result.forEach(System.out::println);
        }
    }
}
