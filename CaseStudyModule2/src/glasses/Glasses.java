package glasses;

public class Glasses {
    private int id;
    private String name;
    private int price;
    private int size;
    private String brand;
    private int quantity;

    public Glasses() {
    }

    public Glasses(int id, String name, int price, int size, String brand, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.brand = brand;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + price + "," + size + "," + brand + "," + quantity;
    }
}
