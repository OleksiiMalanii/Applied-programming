import java.util.Scanner;
import java.util.ArrayList;
/**
 * Представляє число Фібоначчі з його індексом та значенням.
 */
class Fibonaci {
    private int index;
    private long value;
    /**
     * Конструктор для створення представлення числа Фібоначчі.
     *
     * @param index індекс числа Фібоначчі
     * @param value значення числа Фібоначчі
     */
    public Fibonaci(int index, long value) {
        this.index = index;
        this.value = value;
    }
    /**
     * Отримати індекс цього числа Фібоначчі.
     *
     * @return індекс
     */
    public int getIndex() {
        return index;
    }
    /**
     * Отримати значення цього числа Фібоначчі.
     *
     * @return значення
     */
    public long getValue() {
        return value;
    }
    /**
     * Перевіряє, чи може значення Фібоначчі бути представлене як w^2 - 1.
     *
     * @return {@code true}, якщо значення можна представити як w^2 - 1; {@code false} інакше
     */
    public boolean isSquareMinusOne() {
        long possibleW = (long) Math.sqrt(value + 1);
        return possibleW * possibleW == value + 1;
    }
}
/**
 * Клас {@code FibonacciApp} надає методи для генерації та відображення чисел Фібоначчі.
 */
public class FibonacciApp {
    /**
     * Явний конструктор за замовчуванням для класу {@code FibonacciApp}.
     */
    public FibonacciApp() {
    }
    /**
     * Генерує список чисел Фібоначчі.
     *
     * @param N кількість чисел Фібоначчі для генерації
     * @return {@code ArrayList}, що містить перші N чисел Фібоначчі
     */
    public static ArrayList<Fibonaci> generateFibonaci(int N) {
        ArrayList<Fibonaci> fibonaciNumbers = new ArrayList<>();
        long a = 0, b = 1;
        fibonaciNumbers.add(new Fibonaci(1, a));
        fibonaciNumbers.add(new Fibonaci(2, b));
        for (int i = 3; i <= N; i++) {
            long next = a + b;
            fibonaciNumbers.add(new Fibonaci(i, next));
            a = b;
            b = next;
        }
        return fibonaciNumbers;
    }
    /**
     * Запускає програму, запитуючи у користувача кількість чисел Фібоначчі для генерації,
     * генерує відповідні числа, перевіряє та відображає їх представлення як w^2 - 1.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("введіть кількість чисел Фібоначі: ");
        int N = scanner.nextInt();
        ArrayList<Fibonaci> fibonaciNumbers = generateFibonaci(N);
        System.out.println("перевірка на w^2 - 1:");
        for (Fibonaci fib : fibonaciNumbers) {
            System.out.print("F(" + fib.getIndex() + ") = " + fib.getValue());
            if (fib.isSquareMinusOne()) {
                System.out.println(" --> можна представити у вигляді w^2 - 1");
            } else {
                System.out.println(" --> Не можна представити у вигляді w^2 - 1");
            }
        }
        scanner.close();
    }
}