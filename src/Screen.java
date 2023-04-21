import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class Screen extends JFrame {
    private JButton jbAddOrder;

    private JLabel jlEmpty;
    private JLabel jlEmpty2;
    private JLabel jlEmpty3;
    private JLabel jlVisual;
    private JLabel jlStock;
    private JLabel jlGetProduct;
    private JLabel jlStockInfo;
    private JLabel jlOrderInfo;


    public Screen() {
        setTitle("-");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create panels
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 2));
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 1));
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1, 2));
        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1, 4));
        JPanel panel5 = new JPanel();
        panel5.setLayout(new BorderLayout());

        //Create borders
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border border = BorderFactory.createCompoundBorder(blackline, padding);
        Border border1 = BorderFactory.createCompoundBorder(empty, border);

        //Create labels
        jbAddOrder = new JButton("Bestelling toevoegen");

        jlEmpty = new JLabel();
        jlEmpty2 = new JLabel();
        jlEmpty3 = new JLabel();

        jlVisual = new JLabel("Visuele kast");
        jlVisual.setVerticalAlignment(JLabel.TOP);
        jlVisual.setBorder(border1);

        jlStock = new JLabel("Voorraad");
        jlStock.setVerticalAlignment(JLabel.TOP);
        jlStock.setBorder(border1);

        jlGetProduct = new JLabel("Product ophalen");
        jlGetProduct.setVerticalAlignment(JLabel.TOP);
        jlGetProduct.setBorder(border1);


        jlOrderInfo = new JLabel("Order info");
        jlOrderInfo.setVerticalAlignment(JLabel.TOP);
        jlOrderInfo.setBorder(border1);

        jlStockInfo = new JLabel("Pakbon");
        jlStockInfo.setVerticalAlignment(JLabel.TOP);
        jlStockInfo.setBorder(border1);


        //Specifieke volgorde voor het toevoegen
        panel4.add(jbAddOrder);
        panel4.add(jlEmpty);
        panel4.add(jlEmpty2);
        panel4.add(jlEmpty3);
        panel5.add(panel4, BorderLayout.PAGE_START);
        panel3.add(jlVisual);
        panel1.add(jlStock);
        panel1.add(jlGetProduct);
        panel2.add(panel1);
        panel2.add(jlOrderInfo);
        panel2.add(jlStockInfo);
        panel3.add(panel2);
        panel5.add(panel3, BorderLayout.CENTER);
        add(panel5);

        setVisible(true);
    }
}
