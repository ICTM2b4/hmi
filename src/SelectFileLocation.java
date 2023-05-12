import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class SelectFileLocation extends JPanel {
JFileChooser fc;
private Boolean fileSelected = false;
private String fileLocation;

    public  SelectFileLocation(String orderNumber){
        //Create a file chooser
         fc = new JFileChooser();
            fc.setCurrentDirectory(new java.io.File(System.getProperty("user.home") + "\\Downloads\\"));
            fc.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));
            fc.setSelectedFile(new File(orderNumber ));
//In response to a button click:
        int returnVal = fc.showSaveDialog(SelectFileLocation.this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            fileSelected = true;
            fileLocation = fc.getSelectedFile().getAbsolutePath();
        }
        else if (returnVal == JFileChooser.CANCEL_OPTION){
            fileSelected = false;
        }
    }

    public Boolean getFileSelected() {
        return fileSelected;
    }

    public String getFileLocation() {
        return fileLocation;
    }


}
