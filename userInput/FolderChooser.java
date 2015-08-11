//  Jackie Loven, 10 August 2015
//  JFileChooser settings reference: http://goo.gl/GanKvo.


package userInput;

import java.io.File;

import javax.swing.JFileChooser;

import dataStoring.SelectedFile;

public class FolderChooser {

	private static SelectedFile file = new SelectedFile();
	
	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser();
		chooser.setApproveButtonText("Choose");
		chooser.setDialogTitle("Choose Folder for Generated Enum");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			chooser.setVisible(false);
			file.setFilePath(chooser.getSelectedFile());
			System.out.println(file.toString());
		}
	}
	
	public static File getSelectedFilePath() {
		return file.getFilePath();
	}


}
