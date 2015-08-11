//  Jackie Loven, 10 August 2015


package dataStoring;

import java.io.File;

public class EnumSettings {

	private String packageName;
	private String className;
	private File destinationFolder;

	public EnumSettings() {}

	public String getPackageName() {
		return this.packageName;
	}

	private void setDefaultPackageName() {
		this.packageName = "defaultPackage";
	}

	public void setPackageName(String packageName) {
		String sanitizedPackageName = packageName.replaceAll("[^a-zA-Z0-9]+", "");
		if (sanitizedPackageName.length() > 0) {
			this.packageName = sanitizedPackageName.substring(0, 1).toLowerCase() 
					+ sanitizedPackageName.substring(1);
		} else {
			setDefaultPackageName();
		}
	}

	public String getClassName() {
		return this.className;
	}

	private void setDefaultClassName() {
		this.className = "Enumeration";
	}

	public void setClassName(String className) {
		String sanitizedClassName = className.replaceAll("[^a-zA-Z0-9]+", "");
		if (sanitizedClassName.length() > 0) {
			this.className = sanitizedClassName.substring(0, 1).toUpperCase() 
					+ sanitizedClassName.substring(1);
		} else {
			setDefaultClassName();
		}
	}

	public File getDestinationFolder() {
		return this.destinationFolder;
	}

	private void setDefaultDestinationFolder() {
		String desktopLocation = System.getProperty("user.home") + "/Desktop";
		this.destinationFolder = new File(desktopLocation);

	}

	public void setDestinationFolder(File filePath) {
		if (filePath != null) {
			this.destinationFolder = filePath;
		} else {
			setDefaultDestinationFolder();
		}
	}

	@Override
	public String toString() {
		return "Package Name: " + this.packageName + 
				" Class Name: " + this.className + 
				" Destination Folder: " + String.valueOf(this.destinationFolder);
	}

}
