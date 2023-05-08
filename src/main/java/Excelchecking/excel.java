package Excelchecking;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class excel {
	DataFormatter formatter = new DataFormatter();

	@Test(dataProvider = "data")
	public void test(String name, String email) {
		System.out.println(name + email);

	}

	@DataProvider(name = "data")
	public Object[][] getData() throws Exception {

		FileInputStream fis = new FileInputStream("D:\\New folder\\Book10.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int columnCount = row.getLastCellNum();
		Object data[][] = new Object[rowCount-1][columnCount];
     	for (int i = 0; i < rowCount-1; i++) {
			row = sheet.getRow(i + 1);
		for (int j = 0; j < columnCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);

			}

		}
		return data;

		

	}

}
