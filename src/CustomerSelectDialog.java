import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.*;

public class CustomerSelectDialog extends JDialog implements ActionListener {
    String[] Customers = {};
    JComboBox<String> jcCustomers = new JComboBox<>(Customers);

    public CustomerSelectDialog(JFrame frame) {
        super(frame, true);
        JPanel panel = new JPanel();

        ArrayList<String> customers = new ArrayList<String>(); // Create an ArrayList object
        customers.add("Selecteer een customer");
        customers.add("new customer");
        try {
            // Create a statement
            Statement statement = Database.connection.createStatement();

            // Execute a statement
            ResultSet result = statement
                    .executeQuery("SELECT * FROM customers ORDER BY first_name;");

            if (!result.isBeforeFirst()) {
                System.out.println("No orders found.");
                return;
            }

            // Loop over the result set
            while (result.next()) {
                customers.add(Database_querys.getcustomername(result.getInt("id")));
            }
        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
        Customers = customers.toArray(new String[0]);
        jcCustomers.setModel(new DefaultComboBoxModel<>(Customers));
        jcCustomers.setPreferredSize(new Dimension(200, 50));
        panel.setLayout(new BoxLayout(panel, 0));
        jcCustomers.addActionListener(this);

        panel.add(jcCustomers);

        add(panel);
        setTitle("Select customer");
        setSize(280, 100);
        setLocation(800, 40);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean isdisposed = true;
        if (e.getSource() == jcCustomers) {
            int customerid = 0;
            String customer = jcCustomers.getSelectedItem().toString();
            if (customer != "new customer") {
                String[] parts = customer.split(" ");
                if (parts.length == 2) {
                    customerid = Database_querys.getcustomerid(parts[0], parts[1]);
                    System.out.println(customerid);
                } else {
                    customerid = Database_querys.getcustomerid(parts[0], parts[1], parts[2]);
                    System.out.println(customerid);
                }
            } else {
                dispose();
                isdisposed = false;
                new CustomerCreateDialog(this);
                customerid = Database_querys.getmaxcustomerid();
            }if (isdisposed) {
                dispose();
            }
            new ToevoegDialog(this, customerid);

        }

    }
}

