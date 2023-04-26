public class App {
    public static void main(String[] args) throws Exception {
        // test code, can be removed
        Database.open();
        Order order1 = new Order(1);
        System.out.println(order1);
        Database.close();

        Serial.open(2);
        Serial.checkConnection();
        Serial.writeData("enableControlFromHMI");
        Thread.sleep(1000);
        Serial.writeData("X+");
        Thread.sleep(1000);
        Serial.writeData("X-");
        Thread.sleep(1000);
        Serial.writeData("X0");
        Thread.sleep(1000);
        Serial.writeData("Y+");
        Thread.sleep(1000);
        Serial.writeData("Y-");
        Thread.sleep(1000);
        Serial.writeData("Y0");
        Thread.sleep(1000);
        Serial.writeData("Z+");
        Thread.sleep(1000);
        Serial.writeData("Z-");
        Thread.sleep(1000);
        Serial.writeData("Z0");
        Thread.sleep(1000);
        Serial.writeData("disableControlFromHMI");
        Serial.close();

        Serial.checkConnection();
        Serial.refreshAvailablePorts();
    }
}
