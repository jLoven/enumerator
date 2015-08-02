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

		//  Put it in cells in the same row
		int rowNumber = 0;
		int cellNumber = 0;
		for (Object datum : data) {
			Row row = sheet.createRow(rowNumber);
			Cell cell = row.createCell(cellNumber++);

			if (datum.getClass() == Double.class) {
				cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				cell.setCellValue((Double) datum);
			} else if (datum.getClass() == String.class) {
				cell.setCellType(Cell.CELL_TYPE_STRING);
				cell.setCellValue((String) datum);
			}
			if (cellNumber % 2 == 1) {
				rowNumber++;
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
