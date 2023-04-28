import java.sql.*;

public abstract class Database {
    static public Connection connection;
    // Connection parameters
    static private String url = "jdbc:mariadb://localhost:3306/nerdygadgets_v2";
    static private String user = "root";
    static private String password = "";

    /**
     * this method will open a connection to the database using the connection
     * parameters
     */
    static public void open() {
        try {
            // Create a connection to the database
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }

    /**
     * this method will close the connection to the database
     */
    static public void close() {
        try {
            connection.close();
            System.out.println("Connection closed.");
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }

}
