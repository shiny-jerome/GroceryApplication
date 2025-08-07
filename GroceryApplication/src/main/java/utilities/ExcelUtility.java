package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static FileInputStream f;

	public static String readDataFromExcel(int row, int column, String filePath, String sheet1) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir") + filePath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet1);
		DataFormatter formatter = new DataFormatter();
		Row r = sh.getRow(row);
		Cell c = r.getCell(column);
		String value = formatter.formatCellValue(c);
		// return c.getStringCellValue();
		return value;
	}

}
