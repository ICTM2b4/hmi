import com.fazecast.jSerialComm.SerialPort;
import java.lang.Thread;

public abstract class Serial {
    static private SerialPort[] availablePorts = SerialPort.getCommPorts();
    static public SerialPort connection;
    // connection settings
    static int BaudRate = 9600;
    static int DataBits = 8;
    static int StopBits = SerialPort.ONE_STOP_BIT;
    static int Parity = SerialPort.NO_PARITY;

    /**
     * this method will return all the available ports.
     * 
     * @return
     */
    static public SerialPort[] getAvailablePorts() {
        return availablePorts;
    }

    /**
     * this method will get all the available ports.
     */
    static public void refreshAvailablePorts() {
        // print out all available ports
        for (int i = 0; i < availablePorts.length; i++) {
            System.out.println("Port " + i + ": " + availablePorts[i].getSystemPortName());
        }
        availablePorts = SerialPort.getCommPorts();
    }

    /**
     * this method will open a serial connection on the given port.
     * 
     * @param portNumber
     * @throws InterruptedException
     */
    static public void open(int portNumber) throws InterruptedException {
        connection = availablePorts[portNumber];
        connection.setComPortParameters(BaudRate, DataBits, StopBits, Parity);
        connection.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 1000, 0);
        connection.openPort();
        // wait 2 seconds to give the arduino time to reset
        Thread.sleep(2000);
        System.out.println("serial connection opened on the " + connection.getSystemPortName() + " port");
    }

    /**
     * this method will close the serial connection.
     */
    static public void close() {
        connection.closePort();
    }

    /**
     * this method will check if there is a serial connection open.
     * 
     * @return
     */
    static public boolean checkConnection() {

        if (connection.isOpen()) {
            System.out.println("a serial conection is open on the " + connection.getSystemPortName() + " port");
            return true;
        }
        System.out.println("there is no serial conection open");
        return false;
    }

    /**
     * this method will convert a string to a array of bytes.
     * after the conversion it will send the bytes to the arduino.
     * 
     * @param data
     */
    static public void writeData(String data) {
        try {
            byte[] WriteByte = data.getBytes();
            int bytesTxed = 0;

            bytesTxed = connection.writeBytes(WriteByte, WriteByte.length);
            System.out.print(" Bytes Transmitted -> " + bytesTxed);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * this method will read a string from the serial connection.
     * TODO: make this method return a string, this method has not been tested yet.
     */
    static public void readData() {
        try {
            while (true) {

                byte[] readBuffer = new byte[100];

                int numRead = connection.readBytes(readBuffer,
                        readBuffer.length);

                System.out.print("Read " + numRead + " bytes -");

                // Convert bytes to String
                String S = new String(readBuffer, "UTF-8");

                System.out.println("Received -> " + S);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
