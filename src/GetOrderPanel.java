import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GetOrderPanel extends JFrame implements ActionListener {

    JButton jbRefresh = new JButton("Refresh");
    JButton jbGetProduct = new JButton("Ophalen");
    JPanel GetProduct = new JPanel();
    JPanel RefreshAndGetProduct = new JPanel();
    JPanel OrderNumberAndText = new JPanel();
    JLabel jlOrderNumber = new JLabel("Ordernummer:");
    JTextField jtOrderNumber = new JTextField();
    String[] recentOrders = {};
    JComboBox<String> jcRecentOrders = new JComboBox<>(recentOrders);

    public JPanel getProduct() {
        Style style = new Style();

        GetProduct.setLayout(new GridLayout(3, 1));
        OrderNumberAndText.setLayout(new GridLayout(1, 2));
        RefreshAndGetProduct.setLayout(new GridLayout(1, 1));
        GetProduct.setBorder(BorderFactory.createTitledBorder(style.getBorder(), "Order ophalen"));

        OrderNumberAndText.add(jlOrderNumber);
        OrderNumberAndText.add(jtOrderNumber);

        GetProduct.add(OrderNumberAndText);
        jcRecentOrders.addActionListener(this);
        GetProduct.add(jcRecentOrders);

        RefreshAndGetProduct.add(jbRefresh);
        RefreshAndGetProduct.add(jbGetProduct);
        jbGetProduct.addActionListener(this);
        jbRefresh.addActionListener(this);
        GetProduct.add(RefreshAndGetProduct);

        JLabel jlGetProduct = new JLabel();
        jlGetProduct.setVerticalAlignment(JLabel.TOP);
        updateRecentOrders();
        return GetProduct;
    }
    /*
     * this method will update the recent orders in the JComboBox
     * it will get the last 5 orders from the database and put them in the JComboBox
     * it will also add a default value
     */
    private void updateRecentOrders() {
        // create arraylist of recent orders
        ArrayList<String> recentOrders = new ArrayList<String>(); // Create an ArrayList object
        recentOrders.add("Selecteer een order");
        try {
            // Create a statement
            Statement statement = Database.connection.createStatement();

            // Execute a statement
            ResultSet result = statement
                    .executeQuery("SELECT * FROM orders ORDER BY order_number DESC limit 5;");

            if (!result.isBeforeFirst()) {
                System.out.println("No orders found.");
                return;
            }

            // Loop over the result set
            while (result.next()) {
                recentOrders.add(result.getString("order_number"));
            }
        } catch (SQLException e) {
            System.err.println("Failed to execute the query.");
            e.printStackTrace();
        }
        // convert arraylist to array
        String[] recentOrdersArray = recentOrders.toArray(new String[0]);

        // Update the JComboBox with the new data
        jcRecentOrders.setModel(new DefaultComboBoxModel<>(recentOrdersArray));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Ophalen")) {
            System.out.println(jtOrderNumber.getText());

            int orderNumber;
            try {
                orderNumber = Integer.parseInt(jtOrderNumber.getText());
            } catch (NumberFormatException ex) {
                System.out.println("Geen geldig getal ingevoerd");
                return;
            }

            try {
                OrderInfoPanel.setSelectedOrder(new Order(orderNumber));
            } catch (Exception ex) {
                System.out.println("Geen geldig ordernummer ingevoerd");
                return;
            }
        }
        if (e.getActionCommand().equals("Refresh")) {
            updateRecentOrders();
        }
        if (e.getSource() == jcRecentOrders) {
            jtOrderNumber.setText((String) jcRecentOrders.getSelectedItem());
            updateRecentOrders();
        }
    }
}
