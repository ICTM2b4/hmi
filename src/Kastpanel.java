import javax.swing.*;
import java.awt.*;

public class Kastpanel extends JPanel {
public Kastpanel(){
    setBackground(Color.white);

}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        for (int i = 0; i < 6; i++) {
            g2.drawLine(35,((((getHeight()-100)/5)*i)+50),((((getWidth() -70)/11)*10)+35),((((getHeight()-100)/5)*i)+50));
        }
        for (int i = 0; i < 6; i++) {
            g2.drawLine(((((getWidth() -70)/11)*(i*2))+35),50,((((getWidth() -70)/11)*(i*2))+35),((((getHeight()-100)/5)*5)+50));
        }

    }
}
