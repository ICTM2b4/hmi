import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PackingListPanel extends JFrame implements ActionListener {
    JPanel PackingList = new JPanel();
    JPanel PackingListBottom = new JPanel();

    JButton jbPrintOrder = new JButton("Print");

    JLabel jlPackingInfo = new JLabel();

    JLabel jlEmpty6 = new JLabel();
    JLabel jlEmpty7 = new JLabel();
    JLabel jlEmpty8 = new JLabel();

    String[] packingListColumnNames = { "Producten", "Aantal" };

    private static DefaultListModel<String> orderInfoListModel = new DefaultListModel<>();
    private static JList<String> jlOrderInfoList = new JList<>(orderInfoListModel);
    private static JScrollPane jsOrderInfo = new JScrollPane(jlOrderInfoList);


    public static void ProductList(Order order) {
        Order.selectOrder = order;
        ArrayList<Product> products = Order.selectOrder.getProducts();
        orderInfoListModel.clear();
        for (Product product : products) {
            orderInfoListModel.addElement(product.getAmount() + "x : " + product.getName());
            System.out.println(product.getAmount() + product.getName());
        }
    }

    public JPanel getPackingList() {
        Style style = new Style();

        PackingList.setLayout(new BorderLayout());
        PackingList.setBorder(BorderFactory.createTitledBorder(style.getBorder(), "Producten"));

        PackingListBottom.setLayout(new GridLayout(1, 4));

        jlPackingInfo.setVerticalAlignment(JLabel.TOP);

        jsOrderInfo.setFont(style.getFont());

        PackingList.add(jsOrderInfo, BorderLayout.CENTER);

        PackingListBottom.add(jlEmpty6);
        PackingListBottom.add(jlEmpty7);
        PackingListBottom.add(jlEmpty8);
        PackingListBottom.add(jbPrintOrder);
        jbPrintOrder.addActionListener(this);

        PackingList.add(PackingListBottom, BorderLayout.PAGE_END);

        return PackingList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Print")) {
            System.out.println("Print");

            GeneratePDF.generatePDF();
        }
    }
}
