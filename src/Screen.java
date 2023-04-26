import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {

    public Screen() {
        setTitle("HMI");
        setSize(1000, 500);
        setMinimumSize(new Dimension(1000, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create styles
        Style style = new Style();

        //Create panels
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

        //Create buttons
        JButton jbAddOrder = new JButton("Bestelling toevoegen");

        //Create labels
        JLabel jlEmpty = new JLabel();
        JLabel jlEmpty2 = new JLabel();
        JLabel jlEmpty3 = new JLabel();

        JLabel jlVisual = new JLabel();
        jlVisual.setVerticalAlignment(JLabel.TOP);
        jlVisual.setBorder(BorderFactory.createTitledBorder(style.getBorder(), "Visuele kast"));

        //Specifieke volgorde voor het toevoegen
        AddOrder.add(jbAddOrder);
        AddOrder.add(jlEmpty);
        AddOrder.add(jlEmpty2);
        AddOrder.add(jlEmpty3);
        FullScreen.add(AddOrder, BorderLayout.PAGE_START);

        VisualStock visualStock = new VisualStock();
        VisualAndRightSide.add(visualStock.getVisualStock());

        Stock stock = new Stock();
        StockAndGetProduct.add(stock.getStock());

        GetProduct getProduct = new GetProduct();
        StockAndGetProduct.add(getProduct.getProduct());

        RightSide.add(StockAndGetProduct);

        OrderInfo orderInfo = new OrderInfo();
        RightSide.add(orderInfo.getOrderInfo());

        PackingList packingList = new PackingList();
        RightSide.add(packingList.getPackingList());

        VisualAndRightSide.add(RightSide);

        FullScreen.add(VisualAndRightSide, BorderLayout.CENTER);

        add(FullScreen);

        setVisible(true);
    }
}
