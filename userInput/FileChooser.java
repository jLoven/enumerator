//  Jackie Loven, 2 August 2015
//  JFileChooser settings reference: http://goo.gl/GanKvo.


package userInput;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import dataStoring.SelectedFile;

public class FileChooser {
	
	private static SelectedFile file = new SelectedFile();
	
  public static void main(String[] args) {
    JFileChooser chooser = new JFileChooser();
    chooser.setApproveButtonText("Make Enumeration!");
    chooser.setDialogTitle("Choose Microsoft Excel Spreadsheet");
    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    chooser.setAcceptAllFileFilterUsed(false);
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Microsoft Excel Files", "xlsx", "xls");
    chooser.setFileFilter(filter);

    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      file.setFilePath(chooser.getSelectedFile());
    }
  }
  
  public static File getSelectedFilePath() {
	  return file.getFilePath();
  }
  
  
}
