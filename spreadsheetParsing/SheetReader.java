//  Jackie Loven, 1 August 2015
//  Adapted from http://goo.gl/cIH0hc.


package spreadsheetParsing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dataStoring.CodeValuePair;

public class SheetReader {

	//  TODO: Replace with file picking window.
	private static final String FILE_PATH = 
			"/Users/platypus/Desktop/random_stuff/code/java/enumerator/Enumerator/first_generated_excel.xlsx";

	public static void main(String[] args) {
		ArrayList<CodeValuePair> finalList = getCodesAndValues();
		System.out.println(finalList);
	}

	public static ArrayList<CodeValuePair> getCodesAndValues() {
		ArrayList<CodeValuePair> codeValuePairsList = new ArrayList<CodeValuePair>();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(FILE_PATH);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			//  Grab first sheet:
			XSSFSheet sheet = workbook.getSheetAt(0);
			//  Allow an iterator on the XSSFSHeet:
			Iterator<Row> rowIterator = sheet.iterator();

			//  Iterate over rows.
			while (rowIterator.hasNext()) {
				CodeValuePair codeValuePair = new CodeValuePair();
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				//  Iterate over each cell in that row.
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					if (cell.getColumnIndex() == 0) {
						codeValuePair.setCode(CellReader.makeString(cell));
					} else if (cell.getColumnIndex() == 1) {
						codeValuePair.setValue(CellReader.makeString(cell));
					}
				} 
				//  Keep track of the code-value pair just created.
				codeValuePairsList.add(codeValuePair);
			}
			workbook.close();
			fileInputStream.close();
			
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return codeValuePairsList;
	}
}
