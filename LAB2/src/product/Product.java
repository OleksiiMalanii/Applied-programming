package product;
public class Product {
    private int id;
    private String name;
    private String manufacturer;
    private double price;
    private int shelflife;
    private int quantity;
    public Product(int id, String name, String manufacturer, double price, int shelflife, int quantity, int i) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.shelflife = shelflife;
        this.quantity = quantity;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getShelfLife() {
        return shelflife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelflife = shelfLife;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", manufacturer=" + manufacturer + ", price=" + price + ", shelflife=" + shelflife + ", quantity=" + quantity + "]";
    }
}

