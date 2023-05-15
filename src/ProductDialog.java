import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ProductDialog extends JFrame implements ListSelectionListener, ActionListener {

    private JDialog jdProducts = new JDialog();
    private JPanel panel = new JPanel();
    private String[] test = {"Product 1", "Product 2", "Product 3", "Product 4"
            , "Product 5", "Product 6", "Product 7", "Product 8", "Product 9"};
    private String[] products;
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();


    DefaultListModel model = new DefaultListModel();

    private JList productList = new JList(test);
    private JList copyProductList = new JList(model);

    public ProductDialog(){

        jButton1.setText("Select");
        jButton2.setText("Finish");

        panel.add(productList);
        panel.add(jButton1);
        panel.add(jButton2);
        panel.add(copyProductList);
        jdProducts.add(panel);

        jButton1.addActionListener(this);
        jButton2.addActionListener(this);

        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jdProducts.setLayout(new FlowLayout());

        jdProducts.setSize(330,200);
        jdProducts.setVisible(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton1) {
            System.out.println(productList.getSelectedValue());

            model.addElement(productList.getSelectedValue());
        }
        if(e.getSource() == jButton2){
            jdProducts.setVisible(false);
        }
    }
    public void exist(){
        jdProducts.setVisible(true);
    }
}
