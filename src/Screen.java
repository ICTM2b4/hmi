import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame implements ActionListener {
    private JButton jbAddOrder;
    private JButton jbRefresh;
    private JButton jbGetProduct;
    private JButton jbChangeProduct;
    private JButton jbGetOrder;
    private JButton jbPrintOrder;

    private JLabel jlEmpty;
    private JLabel jlEmpty2;
    private JLabel jlEmpty3;
    private JLabel jlStock;
    private JLabel jlGetProduct;
    private JLabel jlStockInfo;
    private JLabel jlOrderInfo;
    private JLabel jlOrderNumber;

    private JTextField jtOrderNumber;

    private String[] recentOrders = {};
    private JComboBox jcRecentOrders;

    private JList jlStockList;
    private JScrollPane jsStock;
    private String[] stocklist = { "Product: " + "aantal", "Product: " + "aantal", "Product: " + "aantal",
            "Product: " + "aantal", "Product: " + "aantal", "Product: " + "aantal", "Product: " + "aantal",
            "Product: " + "aantal", "Product: " + "aantal", "Product: " + "aantal", "Product: " + "aantal" };

    public Screen() {
        setTitle("HMI");
        setSize(1000, 500);
        setMinimumSize(new Dimension(1000, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create styles
        Style style = new Style();

        // Create panels
        JPanel StockAndGetProduct = new JPanel();
        StockAndGetProduct.setLayout(new GridLayout(1, 2));

        JPanel RightSide = new JPanel();
        RightSide.setLayout(new GridLayout(3, 1));

        JPanel VisualAndRightSide = new JPanel();
        VisualAndRightSide.setLayout(new GridLayout(1, 2));

        JPanel AddOrder = new JPanel();
        AddOrder.setLayout(new GridLayout(1, 4));

        JPanel FullScreen = new JPanel();
        FullScreen.setLayout(new BorderLayout());

        // Create buttons
        JButton jbAddOrder = new JButton("Bestelling toevoegen");

        // Create labels
        JLabel jlEmpty = new JLabel();
        JLabel jlEmpty2 = new JLabel();
        JLabel jlEmpty3 = new JLabel();

        // Specifieke volgorde voor het toevoegen
        AddOrder.add(jbAddOrder);
        AddOrder.add(jlEmpty);
        AddOrder.add(jlEmpty2);
        AddOrder.add(jlEmpty3);
        FullScreen.add(AddOrder, BorderLayout.PAGE_START);

        VisualStockPanel visualStock = new VisualStockPanel();
        VisualAndRightSide.add(visualStock.getVisualStock());

        StockPanel stock = new StockPanel();
        StockAndGetProduct.add(stock.getStock());

        GetOrderPanel getProduct = new GetOrderPanel();
        StockAndGetProduct.add(getProduct.getProduct());

        RightSide.add(StockAndGetProduct);

        OrderInfoPanel orderInfo = new OrderInfoPanel();
        RightSide.add(orderInfo.getOrderInfo());

        PackingListPanel packingList = new PackingListPanel();
        RightSide.add(packingList.getPackingList());

        VisualAndRightSide.add(RightSide);

        FullScreen.add(VisualAndRightSide, BorderLayout.CENTER);
        add(FullScreen);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
