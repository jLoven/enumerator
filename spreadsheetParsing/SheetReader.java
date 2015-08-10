//  Jackie Loven, 1 August 2015
//  File reading reference: http://goo.gl/cIH0hc


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

import userInput.FileChooser;
import dataStoring.CodeValuePair;

public class SheetReader {

	//static String[] args = new String[] {""};

	public static void main(String[] args) {
		FileChooser.main(args);
		final String FILE_PATH = FileChooser.getSelectedFilePath().toString();

		ArrayList<CodeValuePair> finalList = getCodesAndValues(FILE_PATH);
		System.out.println(finalList);
	}

	public static ArrayList<CodeValuePair> getCodesAndValues(String filePath) {
		ArrayList<CodeValuePair> codeValuePairsList = new ArrayList<CodeValuePair>();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			//  Grab first sheet, allow iterator:
			XSSFSheet sheet = workbook.getSheetAt(0);
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
