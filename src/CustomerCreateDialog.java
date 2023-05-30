import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLTransientConnectionException;

public class CustomerCreateDialog extends JDialog implements ActionListener {
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

    public CustomerCreateDialog(CustomerSelectDialog frame) {
        super(frame, true);
        JPanel panel = new JPanel();

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

        jtVoornaam.setText("");
        jtAchternaam.setText("");
        jtAdres.setText("");
        jtEmail.setText("");
        jtStad.setText("");
        jtPostcode.setText("");
        jtPhonenumber.setText("");
        jtPrefix.setText("");

        jbSaveToDatabase.setText("Toevoegen aan database");

        GridBagLayout layout = new GridBagLayout();

        panel.setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;

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
        setTitle("New Customer");
        setSize(250, 300);
        setLocation(800, 40);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        voornaam = jtVoornaam.getText().trim();
        achternaam = jtAchternaam.getText().trim();
        adres = jtAdres.getText().trim();
        stad = jtStad.getText().trim();
        email = jtEmail.getText().trim();
        postcode = jtPostcode.getText().trim();
        prefix = jtPrefix.getText().trim();
        phonenumber = jtPhonenumber.getText().trim();
        int spacesamount = 0;
        boolean spaces = false;
        for (Character c : adres.toCharArray()) {

            if (c == ' ') {
                spacesamount++;
            }
            if (spacesamount == 1) {
                spaces = true;
            } else {
                spaces = false;
            }
        }
        if (spaces) {
            //Functie om straatnaam en nummer te splitten
            //part[0] = straatnaam
            //part[1] = nummer
            String[] part = adres.split("(?<=\\D)(?=\\d)");

            database_querrys.insert_customer(voornaam, achternaam, part[0], Integer.valueOf(part[1]), postcode, stad, email, prefix, phonenumber);
            dispose();
        } else {
//            error voer geldig adres in layout "naam nummer"
            System.out.println("error" + adres);
        }
    }
}
