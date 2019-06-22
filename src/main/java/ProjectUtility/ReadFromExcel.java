package ProjectUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
	public static FileInputStream file;

	public static XSSFSheet getSheet() throws IOException {
		XSSFSheet sheet=null;
		try {
			file = new FileInputStream(
					new File("C:\\Users\\sudeeprana\\workspace\\Assignment\\TestData\\testdata.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			 sheet = workbook.getSheetAt(0);
		} catch (FileNotFoundException e) {
			System.out.println("excel sheet not found");
		}
		return sheet;
	}

	public static String getDataFromExcel(String dataName) {
		String username = null;
		try {


			// Iterate through each rows one by one
			Iterator<Row> rowIterator = getSheet().iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				if (row.getCell(0).getStringCellValue().equals(dataName)) {

					username = row.getCell(1).getStringCellValue();

				}

			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return username;

	}

}
