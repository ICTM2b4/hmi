public class Product {
    private int id;
    private String name;
    private String color;
    private int amount;

    public Product(int id, String name, String color, int amount) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product [id= " + id + ", name= " + name + ", color= " + color + ", amount= " + amount + "]";
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

}
