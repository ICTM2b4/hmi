import javax.swing.*;
import java.awt.*;

public class StockPanel extends JFrame {
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

    public JPanel getStock() {
        Style style = new Style();

        JPanel Stock = new JPanel();
        Stock.setLayout(new GridLayout(1,1));
        Stock.setBorder(BorderFactory.createTitledBorder(style.getBorder(), "Voorraad"));

        JLabel jlStock = new JLabel();
        jlStock.setVerticalAlignment(JLabel.TOP);

        JTable jtStockList = new JTable(stocklist, stocklistColumnNames);
        jtStockList.setFont(style.getFont());

        JScrollPane jsStock = new JScrollPane(jtStockList);

        Stock.add(jsStock);

        return Stock;
    }
}
