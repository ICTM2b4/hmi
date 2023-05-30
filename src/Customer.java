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
    private String phoneNumber;
    private String email;

    public Customer(int id) {
        this.id = id;
        getCustomerFromDatabase();
    }

    public String getName() {
        if (this.prefix == null) {
            return this.firstName + " " + this.lastName;
        }
        return this.firstName + " " + this.prefix + " " + this.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return this.streetName + " " + this.houseNumber + ", " + this.postalCode + " " + this.city;
    }

    public String getStad() {
        return this.city;
    }

    public String getStreet_nummer() {
        return this.streetName + "" + this.houseNumber;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public int getId() {
        return this.id;
    }

    public String getPrefix() {
        return this.prefix;
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
                if (result.getString("prefix") == null) {
                    this.prefix = null;
                }
                this.lastName = result.getString("last_name");
                this.streetName = result.getString("streetname");
                this.houseNumber = result.getInt("house_number");
                this.postalCode = result.getString("postal_code");
                this.city = result.getString("city");
                this.phoneNumber = result.getString("phonenumber");
                if (result.getString("phonenumber") == null) {
                    this.phoneNumber = null;
                }
                this.email = result.getString("email");
            }
        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
    }

}
