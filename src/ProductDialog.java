import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ProductDialog extends JDialog implements ActionListener {

    private JPanel panelGrid = new JPanel(new GridLayout(0, 3));
    private JPanel panelBox = new JPanel();
    private String[] test = {"Product 1", "Product 2", "Product 3", "Product 4"
            , "Product 5", "Product 6", "Product 7", "Product 8", "Product 9"};
    private JButton selectButton = new JButton();
    private JButton finishButton = new JButton();
    private JButton removeButton = new JButton();


    DefaultListModel model = new DefaultListModel();

    private JList productList = new JList(test);
    private JList copyProductList = new JList(model);

    public ProductDialog(ToevoegDialog frame){
        super(frame, true);
        selectButton.setText("Select");
        finishButton.setText("Finish");
        removeButton.setText("Remove");

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

        panelGrid.add(productList);
        panelGrid.add(panelBox);
        panelGrid.add(copyProductList);

        add(panelGrid);

        selectButton.addActionListener(this);
        finishButton.addActionListener(this);
        removeButton.addActionListener(this);

        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        copyProductList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        setSize(420,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == selectButton) {
            System.out.println(productList.getSelectedValue());

            model.addElement(productList.getSelectedValue());
        }
        if(e.getSource() == finishButton){
            setVisible(false);
        }
        if (e.getSource() == removeButton){
            model.remove(copyProductList.getSelectedIndex());
        }
    }
    public void exist(){
        setVisible(true);
    }
}