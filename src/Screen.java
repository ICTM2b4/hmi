import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Screen extends JFrame {
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
        JButton jbAddOrder = new JButton("Bestelling toevoegen");

        JButton jbRefresh = new JButton("Refresh");

        JButton jbGetProduct = new JButton("Ophalen");

        JButton jbChangeProduct = new JButton("Wijzigen");

        JButton jbGetOrder = new JButton("Verwerken");

        JButton jbPrintOrder = new JButton("Print");

        //Create labels
        JLabel jlEmpty = new JLabel();
        JLabel jlEmpty2 = new JLabel();
        JLabel jlEmpty3 = new JLabel();
        JLabel jlEmpty4 = new JLabel();
        JLabel jlEmpty5 = new JLabel();
        JLabel jlEmpty6 = new JLabel();
        JLabel jlEmpty7 = new JLabel();
        JLabel jlEmpty8 = new JLabel();

        JLabel jlVisual = new JLabel();
        jlVisual.setVerticalAlignment(JLabel.TOP);
        jlVisual.setBorder(BorderFactory.createTitledBorder(border1, "Visuele kast"));

        JLabel jlStock = new JLabel();
        jlStock.setVerticalAlignment(JLabel.TOP);

        JLabel jlGetProduct = new JLabel();
        jlGetProduct.setVerticalAlignment(JLabel.TOP);

        JLabel jlOrderInfo = new JLabel();
        jlOrderInfo.setVerticalAlignment(JLabel.TOP);

        JLabel jlPackingInfo = new JLabel();
        jlPackingInfo.setVerticalAlignment(JLabel.TOP);

        JLabel jlOrderNumber = new JLabel("Ordernummer:");
        jlOrderInfo.setHorizontalAlignment(JLabel.LEFT);

        String[] orderInfoList = {"Product", "Product", "Product", "Product", "Product", "Product", "Product", "Product", "Product"};
        JList<String> jlOrderInfoList = new JList<>(orderInfoList);

        JLabel jlName = new JLabel("Naam: ");
        JLabel jlAddress = new JLabel("Adres: ");
        JLabel jlEmail = new JLabel("E-mail: ");
        JLabel jlPhoneNumber = new JLabel("Telefoon: ");

        JLabel jlCustomerName = new JLabel("Piet");
        JLabel jlCustomerAddress = new JLabel("Campus 5, Zwolle");
        JLabel jlCustomerEmail = new JLabel("piet@gmail.com");
        JLabel jlCustomerPhoneNumber = new JLabel("112");

        JLabel jlProducts = new JLabel("Producten: ");

        //Create the rest

        JTextField jtOrderNumber = new JTextField();

        String[] recentOrders = {};
        JComboBox<String> jcRecentOrders = new JComboBox<>(recentOrders);

        String[] stocklistColumnNames = {"Producten", "Aantal"};
        Object[][] stocklist = {
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
        JTable jtStockList = new JTable(stocklist, stocklistColumnNames);
        jtStockList.setFont(boldFont);

        JScrollPane jsStock = new JScrollPane(jtStockList);

        JScrollPane jsOrderInfo = new JScrollPane(jlOrderInfoList);

        String[] packingListColumnNames = {"Producten", "Aantal"};
        Object[][] packingList = {
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
        JTable jtPackingList = new JTable(packingList, packingListColumnNames);
        jtPackingList.setFont(boldFont);

        JScrollPane jsPackingList = new JScrollPane(jtPackingList);


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
