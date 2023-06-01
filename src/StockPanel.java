import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

//public class StockPanel extends JFrame {
//    String[] stocklistColumnNames = {"Producten", "Aantal"};
//    Object[][] stocklist = {
//            {getStockName(1), getStockTotal(1)},
//            {getStockName(2), getStockTotal(2)},
//            {getStockName(3), getStockTotal(3)},
//            {getStockName(4), getStockTotal(4)},
//
//    };
    public class StockPanel extends JFrame implements ActionListener {
    JButton jbAddStock = new JButton("Stock wijzigen");

        String[] stocklistColumnNames = {"Producten", "Aantal"};
        Object[][] stocklistData = {
                {getStockName(1), getStockTotal(1)},
                {getStockName(2), getStockTotal(2)},
                {getStockName(3), getStockTotal(3)},
                {getStockName(4), getStockTotal(4)}
        };

        DefaultTableModel stocklistModel;

        public StockPanel() {
            // Create the DefaultTableModel with the data and column names


            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack();
            setVisible(true);
        }

        // Example method to get stock name based on index





//    public void reload(){
//        stocklist = new Object[][]{
//                {getStockName(1), getStockTotal(1)},
//                {getStockName(2), getStockTotal(2)},
//                {getStockName(3), getStockTotal(3)},
//                {getStockName(4), getStockTotal(4)},
//        };
//    }

    public JPanel getStock()  {
        Style style = new Style();

        JPanel Stock = new JPanel();
        Stock.setLayout(new BorderLayout());
        Stock.setBorder(BorderFactory.createTitledBorder(style.getBorder(), "Voorraad"));

//        JScrollPane jsStock = new JScrollPane(jtStockList);

        stocklistModel = new DefaultTableModel(stocklistData, stocklistColumnNames);

        // Create the JTable with the model
        JTable stockTable = new JTable(stocklistModel);

        // Add the table to a scroll pane and set it as the content pane of the frame
        JScrollPane jsStock = new JScrollPane(stockTable);
//        setContentPane(scrollPane);


        jbAddStock.addActionListener(this);
    jbAddStock.setMinimumSize(new Dimension(5, 5));


jsStock.setPreferredSize(new Dimension(400, 200));
        Stock.add(jsStock, BorderLayout.CENTER);

        Stock.add(jbAddStock, BorderLayout.PAGE_END);


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
    public void updateStock() {
        stocklistData = new Object[][]{
                {getStockName(1), getStockTotal(1)},
                {getStockName(2), getStockTotal(2)},
                {getStockName(3), getStockTotal(3)},
                {getStockName(4), getStockTotal(4)},
        };
        stocklistModel.setDataVector(stocklistData, stocklistColumnNames);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Stock wijzigen")) {
            new StockEdit(this);
            updateStock();
        }
    }
}
