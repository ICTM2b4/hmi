import java.util.Timer;

public class App {
    public static void main(String[] args) throws Exception {
        Database.open();
        Screen screen = new Screen();
        Timer timer = new Timer();
        GetRobotGridPosition task = new GetRobotGridPosition();

        timer.scheduleAtFixedRate(task, 5000, 5000);
    }
}