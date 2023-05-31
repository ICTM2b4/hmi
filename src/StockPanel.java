import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class StockPanel extends JFrame {
    String[] stocklistColumnNames = {"Producten", "Aantal"};
    Object[][] stocklist = {
            {getStockName(1), getStockTotal(1)},
            {getStockName(2), getStockTotal(2)},
            {getStockName(3), getStockTotal(3)},
            {getStockName(4), getStockTotal(4)},

    };
    public void reload(){
        stocklist = new Object[][]{
                {getStockName(1), getStockTotal(1)},
                {getStockName(2), getStockTotal(2)},
                {getStockName(3), getStockTotal(3)},
                {getStockName(4), getStockTotal(4)},
        };
    }

    public JPanel getStock()  {
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

    private int getStockTotal(int id) {
        try {
            Statement statement = Database.connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT COUNT(product_id)  FROM `product_stocks` WHERE product_id =" + id + ";");
            while (result.next()) {
                System.out.println(result.getInt(1));
                return result.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
        return 0;
    }
    private String getStockName(int id) {
        try {
            Statement statement = Database.connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT name FROM `products` WHERE id =" + id + ";");
            while (result.next()) {
                System.out.println(result.getString(1));
                return result.getString(1);
            }
        } catch (Exception e) {
            System.out.println(e);
            return "Product";
        }
        return "Product";
    }

}
