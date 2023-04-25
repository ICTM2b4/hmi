import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Screen extends JFrame {
    private JButton jbAddOrder;
    private JButton jbRefresh;
    private JButton jbGetProduct;
    private JButton jbChangeProduct;
    private JButton jbGetOrder;
    private JButton jbPrintOrder;

    private JLabel jlEmpty;
    private JLabel jlEmpty2;
    private JLabel jlEmpty3;
    private JLabel jlVisual;
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
    private String[] stocklist = {"Product: " + "aantal", "Product: " + "aantal", "Product: " + "aantal", "Product: " + "aantal", "Product: " + "aantal", "Product: " + "aantal", "Product: " + "aantal", "Product: " + "aantal", "Product: " + "aantal", "Product: " + "aantal", "Product: " + "aantal"};

    public Screen() {
        setTitle("HMI");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create borders
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Border padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border border = BorderFactory.createCompoundBorder(blackline, padding);
        Border border1 = BorderFactory.createCompoundBorder(padding, border);

        //Create panels
        JPanel StockAndGetProduct = new JPanel(); //Voorraad + Product ophalen
        StockAndGetProduct.setLayout(new GridLayout(1, 2));

        JPanel RightSide = new JPanel(); //Rechterkant
        RightSide.setLayout(new GridLayout(3, 1));

        JPanel VisualAndRightSide = new JPanel(); //Visuele kast + rechterkant
        VisualAndRightSide.setLayout(new GridLayout(1, 2));

        JPanel AddOrder = new JPanel(); //Bestelling toevoegen
        AddOrder.setLayout(new GridLayout(1, 4));

        JPanel FullScreen = new JPanel(); //Alles
        FullScreen.setLayout(new BorderLayout());

        JPanel GetProduct = new JPanel(); //Product ophalen
        GetProduct.setLayout(new GridLayout(3, 1));
        GetProduct.setBorder(BorderFactory.createTitledBorder(border1, "Product Ophalen"));

        JPanel RefreshAndGetProduct = new JPanel(); //Refresh + ophalen
        RefreshAndGetProduct.setLayout(new GridLayout(1,1));

        JPanel OrderNumberAndText = new JPanel(); //Ordernummer + tekstvak
        OrderNumberAndText.setLayout(new GridLayout(1,2));

        JPanel Stock = new JPanel();
        Stock.setBorder(BorderFactory.createTitledBorder(border1, "Voorraad"));

        //Create buttons
        jbAddOrder = new JButton("Bestelling toevoegen");

        jbRefresh = new JButton("Refresh");

        jbGetProduct = new JButton("Ophalen");

        jbChangeProduct = new JButton("Wijzigen");

        jbGetOrder = new JButton("Verwerken");

        jbPrintOrder = new JButton("Print");

        //Create labels
        jlEmpty = new JLabel();
        jlEmpty2 = new JLabel();
        jlEmpty3 = new JLabel();

        jlVisual = new JLabel();
        jlVisual.setVerticalAlignment(JLabel.TOP);
        jlVisual.setBorder(BorderFactory.createTitledBorder(border1, "Visuele kast"));

        jlStock = new JLabel();
        jlStock.setVerticalAlignment(JLabel.TOP);

        jlGetProduct = new JLabel();
        jlGetProduct.setVerticalAlignment(JLabel.TOP);

        jlOrderInfo = new JLabel();
        jlOrderInfo.setVerticalAlignment(JLabel.TOP);
        jlOrderInfo.setBorder(BorderFactory.createTitledBorder(border1, "Order info"));

        jlStockInfo = new JLabel();
        jlStockInfo.setVerticalAlignment(JLabel.TOP);
        jlStockInfo.setBorder(BorderFactory.createTitledBorder(border1, "Pakbon"));

        jlOrderNumber = new JLabel("Ordernummer:");
        jlOrderInfo.setHorizontalAlignment(JLabel.LEFT);

        jlStockList = new JList(stocklist);

        //Create the rest

        jtOrderNumber = new JTextField();

        jcRecentOrders = new JComboBox(recentOrders);

        jsStock = new JScrollPane(jlStockList);



        //Specifieke volgorde voor het toevoegen
        AddOrder.add(jbAddOrder);
        AddOrder.add(jlEmpty);
        AddOrder.add(jlEmpty2);
        AddOrder.add(jlEmpty3);
        FullScreen.add(AddOrder, BorderLayout.PAGE_START);

        VisualAndRightSide.add(jlVisual);

        Stock.add(jsStock);
        StockAndGetProduct.add(Stock);

        OrderNumberAndText.add(jlOrderNumber);
        OrderNumberAndText.add(jtOrderNumber);

        GetProduct.add(OrderNumberAndText);

        GetProduct.add(jcRecentOrders);

        RefreshAndGetProduct.add(jbRefresh);
        RefreshAndGetProduct.add(jbGetProduct);
        GetProduct.add(RefreshAndGetProduct);
        StockAndGetProduct.add(GetProduct);

        RightSide.add(StockAndGetProduct);
        RightSide.add(jlOrderInfo);
        RightSide.add(jlStockInfo);

        VisualAndRightSide.add(RightSide);

        FullScreen.add(VisualAndRightSide, BorderLayout.CENTER);

        add(FullScreen);

        setVisible(true);
    }
}
