import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public int getId() {
        return id;
    }

    public static ArrayList<String> getProductPositons(int id, int amount) {
        ArrayList<String> positions = new ArrayList<>();
        try {
            // Create a statement
            Statement statement = Database.connection.createStatement();

            // Execute a statement
            ResultSet result = statement
                    .executeQuery("SELECT * FROM product_stocks where product_id = " + id + " limit " + amount + ";");

            if (!result.isBeforeFirst()) {
                System.out.println("No stock fount for product " + id);
                return positions;
            }
            // Loop over the result set
            while (result.next()) {
                System.out.println(result.getInt("row") + " " + result.getInt("collum"));
                positions.add(result.getInt("collum") + "," + result.getInt("row"));

            }
        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
        return positions;
    }

}
