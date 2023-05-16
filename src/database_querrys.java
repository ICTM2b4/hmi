import java.sql.*;
public class database_querrys {

//  update storage

//  making the required variables
    private int x_locatie = 1;
    private int y_locatie = 1;
    private int productid = 0 ;
    public void updatestorage(){
        try{
            Statement statement = Database.connection.createStatement();
            statement.executeQuery("update product_stocks set product_id =" + productid + " where row = "+ x_locatie +"  && collum = " + y_locatie + ";");

        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
    }

//  making the required variables (start update_customers)
    private String old_firstName;
    private String old_prefix;
    private String old_lastName;
    private String old_streetName;
    private int old_houseNumber;
    private String old_postalCode;
    private String old_city;
    private String old_phoneNumber;
    private String old_email;
    private String new_firstName;
    private String new_prefix;
    private String new_lastName = "testt";
    private String new_streetName;
    private int new_houseNumber;
    private String new_postalCode;
    private String new_city;
    private String new_phoneNumber;
    private String new_email;
    private int id = 2;

    //    update customer
    public void update_customer() {
        try {
            Statement statement = Database.connection.createStatement();
            Statement statement1 = Database.connection.createStatement();

            // Execute a statement
            ResultSet result = statement
                    .executeQuery("SELECT * FROM customers where id = " + this.id + ";");
//            loop over result set
            while (result.next()) {
                this.old_firstName = result.getString("first_name");
                this.old_prefix = String.valueOf(result.getString("prefix"));
                if (result.getString("prefix") == null){
                    old_prefix = null;
                }
                this.old_lastName = result.getString("last_name");
                this.old_streetName = result.getString("streetname");
                this.old_houseNumber = result.getInt("house_number");
                this.old_postalCode = result.getString("postal_code");
                this.old_city = result.getString("city");
                this.old_phoneNumber = result.getString("phonenumber");
                if (result.getString("phonenumber") == null){
                    old_phoneNumber = null;
                }
                this.old_email = result.getString("email");

            }
//          id new_input empty replace new_input with old_input
          if (this.new_email == "" || new_email == null){
              this.new_email = this.old_email;
          }
            if (this.new_phoneNumber == "" || new_phoneNumber == null) {
                this.new_phoneNumber = this.old_phoneNumber;
            }
            if (this.new_city == "" || new_city == null) {
                this.new_city = this.old_city;
            }
            if (this.new_postalCode == "" || new_postalCode == null){
                this.new_postalCode = this.old_postalCode;
            }
            if (this.new_houseNumber == 0){
                this.new_houseNumber = this.old_houseNumber;
            }
            if (this.new_streetName == "" || new_streetName == null){
                this.new_streetName = this.old_streetName;
            }
            if (this.new_lastName == "" || new_lastName == null){
                this.new_lastName = this.old_lastName;
            }
            if ((this.new_prefix == "" || new_prefix == null) && old_prefix != null){
                this.new_prefix = this.old_prefix;
            }
            if (this.new_firstName == "" || new_firstName == null){
                this.new_firstName = this.old_firstName;
            }
//      creating optional inputs
        if (new_prefix!= "" && new_prefix != null) {
            this.new_prefix = ("\"" + new_prefix + "\"");
        } else {
            this.new_prefix = "Null";
        }
        if (new_phoneNumber != "" && new_phoneNumber != null) {
            this.new_phoneNumber = ("\"" + new_phoneNumber + "\"");
        } else {
            this.new_phoneNumber = "Null";
        }
//          execute update
            statement1.executeQuery("update customers set first_name = \"" + new_firstName + "\", prefix =" + new_prefix + ", last_name = \"" + new_lastName + "\", streetname = \"" + new_streetName + "\", house_number =" + new_houseNumber + " , postal_code = \""+ new_postalCode + "\", city = \""+ new_city + "\", phonenumber = " + new_phoneNumber +  ", email = \"" + new_email + "\" where id =" + this.id +  ";");

            // Loop over the result set

        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }}

//  insert customer (start)
//  creating variables
    private String first_name = "Test1";
    private String last_name = "Testen";
    private String streetname = "testerlaan";
    private int house_number = 19;
    private String postal_code = "1234TT";
    private String city = "testing";
    private String email = "test@testen.test";
    private String prefix = "TT";
    private String Phonenumber = "00000";
    public void insert_customer(){
//  setting variables
    try{
        prefix = "TT";
        Phonenumber = "00000";
        this.first_name = first_name;
        if (prefix != "") {
            this.prefix = ("\"" + prefix + "\"");
        } else {
            this.prefix = "Null";
        }
        if (Phonenumber != "") {
            this.Phonenumber = ("\"" + Phonenumber + "\"");
        } else {
            this.Phonenumber = "Null";
        }
        this.last_name = last_name;
        this.streetname = streetname;
        this.house_number = house_number;
        this.postal_code = postal_code;
        this.city = city;
        this.email = email;
//      creating statement + execute
        Statement statement1 = Database.connection.createStatement();
        statement1.executeQuery("insert into customers (first_name, prefix, last_name, streetname, house_number, postal_code, city, phonenumber, email) value (\""+ first_name + "\"," + prefix + ",\"" + last_name + "\",\""+ streetname + "\", " + house_number + ",\"" + postal_code + "\",\"" + city + "\"," + Phonenumber + ",\"" + email + "\");");

    } catch (SQLException e) {
        System.err.println("Failed to execute the query.");
        e.printStackTrace();
    }
}
//  update order (start)
//  creating variables
    private int product_id = 3;
    private int amount = 8;
    private int order_id = 1;
//  executing statments
    public void update_order() {
        try {
            Statement statement1 = Database.connection.createStatement();
            statement1.executeQuery("update order_lines set amount =" + amount + " where order_number ="+ order_id + " && product_id =" + product_id + ";");

        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
    }
//  insert new order (start)
//  creating variables
    private int customer_id = 1;
    private int New_order_id;
    private int product_id_t = 1;
    private int amount_t = 2;
    private int different_products = 2;
    public void insert_order() {
//  executing statement order
        try {
            // Create a statement
            Statement statement1 = Database.connection.createStatement();
            Statement statement2 = Database.connection.createStatement();
//  fetching newest order_id
            statement1.executeQuery("insert into orders (customer_id)" + "value ( " + customer_id + ");");
            ResultSet result = statement1.executeQuery("SELECT max(order_number) as order_id FROM nerdygadgets_v2.orders;");
            while(result.next()){
                this.New_order_id = result.getInt("order_id");
            }
            // Execute a statement
            for (int i = 0; i < different_products; i++) {
                this.amount_t++; //get.amount//
                this.product_id_t++; //get.product_id//
                statement2.executeQuery("insert into order_lines value ("+ New_order_id + ","+ product_id_t + ","+ amount_t + ");");

            }

        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
    }
}

