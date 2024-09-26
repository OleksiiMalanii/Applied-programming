package main;
import product.Product;

public class Main{
    public static void main(String[] args) {
        Product[] products = {
                new Product(1, "milk", "Ferma", 40, 7, 10, 100),
                new Product(2, "bread", "Bread", 10, 1, 20, 200),
                new Product(3, "cheese", "Ferma", 50, 3, 5, 300),
                new Product(4, "butter", "Ferma", 60, 4, 15, 400),
                new Product(5, "milk", "Danone", 30, 5, 10, 500),
        };
        System.out.println("Products with name milk:");
        printbyname(products, "milk");
        System.out.println("\nProducts with name milk and price not higher than 40:");
        printbynameandprice(products, "milk", 40);
        System.out.println("\nProducts with shelf life more than 5:");
        printbyshelflife(products, 5);
        int sum = 0;
        for(int i = 1; i < products.length; i++){
            sum += products[i].getPrice();
        }
       sum /= products.length;
        System.out.println(sum);
    }
    public static void printbyname(Product[] products, String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                System.out.println(product);
            }
        }
    }
    public static void printbynameandprice(Product[] products, String name, double price) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getPrice() == price) {
                System.out.println(product);
            }
        }
    }
    public static void printbyshelflife (Product[] products, int shelflife) {
        for (Product product : products) {
            if (product.getShelfLife() == shelflife) {
                System.out.println(product);
            }
        }
    }

}
