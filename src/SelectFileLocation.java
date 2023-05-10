import javax.swing.*;

public class SelectFileLocation extends JPanel{
JFileChooser fc;
    public SelectFileLocation(){
        //Create a file chooser
         fc = new JFileChooser();

//In response to a button click:
        int returnVal = fc.showOpenDialog(SelectFileLocation.this);
    }
}
