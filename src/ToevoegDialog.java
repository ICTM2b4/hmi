import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToevoegDialog extends JFrame implements ActionListener {

    private String voornaam;
    private String achternaam;
    private String adres;
    private String email;
    private String stad;
    private String postcode;

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

    private JTextField jtAdres = new JTextField();
    private JTextField jtVoornaam = new JTextField();
    private JTextField jtAchternaam = new JTextField();
    private JTextField jtEmail = new JTextField();
    private JTextField jtStad = new JTextField();
    private JTextField jtPostcode = new JTextField();

    private JButton jbSaveToDatabase = new JButton();
    private JButton jbAddProducts = new JButton();

    private ProductDialog product;
    private boolean exist = false;

    public ToevoegDialog() {
        jdToevoegen = new JDialog();

        JPanel panel = new JPanel();

        jlOrderNummerText.setText("Order nummer: ");
        jlOrderNummer.setText("Test");
        jlBestelling.setText("Bestelling ");
        jlAdres.setText("Adres ");
        jlVoornaam.setText("Voornaam ");
        jlAchternaam.setText("Achternaam: ");
        jlEmail.setText("E-mail ");
        jlStad.setText("Woonplaats ");
        jlPostcode.setText("Postcode ");

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

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(jlAdres, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(jtAdres, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(jlVoornaam, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(jtVoornaam, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(jlAchternaam, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(jtAchternaam, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(jlStad, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(jtStad, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(jlPostcode, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(jtPostcode, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(jlEmail, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        panel.add(jtEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        jbSaveToDatabase.addActionListener(this);
        panel.add(jbSaveToDatabase, gbc);



        jdToevoegen.add(panel);
        jdToevoegen.setTitle("Test");
        jdToevoegen.setSize(250,300);
        jdToevoegen.setLocation(800,40);
        jdToevoegen.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jdToevoegen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jbAddProducts){
            if (!exist){
                product = new ProductDialog();
                exist = true;
            }else{
                product.exist();
            }
        }

        if(e.getSource() == jbSaveToDatabase) {
            voornaam = jtVoornaam.getText();
            achternaam = jtAchternaam.getText();
            adres = jtAdres.getText();
            stad = jtStad.getText();
            email = jtEmail.getText();
            postcode = jtPostcode.getText();

            //Functie om straatnaam en nummer te splitten
            //part[0] = straatnaam
            //part[1] = nummer
            String[] part = adres.split("(?<=\\D)(?=\\d)");


            if (check(voornaam) && check(achternaam) && check(adres) && check(stad) && check(email) && check(postcode)) {
                jdToevoegen.dispose();
            }
        }
    }

    public boolean check(String line){
        return !line.equals("");
    }
}
