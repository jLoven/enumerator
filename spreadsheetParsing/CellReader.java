package spreadsheetParsing;

import org.apache.poi.ss.usermodel.Cell;

public class CellReader {

	public static String makeString(Cell cell) {
		
		//  Cell type is string.
		if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			return cell.getStringCellValue();
		} 
		//  Cell type is number.
		else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			double number = cell.getNumericCellValue();
			return String.valueOf(number);
		}
		//  Add others as needed.
		else {
			return cell.toString();
		}
	}
}
