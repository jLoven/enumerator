package dataStoring;

public class EnumSettings {

	private String packageName;
	private String className;
	//  TODO: Should be file path?:
	private String destinationFolder;
	
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
	
	public String getclassName() {
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
	
	// TODO: Should be file path?:
	public String getDestinationFolder() {
		return this.destinationFolder;
	}
	
	// TODO: Should be file path?:
	private void setDefaultDestinationFolder() {
		//  TODO: make it stick it on your desktop.
		//this.destinationFolder = 
	}
	
	// TODO: Should be file path?:
	public void setDestinationFolder(String destinationFolder) {
		//  check if null or not.
		//  TODO: make new folder path set it.
		
	}
	
	@Override
	public String toString() {
		return "Package Name: " + this.packageName + 
				" Class Name: " + this.className + 
				" Destination Folder: " + String.valueOf(this.destinationFolder);
	}
	
}
