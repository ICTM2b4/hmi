import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame implements ActionListener {
    public Screen() {
        setTitle("HMI");
        setSize(1000, 500);
        setMinimumSize(new Dimension(1000, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        AddOrder.add(jlEmpty2);
        AddOrder.add(jlEmpty3);
        FullScreen.add(AddOrder, BorderLayout.PAGE_START);

        jbAddOrder.addActionListener(this);

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
        // commented out the next line to disable the com dialog
        new SelectComPortDialog(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Bestelling toevoegen")) {
            new CustomerSelectDialog(this);

        }


    }

}
