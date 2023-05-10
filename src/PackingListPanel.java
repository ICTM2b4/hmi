import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PackingListPanel extends JFrame implements ActionListener {
    JPanel PackingList = new JPanel();
    JPanel PackingListBottom = new JPanel();


    JButton jbPrintOrder = new JButton("Print");

    JLabel jlPackingInfo = new JLabel();

    JLabel jlEmpty6 = new JLabel();
    JLabel jlEmpty7 = new JLabel();
    JLabel jlEmpty8 = new JLabel();

    String[] packingListColumnNames = {"Producten", "Aantal"};
    Object[][] packingList = {
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"},
            {"Product", "Aantal"}
    };
    JTable jtPackingList = new JTable(packingList, packingListColumnNames);
    JScrollPane jsPackingList = new JScrollPane(jtPackingList);

    public JPanel getPackingList() {
        Style style = new Style();

        PackingList.setLayout(new BorderLayout());
        PackingList.setBorder(BorderFactory.createTitledBorder(style.getBorder(), "Pakbon"));

        PackingListBottom.setLayout(new GridLayout(1,4));

        jlPackingInfo.setVerticalAlignment(JLabel.TOP);

        jtPackingList.setFont(style.getFont());

        PackingList.add(jsPackingList, BorderLayout.CENTER);

        PackingListBottom.add(jlEmpty6);
        PackingListBottom.add(jlEmpty7);
        PackingListBottom.add(jlEmpty8);
        PackingListBottom.add(jbPrintOrder);
        jbPrintOrder.addActionListener(this);

        PackingList.add(PackingListBottom, BorderLayout.PAGE_END);

        return PackingList;
    }
 @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Print")) {
            System.out.println("Print");

            GeneratePDF.generatePDF();
        }}
}
