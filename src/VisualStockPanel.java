import javax.swing.*;

public class VisualStockPanel extends JFrame {
    JPanel jpVisual = new Kastpanel();

    public JPanel getVisualStock() {
        Style border = new Style();
        jpVisual.setBorder(BorderFactory.createTitledBorder(border.getBorder(), "Visuele kast"));
        return jpVisual;
    }
}
