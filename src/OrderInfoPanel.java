import javax.swing.*;
import java.awt.*;

public class OrderInfoPanel extends JFrame {
    private static JPanel OrderInfo = new JPanel();
    private static JPanel OrderInfoMiddle = new JPanel();
    private static JPanel CustomerInfo1 = new JPanel();
    private static JPanel CustomerInfo2 = new JPanel();
    private static JPanel OrderInfoProducts = new JPanel();
    private static JPanel OrderInfoButtons = new JPanel();

    private static JButton jbChangeProduct = new JButton("Wijzigen");
    private static JButton jbGetOrder = new JButton("Verwerken");

    private static JLabel jlProducts = new JLabel("Producten: ");

    private static JLabel jlOrderInfo = new JLabel();
    private static JLabel jlEmpty4 = new JLabel();
    private static JLabel jlEmpty5 = new JLabel();

    private static JLabel jlName = new JLabel("Naam: ");
    private static JLabel jlAddress = new JLabel("Adres: ");
    private static JLabel jlEmail = new JLabel("E-mail: ");
    private static JLabel jlPhoneNumber = new JLabel("Telefoon: ");
    // data
    private static JLabel jlCustomerName = new JLabel("Piet");
    private static JLabel jlCustomerAddress = new JLabel("Campus 5, Zwolle");
    private static JLabel jlCustomerEmail = new JLabel("piet@gmail.com");
    private static JLabel jlCustomerPhoneNumber = new JLabel("112");
    private static Order selectOrder;
    //TODO: update the product list when a new order is selected
    static String[] orderInfoList = { "Product", "Product", "Product", "Product", "Product", "Product", "Product",
            "Product",
            "Product" };
    private static JList<String> jlOrderInfoList = new JList<>(orderInfoList);
    private static JScrollPane jsOrderInfo = new JScrollPane(jlOrderInfoList);

    public static void setSelectedOrder(Order order) {
        selectOrder = order;
        if (selectOrder == null) {
            jlCustomerName.setText("");
            jlCustomerAddress.setText("");
            jlCustomerEmail.setText("");
            jlCustomerPhoneNumber.setText("");
            return;
        }
        jlCustomerName.setText(selectOrder.getCustomer().getName());
        jlCustomerAddress.setText(selectOrder.getCustomer().getAddress());
        jlCustomerEmail.setText(selectOrder.getCustomer().getEmail());
        jlCustomerPhoneNumber.setText(selectOrder.getCustomer().getPhoneNumber());
    }

    public JPanel getOrderInfo() {
        Style style = new Style();

        OrderInfo.setLayout(new BorderLayout());
        OrderInfo.setBorder(BorderFactory.createTitledBorder(style.getBorder(), "Order info"));

        OrderInfoMiddle.setLayout(new GridLayout(1, 4));

        CustomerInfo1.setLayout(new GridLayout(4, 1));

        CustomerInfo2.setLayout(new GridLayout(4, 1));

        OrderInfoProducts.setLayout(new GridLayout(4, 1));

        OrderInfoButtons.setLayout(new GridLayout(1, 4));

        jlOrderInfo.setVerticalAlignment(JLabel.TOP);

        OrderInfoButtons.add(jlEmpty4);
        OrderInfoButtons.add(jlEmpty5);
        OrderInfoButtons.add(jbChangeProduct);
        OrderInfoButtons.add(jbGetOrder);
        OrderInfo.add(OrderInfoButtons, BorderLayout.PAGE_END);

        CustomerInfo1.add(jlName);
        CustomerInfo1.add(jlAddress);
        CustomerInfo1.add(jlEmail);
        CustomerInfo1.add(jlPhoneNumber);
        OrderInfoMiddle.add(CustomerInfo1);

        CustomerInfo2.add(jlCustomerName);
        CustomerInfo2.add(jlCustomerAddress);
        CustomerInfo2.add(jlCustomerEmail);
        CustomerInfo2.add(jlCustomerPhoneNumber);
        OrderInfoMiddle.add(CustomerInfo2);

        OrderInfoProducts.add(jlProducts);
        OrderInfoMiddle.add(OrderInfoProducts);
        OrderInfoMiddle.add(jsOrderInfo);
        OrderInfo.add(OrderInfoMiddle, BorderLayout.CENTER);

        return OrderInfo;
    }
}
