import javax.swing.*;
import java.awt.*;

public class Kastpanel extends JPanel {
    int test = 0;
public Kastpanel(){
    setBackground(Color.white);
}
 private double map(long x, long in_min, long in_max, double out_max, long out_min){
    return ((x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min);
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
        g2.setStroke(new BasicStroke(2));
        String robotCooridnates = getRobotCoordinates();
        String[] parts = robotCooridnates.split(",");
        int xPositionRobot = Integer.valueOf(parts[0]);
        int yPositionRobot = Integer.valueOf(parts[1]);
        int robotx = Integer.valueOf((int) ((55 * map(getWidth(), 492, 960, 1.30, 1)) + (xPositionRobot * (map(getWidth(), 492, 960, 2.15, 1) * 75))));
        if (test > 500) {
            System.out.println(parts[0]);
            System.out.println(parts[1]);
            System.out.println(xPositionRobot);
            System.out.println(yPositionRobot);
            test = 0;
        } else {
                test++;}
        for (int h = 0; h < 5; h++) {
            for (int i = 0; i < 5; i++) {
                int positiony = h + 1;
                int positionx = i + 1;



                g2.setColor(Database_querys.getcolorfromdatabase(positionx, positiony));
                g2.fillRect(Integer.valueOf((int) ((47 * map(getWidth(), 492, 960, 1.30, 1)) + (i * (map(getWidth(), 492, 960, 2.15, 1) * 75)))), Integer.valueOf((int) ((60 * map(getHeight(), 435, 983, 1.30, 1)) + (h * (map(getHeight(), 435, 983, 2.6, 1) * 67.5)))), (getWidth() / 44) * 5, (getHeight() / 40) *5);

                // if(h == 4 && i == 4) {
                //     g2.setColor(Color.orange);
                //     g2.setStroke(new BasicStroke(5));
                //     g2.drawLine(Integer.valueOf((int) ((70 * map(getWidth(), 492, 960, 1.30, 1)) + (5 * (map(getWidth(), 492, 960, 2.15, 1) * 75)))), Integer.valueOf((int) ((85 * map(getHeight(), 435, 983, 1.3448, 1)) + (4 * (map(getHeight(), 435, 983, 2.6, 1) * 67.5)))), Integer.valueOf((int) ((70 * map(getWidth(), 492, 960, 1.30, 1)) + (2 * (map(getWidth(), 492, 960, 2.15, 1) * 75)))), Integer.valueOf((int) ((85 * map(getHeight(), 435, 983, 1.3448, 1)) + (4 * (map(getHeight(), 435, 983, 2.6, 1) * 67.5)))));
                //     g2.setStroke(new BasicStroke(2));
                // }
                if(h == 4 && i == 4){
                g2.setColor(Color.darkGray);
                g2.fillRect(robotx, Integer.valueOf((int) ((65 * map(getHeight(), 435, 983, 1.30, 1)) + (yPositionRobot * (map(getHeight(), 435, 983, 2.6, 1) * 67.5)))), (getWidth() / 59) * 5, (getHeight() / 50) *5);
                    g2.setColor(Color.gray);
                    g2.fillOval(Integer.valueOf((int) ((57 * map(getWidth(), 492, 960, 1.3526, 1)) + (xPositionRobot * (map(getWidth(), 492, 960, 2.15, 1) * 75)))), Integer.valueOf((int) ((67.5 * map(getHeight(), 435, 983, 1.3448, 1)) + (yPositionRobot * (map(getHeight(), 435, 983, 2.6, 1) * 67.5)))), (getWidth() / 69) * 5, (getHeight() / 60) *5);
                }




                g2.setColor(Color.black);
                g2.drawRect(Integer.valueOf((int) ((47 * map(getWidth(), 492, 960, 1.30, 1)) + (i * (map(getWidth(), 492, 960, 2.15, 1) * 75)))), Integer.valueOf((int) ((60 * map(getHeight(), 435, 983, 1.30, 1)) + (h * (map(getHeight(), 435, 983, 2.6, 1) * 67.5)))), (getWidth() / 44) * 5, (getHeight() / 40) *5);

            }
        }
        repaint();
    }
    private String getRobotCoordinates(){
    String returnString = GetRobotGridPosition.getGridPosition();
    return returnString;
    }
}
