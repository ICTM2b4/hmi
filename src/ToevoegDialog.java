import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTransientConnectionException;
import java.sql.Statement;
import java.util.ArrayList;

public class ToevoegDialog extends JDialog implements ActionListener {

    private String voornaam;
    private String achternaam;
    private String adres;
    private String email;
    private String stad;
    private String postcode;
    private int orderNummer;
    private String phonenumber;
    private String prefix;

    private int customerId;

    private JDialog jdToevoegen;

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

    private JLabel jlAdres1 = new JLabel();
    private JLabel jlVoornaam1 = new JLabel();
    private JLabel jlAchternaam1 = new JLabel();
    private JLabel jlEmail1 = new JLabel();
    private JLabel jlStad1 = new JLabel();
    private JLabel jlPostcode1 = new JLabel();
    private JLabel jlPhonenumber1 = new JLabel();
    private JLabel jlPrefix1 = new JLabel();

    private JButton jbSaveToDatabase = new JButton();
    private JButton jbAddProducts = new JButton();
    private ProductDialog product;
    private boolean exist = false;

    public ToevoegDialog(CustomerSelectDialog frame, int customerId) {
        super(frame, true);
        JPanel panel = new JPanel();
        orderNummer = (database_querrys.getmaxorderid() + 1);
        Customer customer = new Customer(customerId);
        this.customerId = customerId;
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

        //Alle jl uit al bestaande orders halen

        jlVoornaam1.setText(customer.getFirstName());
        jlAchternaam1.setText(customer.getLastName());
        jlAdres1.setText(customer.getStreet_nummer());
        jlEmail1.setText(customer.getEmail());
        jlStad1.setText(customer.getStad());
        jlPostcode1.setText(customer.getPostalCode());
        jlPhonenumber1.setText(customer.getPhoneNumber());
        jlPrefix1.setText(customer.getPrefix());

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

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(jlAdres, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(jlAdres1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(jlVoornaam, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(jlVoornaam1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(jlPrefix, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(jlPrefix1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(jlAchternaam, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(jlAchternaam1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(jlStad, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        panel.add(jlStad1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(jlPostcode, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        panel.add(jlPostcode1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        panel.add(jlPhonenumber, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        panel.add(jlPhonenumber1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        panel.add(jlEmail, gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        panel.add(jlEmail1, gbc);

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
                product = new ProductDialog(this);
                exist = true;
            } else {
                product.exist();
            }
        }

        if (e.getSource() == jbSaveToDatabase) {
            boolean confirmed = true;
            voornaam = jlVoornaam1.getText();
            achternaam = jlAchternaam1.getText();
            adres = jlAdres1.getText();
            stad = jlStad1.getText();
            email = jlEmail1.getText();
            postcode = jlPostcode1.getText();
            prefix = jlPrefix1.getText();
            phonenumber = jlPhonenumber1.getText();
            int orderid = orderNummer;
            int klantid = customerId;
            System.out.println(klantid);
            //Functie om straatnaam en nummer te splitten
            //part[0] = straatnaam
            //part[1] = nummer
            String[] part = adres.split("(?<=\\D)(?=\\d)");
            try {
                database_querrys.update_customer(voornaam, prefix, achternaam, part[0], Integer.valueOf(part[1]), postcode, stad, phonenumber, email, klantid);

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
                database_querrys.create_new_order(customerId);
                DefaultListModel products = product.getmodel();
                Object[] productlist = products.toArray();
                ArrayList productlist_s = new ArrayList<String>();
                ArrayList<Integer> old_amounts = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    old_amounts.add(0);
                }
                try {
                    for (Object product : productlist
                    ) {
                        String product_s = product.toString();
                        String[] parts = product_s.split(": ");
                        int amount = Integer.valueOf(parts[0]);
                        String productname = parts[1];
                        Statement statement = Database.connection.createStatement();
                        ResultSet result2 = statement.executeQuery("select id from products where name = \"" + productname + "\";");
                        int product_id = 0;
                        while (result2.next()) {
                            product_id = result2.getInt("id");
                        }

                        database_querrys.insert_order(product_id, amount);
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
}


