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

public class SheetCreator {

	public static void main(String[] args) {
		//  New workbook with blank sheet:
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		XSSFSheet sheet = workbook.createSheet("Sample");

		//  Some data to stick in the sheet:
		ArrayList<String> data = new ArrayList<String>();
		data.add("hello");
		data.add("world");

		//  Put it in cells in the same row
		int rowNumber = 0;
		Row row = sheet.createRow(rowNumber);
		int cellNumber = 0;
		for (String word : data) {
			Cell cell = row.createCell(cellNumber++);
			cell.setCellValue(word);
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
