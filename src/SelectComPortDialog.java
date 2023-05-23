import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;

import com.fazecast.jSerialComm.SerialPort;

public class SelectComPortDialog extends JDialog implements ActionListener {
    private String[] availablePortsList = convertPortListToString(SerialPort.getCommPorts());
    JComboBox<String> jcAvailiblePorts = new JComboBox<>(availablePortsList);
    JButton jbConnect = new JButton("Verbinden");
    JButton jbClose = new JButton("Applicatie sluiten");

    public SelectComPortDialog(JFrame frame) {
        super(frame, true);
        setSize(350, 200);
        setTitle("Selecteer de com poort");
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setLayout(new GridLayout(3, 1));
        jbConnect.addActionListener(this);
        jbClose.addActionListener(this);
        add(jcAvailiblePorts);
        add(jbConnect);
        add(jbClose);
        setVisible(true);
    }

    /**
     * this method will convert a SerialPort[] to a String[].
     * this makes it possible to use the SerialPort[] in a JComboBox.
     * 
     * @param portList
     * @return String[]
     */
    String[] convertPortListToString(SerialPort[] portList) {
        String[] portListString = new String[portList.length];
        for (int i = 0; i < portList.length; i++) {
            portListString[i] = portList[i].getDescriptivePortName();
        }
        return portListString;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Verbinden")) {
            try {
                Serial.open(jcAvailiblePorts.getSelectedIndex());
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            dispose();
        }
        if (e.getActionCommand().equals("Applicatie sluiten")) {
            System.exit(0);
        }

    }
}
