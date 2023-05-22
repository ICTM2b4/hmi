import java.sql.*;
import java.util.ArrayList;
public abstract class database_querrys {

//  update storage

//  making the required variables


    public static ArrayList<Product> getProductsFromDatabasesql() {
        int x_locatie = 1;
        int y_locatie = 1;
        int productid = 0;
        Product product;
        try {
            Statement statement = Database.connection.createStatement();
            ResultSet result = statement.executeQuery("select * from products");
            ArrayList<Product> productlist;
            productlist = new ArrayList<>();
            int amount = 1;
            while (result.next()){
                    product = new Product(result.getInt("id"), result.getString("name"), result.getString("color"), amount);
                    productlist.add(product);
            }
            System.out.println(productlist);
            return productlist;

        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
        return null;
    }

    public void updatestorage(){
        int x_locatie = 1;
        int y_locatie = 1;
        int productid = 0;
        try{
            Statement statement = Database.connection.createStatement();
            statement.executeQuery("update product_stocks set product_id =" + productid + " where row = "+ x_locatie +"  && collum = " + y_locatie + ";");

        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
    }

//  making the required variables (start update_customers)


    //    update customer
    public void update_customer(String new_firstName,String new_prefix,String new_lastName,String new_streetName,int new_houseNumber,String new_postalCode,String new_city,String new_phoneNumber,String new_email, int id) {
        String old_firstName = "";
        String old_prefix = "";
        String old_lastName = "";
        String old_streetName = "";
        int old_houseNumber = 0;
        String old_postalCode = "";
        String old_city = "";
        String old_phoneNumber = "";
        String old_email = "";
        try {
            Statement statement = Database.connection.createStatement();
            Statement statement1 = Database.connection.createStatement();

            // Execute a statement
            ResultSet result = statement
                    .executeQuery("SELECT * FROM customers where id = " + id + ";");
//            loop over result set
            while (result.next()) {
                old_firstName = result.getString("first_name");
                old_prefix = String.valueOf(result.getString("prefix"));
                if (result.getString("prefix") == null){
                    old_prefix = null;
                }
                old_lastName = result.getString("last_name");
                old_streetName = result.getString("streetname");
                old_houseNumber = result.getInt("house_number");
                old_postalCode = result.getString("postal_code");
                old_city = result.getString("city");
                old_phoneNumber = result.getString("phonenumber");
                if (result.getString("phonenumber") == null){
                    old_phoneNumber = null;
                }
                old_email = result.getString("email");

            }
//          id new_input empty replace new_input with old_input
          if (new_email == "" || new_email == null){
              new_email = old_email;
          }
            if (new_phoneNumber == "" || new_phoneNumber == null) {
                new_phoneNumber = old_phoneNumber;
            }
            if (new_city == "" || new_city == null) {
                new_city = old_city;
            }
            if (new_postalCode == "" || new_postalCode == null){
                new_postalCode = old_postalCode;
            }
            if (new_houseNumber == 0){
                new_houseNumber = old_houseNumber;
            }
            if (new_streetName == "" || new_streetName == null){
                new_streetName = old_streetName;
            }
            if (new_lastName == "" || new_lastName == null){
                new_lastName = old_lastName;
            }
            if ((new_prefix == "" || new_prefix == null) && old_prefix != null){
                new_prefix = old_prefix;
            }
            if (new_firstName == "" || new_firstName == null){
                new_firstName = old_firstName;
            }
//      creating optional inputs
        if (new_prefix!= "" && new_prefix != null) {
            new_prefix = ("\"" + new_prefix + "\"");
        } else {
            new_prefix = "Null";
        }
        if (new_phoneNumber != "" && new_phoneNumber != null) {
            new_phoneNumber = ("\"" + new_phoneNumber + "\"");
        } else {
            new_phoneNumber = "Null";
        }
//          execute update
            statement1.executeQuery("update customers set first_name = \"" + new_firstName + "\", prefix =" + new_prefix + ", last_name = \"" + new_lastName + "\", streetname = \"" + new_streetName + "\", house_number =" + new_houseNumber + " , postal_code = \""+ new_postalCode + "\", city = \""+ new_city + "\", phonenumber = " + new_phoneNumber +  ", email = \"" + new_email + "\" where id =" + id +  ";");

            // Loop over the result set

        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }}

//  insert customer (start)
//  creating variables

    public void insert_customer(){
        String first_name = "Test1";
        String last_name = "Testen";
        String streetname = "testerlaan";
        int house_number = 19;
        String postal_code = "1234TT";
        String city = "testing";
        String email = "test@testen.test";
        String prefix = "TT";
        String Phonenumber = "00000";
//  setting variables
    try{
        prefix = "TT";
        Phonenumber = "00000";
        first_name = first_name;
        if (prefix != "") {
            prefix = ("\"" + prefix + "\"");
        } else {
            prefix = "Null";
        }
        if (Phonenumber != "") {
            Phonenumber = ("\"" + Phonenumber + "\"");
        } else {
            Phonenumber = "Null";
        }
        last_name = last_name;
        streetname = streetname;
        house_number = house_number;
        postal_code = postal_code;
        city = city;
        email = email;
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

//  executing statments
    public static void update_order_oldproduct(int product_id, int amount, int order_id) {
        try {
            Statement statement1 = Database.connection.createStatement();
            statement1.executeQuery("update order_lines set amount =" + amount + " where order_number ="+ order_id + " && product_id =" + product_id + ";");

        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
    }
    public static void update_order_oldproductdelete(int product_id, int order_id) {
        try {
            Statement statement1 = Database.connection.createStatement();
            statement1.executeQuery("delete from order_lines where product_id = "+ product_id + " && order_number = "+ order_id+ ";");

        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
    }
    public static void update_order_newproduct(int product_id, int amount, int order_id) {
        try {
            Statement statement1 = Database.connection.createStatement();
            statement1.executeQuery("insert into order_lines(product_id, amount, order_number) values ("+ product_id + ","+ amount + "," + order_id + ");");
        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
    }
//  insert new order (start)
//  creating variables

    public void insert_order() {
        int customer_id = 1;
        int New_order_id = 0;
        int product_id_t = 1;
        int amount_t = 2;
        int different_products = 2;
//  executing statement order
        try {
            // Create a statement
            Statement statement1 = Database.connection.createStatement();
            Statement statement2 = Database.connection.createStatement();
//  fetching newest order_id
            statement1.executeQuery("insert into orders (customer_id)" + "value ( " + customer_id + ");");
            ResultSet result = statement1.executeQuery("SELECT max(order_number) as order_id FROM nerdygadgets_v2.orders;");
            while(result.next()){
                New_order_id = result.getInt("order_id");
            }
            // Execute a statement
            for (int i = 0; i < different_products; i++) {
                amount_t++; //get.amount//
                product_id_t++; //get.product_id//
                statement2.executeQuery("insert into order_lines value ("+ New_order_id + ","+ product_id_t + ","+ amount_t + ");");

            }

        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
    }
}

