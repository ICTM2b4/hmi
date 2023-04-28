import javax.swing.*;
import java.awt.*;

public class GetProduct extends JFrame {

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
        OrderNumberAndText.setLayout(new GridLayout(1,2));
        RefreshAndGetProduct.setLayout(new GridLayout(1,1));
        GetProduct.setBorder(BorderFactory.createTitledBorder(style.getBorder(), "Product Ophalen"));

        OrderNumberAndText.add(jlOrderNumber);
        OrderNumberAndText.add(jtOrderNumber);

        GetProduct.add(OrderNumberAndText);

        GetProduct.add(jcRecentOrders);

        RefreshAndGetProduct.add(jbRefresh);
        RefreshAndGetProduct.add(jbGetProduct);
        GetProduct.add(RefreshAndGetProduct);

        JLabel jlGetProduct = new JLabel();
        jlGetProduct.setVerticalAlignment(JLabel.TOP);

        return GetProduct;
    }
}
