//  Jackie Loven, 2 August 2015


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
			//  Assuming codes will often be integers and not doubles:
			//  (Want to truncate added .0's on possible integers)
			if (number == (int) number) {
				return String.valueOf((int) number);
			}
			return String.valueOf(number);
		}
		//  Add others as needed.
		else {
			return cell.toString();
		}
	}
}
