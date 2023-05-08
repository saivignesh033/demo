package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties p;
	public static FileInputStream f;
	DataFormatter formatter = new DataFormatter();

	public static WebDriver initializatizeBrowser() throws Exception {
		p = new Properties();
		f = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\property.properties");
		p.load(f);
		String browserName = p.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(co);

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		driver.manage().window().maximize();

		return driver;
	}

	public static void LaunchApplication(String URL) throws Exception {
		driver = initializatizeBrowser();
		String name = p.getProperty(URL);
		driver.get(name);
	}

	public static String screenShot(String testcasename, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sc = ts.getScreenshotAs(OutputType.FILE);
		File fs = new File(System.getProperty("user.dir") + "//reportsList//" + testcasename + ".png");
		FileUtils.copyFile(sc, fs);
		return fs.toString();

	}

	@DataProvider(name = "AmazonAndFlipcart")
	public Object[][] getData() throws Exception {

		FileInputStream fis = new FileInputStream("D:\\New folder\\FlipcartAndAmazon.xlsx");
		try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
			XSSFSheet sheet = wb.getSheetAt(0);
			int rowCount = sheet.getPhysicalNumberOfRows();
			XSSFRow row = sheet.getRow(0);
			int columnCount = row.getLastCellNum();
			Object data[][] = new Object[rowCount - 1][columnCount];
			for (int i = 0; i < rowCount - 1; i++) {
				row = sheet.getRow(i + 1);
				for (int j = 0; j < columnCount; j++) {
					XSSFCell cell = row.getCell(j);
					data[i][j] = formatter.formatCellValue(cell);

				}

			}
			return data;
		}

	}

	@DataProvider(name = "bigBasket")
	public Object[][] getData1() throws Exception {

		FileInputStream fis = new FileInputStream("D:\\New folder\\BigBasket.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int columnCount = row.getLastCellNum();
		Object data[][] = new Object[rowCount - 1][columnCount];
		for (int i = 0; i < rowCount - 1; i++) {
			row = sheet.getRow(i + 1);
			for (int j = 0; j < columnCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);

			}

		}
		return data;

	}

	@DataProvider(name = "greenKart")
	public Object[][] getData2() throws Exception {

		FileInputStream fis = new FileInputStream("D:\\New folder\\GreenKart.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int columnCount = row.getLastCellNum();
		Object data[][] = new Object[rowCount - 1][columnCount];
		for (int i = 0; i < rowCount - 1; i++) {
			row = sheet.getRow(i + 1);
			for (int j = 0; j < columnCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);

			}

		}
		return data;

	}
}
