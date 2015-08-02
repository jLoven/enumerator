//  Jackie Loven, 1 August 2015


package dataStoring;

public class CodeValuePair {

	/** A code is stored on column 0 of the excel spreadsheet.
	 * Its expanded value is stored on column 1.
	 * Do not add column titles.
	 */

	private String code;
	private String value;

	public CodeValuePair() {}

	public CodeValuePair(String readCode, String readValue) {
		this.code = readCode;
		this.value = readValue;
	}

	public String getCode() {
		return this.code;
	}
	
	public void setCode(String readCode) {
		this.code = readCode;
	}

	public String getValue() {
		return this.value;
	}
	
	public void setValue(String readValue) {
		this.value = readValue;
	}

	@Override
	public String toString() {
		return "Code: " + this.code + " Value: " + this.value;
	}

}
