import javax.swing.*;
import java.awt.*;

public class OrderInfo extends JFrame {
    JPanel OrderInfo = new JPanel();
    JPanel OrderInfoMiddle = new JPanel();
    JPanel CustomerInfo1 = new JPanel();
    JPanel CustomerInfo2 = new JPanel();
    JPanel OrderInfoProducts = new JPanel();
    JPanel OrderInfoButtons = new JPanel();

    JButton jbChangeProduct = new JButton("Wijzigen");
    JButton jbGetOrder = new JButton("Verwerken");

    JLabel jlProducts = new JLabel("Producten: ");

    JLabel jlOrderInfo = new JLabel();
    JLabel jlEmpty4 = new JLabel();
    JLabel jlEmpty5 = new JLabel();

    JLabel jlName = new JLabel("Naam: ");
    JLabel jlAddress = new JLabel("Adres: ");
    JLabel jlEmail = new JLabel("E-mail: ");
    JLabel jlPhoneNumber = new JLabel("Telefoon: ");

    JLabel jlCustomerName = new JLabel("Piet");
    JLabel jlCustomerAddress = new JLabel("Campus 5, Zwolle");
    JLabel jlCustomerEmail = new JLabel("piet@gmail.com");
    JLabel jlCustomerPhoneNumber = new JLabel("112");

    String[] orderInfoList = {"Product", "Product", "Product", "Product", "Product", "Product", "Product", "Product", "Product"};
    JList<String> jlOrderInfoList = new JList<>(orderInfoList);
    JScrollPane jsOrderInfo = new JScrollPane(jlOrderInfoList);


    public JPanel getOrderInfo() {
        Style style = new Style();

        OrderInfo.setLayout(new BorderLayout());
        OrderInfo.setBorder(BorderFactory.createTitledBorder(style.getBorder(), "Order info"));

        OrderInfoMiddle.setLayout(new GridLayout(1,4));

        CustomerInfo1.setLayout(new GridLayout(4,1));

        CustomerInfo2.setLayout(new GridLayout(4,1));

        OrderInfoProducts.setLayout(new GridLayout(4,1));

        OrderInfoButtons.setLayout(new GridLayout(1,4));

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
