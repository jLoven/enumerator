//  Jackie Loven, 2 August 2015


package dataStoring;

import java.io.File;

public class SelectedFile {

	//  This works with directories too.
	//  No need for a new class to store directory info.
	
	private File filePath;
	
	public SelectedFile() {}
	
	public File getFilePath() {
		return this.filePath;
	}
	
	public void setFilePath(File selectedFilePath) {
		this.filePath = selectedFilePath;
	}
	
	public void setFilePath(String selectedFilePath) {
		File path = new File(selectedFilePath);
		this.filePath = path;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.filePath);
	}
	
}
