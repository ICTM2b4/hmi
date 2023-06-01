import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.*;

public class WijzigDialog extends JDialog implements ActionListener {

    private String voornaam;
    private String achternaam;
    private String adres;
    private String email;
    private String stad;
    private String postcode;
    private int orderNummer;
    private String phonenumber;
    private String prefix;

    private JLabel jlOrderNummerText = new JLabel();
    private JLabel jlOrderNummer = new JLabel();
    private JLabel jlBestelling = new JLabel();
    private JLabel jlAdres = new JLabel();
    private JLabel jlVoornaam = new JLabel();
    private JLabel jlAchternaam = new JLabel();
    private JLabel jlEmail = new JLabel();
    private JLabel jlStad = new JLabel();
    private JLabel jlPostcode = new JLabel();
    private JLabel jlPhonenumber = new JLabel();
    private JLabel jlPrefix = new JLabel();
    private JLabel jlOptioneel = new JLabel();

    private JTextField jtAdres = new JTextField();
    private JTextField jtVoornaam = new JTextField();
    private JTextField jtAchternaam = new JTextField();
    private JTextField jtEmail = new JTextField();
    private JTextField jtStad = new JTextField();
    private JTextField jtPostcode = new JTextField();
    private JTextField jtPhonenumber = new JTextField();
    private JTextField jtPrefix = new JTextField();

    private JButton jbSaveToDatabase = new JButton();
    private JButton jbAddProducts = new JButton();
    private ProductDialogWijzigen productWijzigen;
    private boolean exist = false;

    public WijzigDialog(JFrame frame) {
        super(frame, true);
        JPanel panel = new JPanel();

        orderNummer = Order.selectOrder.getOrderNumber();

        jlOrderNummerText.setText("Order nummer: ");
        jlOrderNummer.setText(String.valueOf(orderNummer));
        jlBestelling.setText("Bestelling ");
        jlAdres.setText("Adres ");
        jlVoornaam.setText("Voornaam ");
        jlAchternaam.setText("Achternaam: ");
        jlEmail.setText("E-mail ");
        jlStad.setText("Woonplaats ");
        jlPostcode.setText("Postcode ");
        jlPhonenumber.setText("Telefoonnummer* ");
        jlPrefix.setText("Tussenvoegsel* ");
        jlOptioneel.setText("*=Optioneel");

        //Alle jt uit al bestaande orders halen

        jtVoornaam.setText(Order.selectOrder.getCustomer().getFirstName());
        jtAchternaam.setText(Order.selectOrder.getCustomer().getLastName());
        jtAdres.setText(Order.selectOrder.getCustomer().getStreet_nummer());
        jtEmail.setText(Order.selectOrder.getCustomer().getEmail());
        jtStad.setText(Order.selectOrder.getCustomer().getStad());
        jtPostcode.setText(Order.selectOrder.getCustomer().getPostalCode());
        jtPhonenumber.setText(Order.selectOrder.getCustomer().getPhoneNumber());
        jtPrefix.setText(Order.selectOrder.getCustomer().getPrefix());

        jbSaveToDatabase.setText("Toevoegen aan database");
        jbAddProducts.setText("Voeg producten toe");

        GridBagLayout layout = new GridBagLayout();

        panel.setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(jlOrderNummerText, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(jlOrderNummer, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(jbAddProducts, gbc);

        jbAddProducts.addActionListener(this);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(jlOptioneel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(jlAdres, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(jtAdres, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(jlVoornaam, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(jtVoornaam, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(jlPrefix, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(jtPrefix, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(jlAchternaam, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(jtAchternaam, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(jlStad, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        panel.add(jtStad, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(jlPostcode, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        panel.add(jtPostcode, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        panel.add(jlPhonenumber, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        panel.add(jtPhonenumber, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        panel.add(jlEmail, gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        panel.add(jtEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        jbSaveToDatabase.addActionListener(this);
        panel.add(jbSaveToDatabase, gbc);


        add(panel);
        setTitle(String.valueOf(orderNummer));
        setSize(250, 300);
        setLocation(800, 40);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbAddProducts) {
            if (!exist) {
                productWijzigen = new ProductDialogWijzigen(this);
                exist = true;
            } else {
                productWijzigen.exist();
            }
        }

        if (e.getSource() == jbSaveToDatabase) {
            boolean confirmed = true;
            voornaam = jtVoornaam.getText();
            achternaam = jtAchternaam.getText();
            adres = jtAdres.getText();
            stad = jtStad.getText();
            email = jtEmail.getText();
            postcode = jtPostcode.getText();
            prefix = jtPrefix.getText();
            phonenumber = jtPhonenumber.getText();
            int orderid = orderNummer;
            int klantid = Order.selectOrder.getCustomer().getId();
            //Functie om straatnaam en nummer te splitten
            //part[0] = straatnaam
            //part[1] = nummer
            String[] part = adres.split("(?<=\\D)(?=\\d)");
            part[1].strip();
            part[0].strip();
            try {
                Database_querys.update_customer(voornaam, prefix, achternaam, part[0], Integer.valueOf(part[1]), postcode, stad, phonenumber, email, klantid);

            } catch (SQLTransientConnectionException c) {
                System.out.println(c); //catch not a valid postalcode
                Component frame = null;
                JOptionPane.showMessageDialog(frame, "Not a valid postalcode\n" +
                        "correct layout: 0000AA");
                confirmed = false;
            } catch (SQLException b) {
                System.out.println(b + "no");
                confirmed = false;
            }


            if (exist) {
                DefaultListModel products = productWijzigen.getmodel();
                Object[] productlist = products.toArray();
                ArrayList productlist_s = new ArrayList<String>();
                ArrayList<Integer> old_amounts = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    old_amounts.add(0);
                }
                try {
                    Statement statement = Database.connection.createStatement();
                    ResultSet result = statement.executeQuery("select product_id, amount from order_lines where order_number =" + orderid + ";");
                    while (result.next()) {
                        old_amounts.set(result.getInt("product_id"), result.getInt("amount"));
                    }
                    System.out.println(old_amounts);
                    ArrayList<Integer> productsdone = new ArrayList<>();
                    productsdone.add(1);
                    for (int i = 0; i < 4; i++) {
                        productsdone.add(0);
                    }
                    System.out.println(productsdone);
                    for (Object product : productlist
                    ) {
                        String product_s = product.toString();
                        String[] parts = product_s.split(": ");
                        int new_amount = Integer.valueOf(parts[0]);
                        String productname = parts[1];

                        ResultSet result2 = statement.executeQuery("select id from products where name = \"" + productname + "\";");
                        int product_id = 0;
                        while (result2.next()) {
                            product_id = result2.getInt("id");
                        }
                        if (old_amounts.get(product_id) != 0) {
                            Database_querys.update_order_oldproduct(product_id, new_amount, orderid);
                        } else {
                            Database_querys.update_order_newproduct(product_id, new_amount, orderid);
                        }
                        productsdone.set(product_id, 1);
                    }
                    for (int i = 0; i < productsdone.size(); i++) {
                        if (productsdone.get(i) == 0) {
                            Database_querys.update_order_oldproductdelete(i, orderid);
                            System.out.println(i);
                            System.out.println(orderid);
                        }
                    }


                } catch (SQLException a) {
                    System.err.println("Failed to execute the query.");
                    a.printStackTrace();
                    confirmed = false;
                }
            }


            if (confirmed) {
                dispose();
            }
        }
    }

    public boolean check(String line) {
        return !line.equals("");
    }

}
