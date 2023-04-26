import javax.swing.*;

public class VisualStockPanel extends JFrame {
    JLabel jlVisual = new JLabel();

    public JLabel getVisualStock() {
        Style border = new Style();
        jlVisual.setVerticalAlignment(JLabel.TOP);
        jlVisual.setBorder(BorderFactory.createTitledBorder(border.getBorder(), "Visuele kast"));
        return jlVisual;
    }
}
