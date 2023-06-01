import java.util.TimerTask;

public class GetRobotGridPosition extends TimerTask {

    private static String gridPosition = "5,4";

    public static String getGridPosition() {
        return gridPosition;
    }

    @Override
    public void run() {
        Serial.writeData("getGridPosition");
        gridPosition = Serial.readData();
        System.out.println(gridPosition);
    }
}
