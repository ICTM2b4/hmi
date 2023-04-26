import java.sql.*;
import java.util.ArrayList;

public class Order {
    private int orderNumber;
    // arrayList of products
    private Customer customer;
    private ArrayList<Product> products = new ArrayList<Product>();

    public Order(int orderNumber) {
        if (!checkIfOrderExists(orderNumber))
            throw new IllegalArgumentException("Order bestaat niet");
        this.orderNumber = orderNumber;
        getProductsFromDatabase();
        getCustomerFromDatabase();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    private boolean checkIfOrderExists(int orderNumber) {
        try {
            // Create a statement
            Statement statement = Database.connection.createStatement();

            // Execute a statement
            ResultSet result = statement
                    .executeQuery("SELECT * FROM orders where order_number = " + orderNumber + ";");

            // Loop over the result set
            while (result.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Order [orderNumber= " + orderNumber + ",\n customer= " + customer + ",\n products= " + products + "]";
    }

    private void getCustomerFromDatabase() {
        try {
            // Create a statement
            Statement statement = Database.connection.createStatement();

            // Execute a statement
            ResultSet result = statement
                    .executeQuery("SELECT * FROM orders where order_number = " + this.orderNumber + ";");

            // Loop over the result set
            while (result.next()) {
                this.customer = new Customer(result.getInt("customer_id"));
            }
        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
    }

    /**
     * this method will get all the products related to the order.
     * 
     * @return
     */
    private void getProductsFromDatabase() {
        try {
            // Create a statement
            Statement statement = Database.connection.createStatement();

            // Execute a statement
            ResultSet result = statement
                    .executeQuery("SELECT * FROM order_lines where order_number = " + this.orderNumber + ";");

            if (!result.isBeforeFirst()) {
                System.out.println("No products found for order number " + this.orderNumber);
                return;
            }
            // Loop over the result set
            while (result.next()) {
                products.add(getProductFromDatabase(result.getInt("product_id"), result.getInt("amount")));
            }
        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
    }

    /**
     * this method will get a single product from the database.
     * 
     * @param id     the id of the product
     * @param amount the ordered amount of the product
     * @return Product
     */
    private Product getProductFromDatabase(int id, int amount) {
        Product product = null;
        try {
            // Create a statement
            Statement statement = Database.connection.createStatement();

            // Execute a statement
            ResultSet result = statement
                    .executeQuery("SELECT * FROM products where id = " + id + ";");

            // Loop over the result set
            while (result.next()) {
                product = new Product(result.getInt("id"), result.getString("name"), result.getString("color"), amount);
            }
        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
        return product;
    }

    /**
     * this method will get a single product from the database.
     * it also defaults the amount to 1.
     * 
     * @param id
     * @return Product
     */
    private Product getProductFromDatabase(int id) {
        return getProductFromDatabase(id, 1);
    }
}
