import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
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


    public Screen() {
        setTitle("-");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create panels
        JPanel panel1 = new JPanel(); //Voorraad + Product ophalen
        panel1.setLayout(new GridLayout(1, 2));

        JPanel panel2 = new JPanel(); //Rechterkant
        panel2.setLayout(new GridLayout(3, 1));

        JPanel panel3 = new JPanel(); //Visuele kast + rechterkant
        panel3.setLayout(new GridLayout(1, 2));

        JPanel panel4 = new JPanel(); //Bestelling toevoegen
        panel4.setLayout(new GridLayout(1, 4));

        JPanel panel5 = new JPanel(); //Alles
        panel5.setLayout(new BorderLayout());

        JPanel panel6 = new JPanel(); //Product ophalen
        panel6.setLayout(new GridLayout(3, 1));

        JPanel panel7 = new JPanel(); //Refresh + ophalen
        panel7.setLayout(new GridLayout(1,2));

        JPanel panel8 = new JPanel(); //Ordernummer + tekstvak
        panel8.setLayout(new GridLayout(1,2));

        //Create borders
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Border empty = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border border = BorderFactory.createCompoundBorder(blackline, empty);
        Border border1 = BorderFactory.createCompoundBorder(empty, border);

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
