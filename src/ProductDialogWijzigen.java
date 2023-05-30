import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ProductDialogWijzigen extends JDialog implements ActionListener {

    private JPanel panelGrid = new JPanel(new GridLayout(0, 3));
    private JPanel panelBox = new JPanel();
    private String[] test = {"Product 1", "Product 2", "Product 3", "Product 4"
            , "Product 5", "Product 6", "Product 7", "Product 8", "Product 9"};
    private JButton selectButton = new JButton();
    private JButton finishButton = new JButton();
    private JButton removeButton = new JButton();
    private JLabel errorLabel = new JLabel();


    DefaultListModel model = new DefaultListModel();
    DefaultListModel products = new DefaultListModel();

    private JList productList = new JList(products);
    private JList copyProductList = new JList(model);

    public ProductDialogWijzigen(WijzigDialog frame) {
        super(frame, true);
        selectButton.setText("Select");
        finishButton.setText("Finish");
        removeButton.setText("Remove");
        getProductsFromDatabase();

        panelBox.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelBox.add(selectButton, gbc);

        gbc.gridy = 1;
        panelBox.add(removeButton, gbc);

        gbc.gridy = 2;
        panelBox.add(finishButton, gbc);

        gbc.gridy = 3;
        panelBox.add(errorLabel, gbc);

        panelGrid.add(productList);
        panelGrid.add(panelBox);
        panelGrid.add(copyProductList);

        add(panelGrid);

        selectButton.addActionListener(this);
        finishButton.addActionListener(this);
        removeButton.addActionListener(this);


        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ArrayList<Product> productsdatabase = getProductsFromDatabase();
        for (Product product : productsdatabase) {
            if (product.getId() != 0) {
                products.addElement(product.getName());
            }
        }
        copyProductList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ArrayList<Product> products = Order.selectOrder.getProducts();
        for (Product product : products) {
            model.addElement(product.getAmount() + ": " + product.getName());
        }

        //Voeg al geselecteerde producten hier toe

        setSize(420, 200);
        setVisible(true);
    }

    private ArrayList<Product> getProductsFromDatabase() {
        return (database_querrys.getProductsFromDatabasesql());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectButton) {
            try {
                System.out.println(productList.getSelectedValue());
                boolean done = true;
                while (done) {
                    for (int i = 0; i < model.getSize(); i++) {
                        String product = String.valueOf(model.elementAt(i));
                        if (product.contains(productList.getSelectedValue().toString())) {
                            int new_amount = Character.getNumericValue(product.charAt(0));
                            if (new_amount == 1) {
                                int testtien = Character.getNumericValue(product.charAt(1));
                                if (testtien == 0) {
                                    errorLabel.setText("max 10 dezelfde producten");
                                    done = false;
                                } else {
                                    new_amount++;
                                    model.setElementAt(new_amount + ": " + productList.getSelectedValue().toString(), i);
                                    done = false;
                                }
                            } else {
                                new_amount++;
                                model.setElementAt(new_amount + ": " + productList.getSelectedValue().toString(), i);
                                done = false;
                            }
                        }
                    }
                    if (done) {
                        model.addElement("1: " + productList.getSelectedValue().toString());
                        done = false;
                    }
                }
            } catch (java.lang.NullPointerException a) {
                errorLabel.setText("selecteer product links");
            }
        }
        if (e.getSource() == finishButton) {
            setVisible(false);
        }

        if (e.getSource() == removeButton) {
            try {
                System.out.println(copyProductList.getSelectedValue());
                boolean done = true;
                while (done) {
                    String product = String.valueOf(model.elementAt(copyProductList.getSelectedIndex()));
                    String productname = product.split(": ")[1];
                    int new_amount = Character.getNumericValue(product.charAt(0));
                    if (new_amount == 1) {
                        int testtien = Character.getNumericValue(product.charAt(1));
                        if (testtien == 0) {
                            new_amount = 9;
                            model.setElementAt(new_amount + ": " + productname, copyProductList.getSelectedIndex());
                            done = false;
                        } else {
                            model.remove(copyProductList.getSelectedIndex());
                        }
                    } else {
                        new_amount--;
                        model.setElementAt(new_amount + ": " + productname, copyProductList.getSelectedIndex());
                        done = false;
                    }
                }


            } catch (java.lang.ArrayIndexOutOfBoundsException a) {
                errorLabel.setText("selecteer product rechts");
            }
        }

    }

    public DefaultListModel getmodel() {
        return model;
    }

    public void exist() {
        setVisible(true);
    }
}
