//  Jackie Loven, 1 August 2015
//  Adapted from http://goo.gl/ckqE63.


package spreadsheetParsing;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dataStoring.CodeValuePair;

public class SheetCreator {

	public static void main(String[] args) {
		//  New workbook with blank sheet:
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		XSSFSheet sheet = workbook.createSheet("Sample");

		//  Some data to stick in the sheet:
		ArrayList<CodeValuePair> data = new ArrayList<CodeValuePair>();
		CodeValuePair cvp1 = new CodeValuePair("Hello", "World");
		CodeValuePair cvp2 = new CodeValuePair("123", "456");
		data.add(cvp1);
		data.add(cvp2);

		//  Codes go in column 0. Values go in column 1.
		//  Currently this stores every item as a string. Does this matter?
		for (int i = 0; i < data.size(); i++) {
			Row row = sheet.createRow(i);
			for (int j = 0; j < 2; j++) {
			Cell cell = row.createCell(j);
				if (j == 0) {
					cell.setCellValue(data.get(i).getCode());
				}
				if (j == 1) {
					cell.setCellValue(data.get(i).getValue());
				}
			}
		}
		
		//  Make the Excel workbook. Remember to close it!
		try {
			FileOutputStream out = new FileOutputStream(new File("first_generated_excel.xlsx"));
			workbook.write(out);
			out.close();
			workbook.close();
			System.out.println("first_generated_excel.xlsx written successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
