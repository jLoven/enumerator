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
		chooser.setApproveButtonText("Choose");
		chooser.setDialogTitle("Choose Microsoft Excel Spreadsheet");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Microsoft Excel Files", "xlsx");
		chooser.setFileFilter(filter);

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			file.setFilePath(chooser.getSelectedFile());
			EnumSettingsChooser.main(null);
		}
	}

	public static File getSelectedFilePath() {
		return file.getFilePath();
	}


}
