import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockEdit extends JDialog implements ActionListener {
    private JTextField jtProductid = new JTextField();
    private JTextField jtXRow = new JTextField();
    private JTextField jtYRow = new JTextField();
public StockEdit(JFrame frame){
    super(frame, true);
    JPanel panel = new JPanel();
    JLabel jlProductid = new JLabel();
    JLabel jlXRow = new JLabel();
    JLabel jlYRow = new JLabel();
    JButton jbSaveToDatabase = new JButton();
    JButton jbCancel = new JButton();

    jlProductid.setText("Product ID");
    jlXRow.setText("X Row");
    jlYRow.setText("Y Row");
    jbSaveToDatabase.setText("Save to database");
    jbCancel.setText("Cancel");

    panel.setLayout(null);

    jlProductid.setBounds(10, 10, 100, 25);
    jlXRow.setBounds(10, 40, 100, 25);
    jlYRow.setBounds(10, 70, 100, 25);
    jbSaveToDatabase.setBounds(10, 100, 150, 25);
    jbCancel.setBounds(10, 130, 150, 25);

    jtProductid.setBounds(120, 10, 150, 25);
    jtXRow.setBounds(120, 40, 150, 25);
    jtYRow.setBounds(120, 70, 150, 25);

    panel.add(jlProductid);
    panel.add(jlXRow);
    panel.add(jlYRow);
    panel.add(jbSaveToDatabase);
    panel.add(jbCancel);
    panel.add(jtProductid);
    panel.add(jtXRow);
    panel.add(jtYRow);

    jbSaveToDatabase.addActionListener(this);
    jbCancel.addActionListener(this);

    add(panel);
    setTitle("Edit stock");
    setSize(300, 200);
    setLocationRelativeTo(null);
    setVisible(true);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Save to database")) {

            database_querrys.updatestorage(Integer.parseInt(jtProductid.getText()), Integer.parseInt(jtXRow.getText()), Integer.parseInt(jtYRow.getText()));



        }
        if (e.getActionCommand().equals("Cancel")){

        }

        dispose();
    }
}