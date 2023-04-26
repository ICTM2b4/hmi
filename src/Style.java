import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class Style {
    Border blackline = BorderFactory.createLineBorder(Color.black);
    Border padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    Border border = BorderFactory.createCompoundBorder(blackline, padding);
    Border fullborder = BorderFactory.createCompoundBorder(padding, border);

    public Border getBorder() {
        return fullborder;
    }
    public Font getFont() {
        return new Font("Bold", Font.BOLD, 12);
    }
}