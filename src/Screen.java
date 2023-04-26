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
    private JLabel jlEmpty4;
    private JLabel jlEmpty5;
    private JLabel jlEmpty6;
    private JLabel jlEmpty7;
    private JLabel jlEmpty8;
    private JLabel jlVisual;
    private JLabel jlStock;
    private JLabel jlGetProduct;
    private JLabel jlPackingInfo;
    private JLabel jlOrderInfo;
    private JLabel jlOrderNumber;
    private JLabel jlName;
    private JLabel jlAddress;
    private JLabel jlEmail;
    private JLabel jlPhoneNumber;
    private JLabel jlCustomerName;
    private JLabel jlCustomerAddress;
    private JLabel jlCustomerEmail;
    private JLabel jlCustomerPhoneNumber;
    private JLabel jlProducts;

    private JTextField jtOrderNumber;

    private String[] recentOrders = {};
    private JComboBox jcRecentOrders;

    private JTable jtStockList;
    private JScrollPane jsStock;
    private String[] stocklistColumnNames = {"Producten", "Aantal"};
    private Object[][] stocklist = {
            {"Product", "aantal"},
            {"Product", "aantal"},
            {"Product", "aantal"},
            {"Product", "aantal"},
            {"Product", "aantal"},
            {"Product", "aantal"},
            {"Product", "aantal"},
            {"Product", "aantal"},
            {"Product", "aantal"},
            {"Product", "aantal"}
    };
    private JList jlOrderInfoList;
    private JScrollPane jsOrderInfo;
    private String[] orderInfoList = {"Product", "Product", "Product", "Product", "Product", "Product", "Product", "Product", "Product"};

    private JTable jtPackingList;
    private JScrollPane jsPackingList;
    private String[] packingListColumnNames = {"Producten", "Aantal"};
    private Object[][] packingList = {
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"}
    };

    Font boldFont = new Font("Bold", Font.BOLD, 12);

    public Screen() {
        setTitle("HMI");
        setSize(1000, 500);
        setMinimumSize(new Dimension(1000, 500));
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
        Stock.setLayout(new GridLayout(1,1));
        Stock.setBorder(BorderFactory.createTitledBorder(border1, "Voorraad"));

        JPanel OrderInfo = new JPanel();
        OrderInfo.setLayout(new BorderLayout());
        OrderInfo.setBorder(BorderFactory.createTitledBorder(border1, "Order info"));

        JPanel OrderInfoMiddle = new JPanel();
        OrderInfoMiddle.setLayout(new GridLayout(1,4));

        JPanel CustomerInfo1 = new JPanel();
        CustomerInfo1.setLayout(new GridLayout(4,1));

        JPanel CustomerInfo2 = new JPanel();
        CustomerInfo2.setLayout(new GridLayout(4,1));

        JPanel OrderInfoProducts = new JPanel();
        OrderInfoProducts.setLayout(new GridLayout(4,1));

        JPanel OrderInfoButtons = new JPanel();
        OrderInfoButtons.setLayout(new GridLayout(1,4));

        JPanel PackingList = new JPanel();
        PackingList.setLayout(new BorderLayout());
        PackingList.setBorder(BorderFactory.createTitledBorder(border1, "Pakbon"));

        JPanel PackingListBottom = new JPanel();
        PackingListBottom.setLayout(new GridLayout(1,4));

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
        jlEmpty4 = new JLabel();
        jlEmpty5 = new JLabel();
        jlEmpty6 = new JLabel();
        jlEmpty7 = new JLabel();
        jlEmpty8 = new JLabel();

        jlVisual = new JLabel();
        jlVisual.setVerticalAlignment(JLabel.TOP);
        jlVisual.setBorder(BorderFactory.createTitledBorder(border1, "Visuele kast"));

        jlStock = new JLabel();
        jlStock.setVerticalAlignment(JLabel.TOP);

        jlGetProduct = new JLabel();
        jlGetProduct.setVerticalAlignment(JLabel.TOP);

        jlOrderInfo = new JLabel();
        jlOrderInfo.setVerticalAlignment(JLabel.TOP);

        jlPackingInfo = new JLabel();
        jlPackingInfo.setVerticalAlignment(JLabel.TOP);

        jlOrderNumber = new JLabel("Ordernummer:");
        jlOrderInfo.setHorizontalAlignment(JLabel.LEFT);

        jlOrderInfoList = new JList(orderInfoList);

        jlName = new JLabel("Naam: ");
        jlAddress = new JLabel("Adres: ");
        jlEmail = new JLabel("E-mail: ");
        jlPhoneNumber = new JLabel("Telefoon: ");

        jlCustomerName = new JLabel("Piet");
        jlCustomerAddress = new JLabel("Campus 5, Zwolle");
        jlCustomerEmail = new JLabel("piet@gmail.com");
        jlCustomerPhoneNumber = new JLabel("112");

        jlProducts = new JLabel("Producten: ");

        //Create the rest

        jtOrderNumber = new JTextField();

        jcRecentOrders = new JComboBox(recentOrders);

        jtStockList = new JTable(stocklist, stocklistColumnNames);
        jtStockList.setFont(boldFont);

        jsStock = new JScrollPane(jtStockList);

        jsOrderInfo = new JScrollPane(jlOrderInfoList);

        jtPackingList = new JTable(packingList, packingListColumnNames);
        jtPackingList.setFont(boldFont);

        jsPackingList = new JScrollPane(jtPackingList);


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

        RightSide.add(OrderInfo);

        PackingList.add(jsPackingList, BorderLayout.CENTER);

        PackingListBottom.add(jlEmpty6);
        PackingListBottom.add(jlEmpty7);
        PackingListBottom.add(jlEmpty8);
        PackingListBottom.add(jbPrintOrder);

        PackingList.add(PackingListBottom, BorderLayout.PAGE_END);
        RightSide.add(PackingList);

        VisualAndRightSide.add(RightSide);

        FullScreen.add(VisualAndRightSide, BorderLayout.CENTER);

        add(FullScreen);

        setVisible(true);
    }
}
