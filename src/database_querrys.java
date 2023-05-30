import javax.swing.*;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.awt.*;

import static java.sql.Types.VARCHAR;


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
            while (result.next()) {
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

    public void updatestorage() {
        int x_locatie = 1;
        int y_locatie = 1;
        int productid = 0;
        try {
            Statement statement = Database.connection.createStatement();
            statement.executeQuery("update product_stocks set product_id =" + productid + " where row = " + x_locatie + "  && collum = " + y_locatie + ";");

        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
    }

//  making the required variables (start update_customers)


    //    update customer
    public static void update_customer(String new_firstName, String new_prefix, String new_lastName, String new_streetName, int new_houseNumber, String new_postalCode, String new_city, String new_phoneNumber, String new_email, int id) throws SQLException {
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
            PreparedStatement statement1 = Database.connection.prepareStatement("update customers set first_name = ? , prefix = ? , last_name =  ?, streetname = ? , house_number = ? , postal_code = ? , city = ? , phonenumber = ? , email = ? where id = ?;");

            // Execute a statement
            ResultSet result = statement
                    .executeQuery("SELECT * FROM customers where id = " + id + ";");
//            loop over result set
            while (result.next()) {
                old_firstName = result.getString("first_name");
                old_prefix = String.valueOf(result.getString("prefix"));
                if (result.getString("prefix") == null) {
                    old_prefix = null;
                }
                old_lastName = result.getString("last_name");
                old_streetName = result.getString("streetname");
                old_houseNumber = result.getInt("house_number");
                old_postalCode = result.getString("postal_code");
                old_city = result.getString("city");
                old_phoneNumber = result.getString("phonenumber");
                if (result.getString("phonenumber") == null) {
                    old_phoneNumber = null;
                }
                old_email = result.getString("email");

            }
//          id new_input empty replace new_input with old_input
            if (new_email == "" || new_email == null) {
                new_email = old_email;
            }
            if (new_phoneNumber == "" || new_phoneNumber == null) {
                new_phoneNumber = old_phoneNumber;
            }
            if (new_city == "" || new_city == null) {
                new_city = old_city;
            }
            if (new_postalCode == "" || new_postalCode == null) {
                new_postalCode = old_postalCode;
            }
            if (new_houseNumber == 0) {
                new_houseNumber = old_houseNumber;
            }
            if (new_streetName == "" || new_streetName == null) {
                new_streetName = old_streetName;
            }
            if (new_lastName == "" || new_lastName == null) {
                new_lastName = old_lastName;
            }
            if ((new_prefix == "" || new_prefix == null) && old_prefix != null) {
                new_prefix = old_prefix;
            }
            if (new_firstName == "" || new_firstName == null) {
                new_firstName = old_firstName;
            }
//      creating optional inputs
            new_streetName.strip();
            statement1.setString(1, new_firstName);
            if (new_prefix == null){
                statement1.setNull(2, VARCHAR);
            }else {
                statement1.setString(2, new_prefix);
            }
            statement1.setString(3, new_lastName);
            statement1.setString(4, new_streetName);
            statement1.setInt(5, new_houseNumber);
            statement1.setString(6, new_postalCode);
            statement1.setString(7, new_city);
            if (new_phoneNumber == null){
                statement1.setNull(8, VARCHAR);
            }else {
                statement1.setString(8, new_phoneNumber);
            }
            statement1.setString(9, new_email);
            statement1.setInt(10, id);
            statement1.executeQuery();
//          execute update
//            statement1.executeQuery("update customers set first_name = \"" + new_firstName + "\", prefix =" + new_prefix + ", last_name = \"" + new_lastName + "\", streetname = \"" + new_streetName + "\", house_number =" + new_houseNumber + " , postal_code = \"" + new_postalCode + "\", city = \"" + new_city + "\", phonenumber = " + new_phoneNumber + ", email = \"" + new_email + "\" where id =" + id + ";");

            // Loop over the result set

        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            throw e;
        }
    }

//  insert customer (start)
//  creating variables

    public static void insert_customer(String first_name, String last_name, String streetname, int house_number, String postal_code, String city, String email, String  prefix, String Phonenumber) {
//  setting variables
        int phonenumber = 0;
        Phonenumber.strip();
        try {
            if (prefix != "") {
            } else {
                prefix = null;
            }
            if (!Phonenumber.equals("")) {
                phonenumber = Integer.valueOf(Phonenumber);
            } else {
                phonenumber = 0;
            }
//      creating statement + execute
            PreparedStatement statement1 = Database.connection.prepareStatement("insert into customers (first_name, prefix, last_name, streetname, house_number, postal_code, city, phonenumber, email) value (?, ?, ?, ?, ?, ?, ?, ?, ?);");
            statement1.setString(1, first_name);
            if (prefix == null){
                statement1.setNull(2, VARCHAR);
            }else {
                statement1.setString(2, prefix);
            }
            statement1.setString(3, last_name);
            statement1.setString(4, streetname);
            statement1.setInt(5, house_number);
            statement1.setString(6, postal_code);
            statement1.setString(7, city);
            statement1.setInt(8, phonenumber);
            statement1.setString(9, email);
            statement1.executeQuery();

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
            statement1.executeQuery("update order_lines set amount =" + amount + " where order_number =" + order_id + " && product_id =" + product_id + ";");

        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
    }

    public static void update_order_oldproductdelete(int product_id, int order_id) {
        try {
            Statement statement1 = Database.connection.createStatement();
            statement1.executeQuery("delete from order_lines where product_id = " + product_id + " && order_number = " + order_id + ";");

        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
    }

    public static void update_order_newproduct(int product_id, int amount, int order_id) {
        try {
            Statement statement1 = Database.connection.createStatement();
            statement1.executeQuery("insert into order_lines(product_id, amount, order_number) values (" + product_id + "," + amount + "," + order_id + ");");
        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
    }
//  insert new order (start)
//  creating variables
public static void create_new_order(int customer_id){
        try {
            Statement statement = Database.connection.createStatement();
            statement.executeQuery("insert into orders (customer_id)" + "value (" + customer_id + ");");
        } catch (SQLException e){
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
}
    public static void insert_order(int product_id, int amount) {

        int New_order_id = 0;

//  executing statement order
        try {
            // Create a statement

            Statement statement = Database.connection.createStatement();
//  fetching newest order_id


            New_order_id = getmaxorderid();
            if (New_order_id == 0) {
                Component frame = null;
                JOptionPane.showMessageDialog(frame, "Could not insert order");
            } else {
                System.out.println(New_order_id);
                statement.executeQuery("insert into order_lines value (" + New_order_id + "," + product_id + "," + amount + ");");
            }

        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
    }

    public static Color getcolorfromdatabase(int x, int y) {
        String kleur = "";
        Color color;

        try {
            // Create a statement
            Statement statement1 = Database.connection.createStatement();


            ResultSet result = statement1.executeQuery("select color from products where id = (select product_id from product_stocks where row = " + y + " && collum = " + x + ");");
            while (result.next()) {
                kleur = result.getString("color");
            }

        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
        if (kleur == "onbekend") {
            return Color.black;
        }
        try {
            // get color by hex or octal value
            return Color.decode(kleur);
        } catch (NumberFormatException nfe) {
            // if we can't decode lets try to get it by name
            try {
                // try to get a color by name using reflection
                final Field f = Color.class.getField(kleur);

                return (Color) f.get(null);
            } catch (Exception ce) {
                // if we can't get any color return black
                return Color.black;
            }
        }
    }

    public static int getmaxorderid() {
        int max_order_id = 0;
        try {
            Statement statement = Database.connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT max(order_number) as order_id FROM nerdygadgets_v2.orders;");
            while (result.next()) {
                max_order_id = result.getInt("order_id");
            }
            return max_order_id;
        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
            return max_order_id;
        }

    }

    public static String getcustomername(int id) {
        String naam = "";
        try {
            Statement statement = Database.connection.createStatement();
            ResultSet result = statement.executeQuery("select first_name, prefix, last_name from customers where id = " + id + ";");
            while (result.next()) {
                if (result.getString("prefix") != null) {
                    naam = (result.getString("first_name") + " " + result.getString("prefix") + " " + result.getString("last_name"));
                } else {
                    naam = (result.getString("first_name") + " " + result.getString("last_name"));
                }
            }
            return naam;
        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
            return naam;
        }
    }


    public static int getcustomerid(String first_name, String prefix, String last_name) {
        int id = 0;
        ResultSet result;
        try {
            Statement statement = Database.connection.createStatement();


            result = statement.executeQuery("select id from customers where first_name = \"" + first_name + "\"&& last_name = \"" + last_name + "\"&& prefix = \"" + prefix + "\";");

            while (result.next()) {
                id = result.getInt("id");
            }
            return id;
        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
            return id;
        }

    }

    public static int getcustomerid(String first_name, String last_name) {
        int id = 0;
        ResultSet result;
        try {
            Statement statement = Database.connection.createStatement();


            result = statement.executeQuery("select id from customers where first_name = \"" + first_name + "\"&& last_name = \"" + last_name + "\";");

            while (result.next()) {
                id = result.getInt("id");
            }
            return id;
        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
            return id;
        }


    }
    public static int getmaxcustomerid(){
        int id = 0;
        try {
            Statement statement = Database.connection.createStatement();
            ResultSet result = statement.executeQuery("select max(id) as id from customers;");
            while (result.next()) {
                id = result.getInt("id");
            }
            return id;
        } catch (SQLException e){
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
            return id;
        }
    }
}