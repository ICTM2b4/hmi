import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToevoegDialog extends JFrame implements ActionListener {
    String[] products = {"Product1", "Product2", "Product3"};

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

    private JComboBox producten1 = new JComboBox(products);
    private JComboBox producten2 = new JComboBox(products);

    private JTextField jtAdres = new JTextField();
    private JTextField jtVoornaam = new JTextField();
    private JTextField jtAchternaam = new JTextField();
    private JTextField jtEmail = new JTextField();
    private JTextField jtStad = new JTextField();
    private JTextField jtPostcode = new JTextField();

    private JButton jButton = new JButton();
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
        jButton.setText("Toevoegen aan database");

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
        panel.add(jlBestelling, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(producten1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(producten2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
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
        jButton.addActionListener(this);
        panel.add(jButton, gbc);



        jdToevoegen.add(panel);
        jdToevoegen.setTitle("Test");
        jdToevoegen.setSize(250,350);
        jdToevoegen.setLocation(800,40);
        jdToevoegen.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jdToevoegen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Woop");
        jdToevoegen.dispose();
    }
}
