package dataStoring;

public class EnumSettings {

	private String packageName;
	private String className;
	
	public EnumSettings() {}
	
	public String getPackageName() {
		return this.packageName;
	}
	
	private void setDefaultPackageName() {
		//  Defaults to no package name. 
		//  TODO: Check for this in your enum generator!
		this.packageName = "";
	}
	
	public void setPackageName(String packageName) {
		String sanitizedPackageName = packageName.replaceAll("[^a-zA-Z0-9]+", "");
		if (sanitizedPackageName != "") {
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
		//  Default class name if none is provided.
		//  TODO: Check for this in your enum generator!
		this.className = "Enumeration";
	}
	
	public void setClassName(String className) {
		String sanitizedClassName = className.replaceAll("[^a-zA-Z0-9]+", "");
		if (sanitizedClassName != "") {
			this.className = sanitizedClassName.substring(0, 1).toUpperCase() 
					+ sanitizedClassName.substring(1);
		} else {
			setDefaultClassName();
		}
	}
	
	@Override
	public String toString() {
		return "Package Name: " + this.packageName + " Class Name: " + this.className;
	}
	
}
