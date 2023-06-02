import java.util.TimerTask;

public class UpdateStock extends TimerTask {
    Screen screen;

    UpdateStock(Screen screen){
        this.screen = screen;
    }
    @Override
    public void run() {
        screen.updatingstock();
    }
}
