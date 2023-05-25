import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        GetProduct.add(jcRecentOrders);

        RefreshAndGetProduct.add(jbRefresh);
        RefreshAndGetProduct.add(jbGetProduct);
        jbGetProduct.addActionListener(this);
        GetProduct.add(RefreshAndGetProduct);

        JLabel jlGetProduct = new JLabel();
        jlGetProduct.setVerticalAlignment(JLabel.TOP);

        return GetProduct;
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
                Order sharedOrderNumber = new Order(orderNumber);
                OrderInfoPanel.setSelectedOrder(sharedOrderNumber);
                PackingListPanel.ProductList(sharedOrderNumber);
            } catch (Exception ex) {
                System.out.println("Geen geldig ordernummer ingevoerd");
                return;
            }
        }

    }
}
