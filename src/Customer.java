import java.sql.*;

public class Customer {
    private int id;
    private String firstName;
    private String prefix;
    private String lastName;
    private String streetName;
    private int houseNumber;
    private String postalCode;
    private String city;
    private int phoneNumber;
    private String email;

    public Customer(int id) {
        this.id = id;
        getCustomerFromDatabase();
    }

    @Override
    public String toString() {
        return "Customer [id= " + id + ", firstName= " + firstName + ", prefix= " + prefix + ", lastName= " + lastName
                + ", streetName= " + streetName + ", houseNumber= " + houseNumber + ", postalCode= " + postalCode
                + ", city= " + city + ", phoneNumber= " + phoneNumber + ", email= " + email + "]";
    }

    /**
     * this method will get the customers info from the database.
     * 
     * @param id
     * @return
     */
    private void getCustomerFromDatabase() {
        try {
            // Create a statement
            Statement statement = Database.connection.createStatement();

            // Execute a statement
            ResultSet result = statement
                    .executeQuery("SELECT * FROM customers where id = " + this.id + ";");

            // Loop over the result set
            while (result.next()) {
                this.firstName = result.getString("first_name");
                this.prefix = result.getString("prefix");
                this.lastName = result.getString("last_name");
                this.streetName = result.getString("streetname");
                this.houseNumber = result.getInt("house_number");
                this.postalCode = result.getString("postal_code");
                this.city = result.getString("city");
                this.phoneNumber = result.getInt("phonenumber");
                this.email = result.getString("email");
            }
        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
    }

}
