package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utility.ExcelReader;
import utility.ExtentManager;

public class Base {

	public static WebDriver driver;
	public static Logger log;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static Properties OR = new Properties();
	public static FileInputStream fis;

	@BeforeSuite
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Parimal\\eclipse-workspace\\GuruEcommerce\\src\\test\\resources\\executables\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://live.demoguru99.com/index.php/");
		Reporter.log("Navigated to site");
		PropertyConfigurator
				.configure(System.getProperty("user.dir") + "//src//test//resources//properties//log4j.properties");

		log = Logger.getLogger(Base.class.getName());
		try {
			fis = new FileInputStream(
					"C:\\Users\\Parimal\\eclipse-workspace\\GuruEcommerce\\src\\test\\resources\\properties\\OR.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			OR.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@AfterSuite
	public void tearDown() {
		if (driver != null)
			driver.close();
	}

	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static void click(String locator) {

		driver.findElement(By.xpath(locator)).click();
	}

	public static void type(String locator, String value) {

		driver.findElement(By.xpath(locator)).sendKeys( value);
	}
	public static void type(String locator, Integer value) {
      
		driver.findElement(By.xpath(locator)).sendKeys(""+ value);
	}
	
	

	public static String getText(String locator) {

		String s = driver.findElement(By.xpath(locator)).getText();
		return s;
	}

	public static String captureScreenshot() throws Exception {

		File Src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String name = d.toString().replace(" ", "_").replace(":", "_") + ".jpg";
		String path = System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + name;

		File dest = new File(path);

		FileUtils.copyFile(Src, dest);
		return path;
	}

	@DataProvider(name = "dp")
	public static Object[][] getData(Method m) {
		ExcelReader excel = new ExcelReader("C:\\Users\\Parimal\\Desktop\\GuruEcommerce.xlsx");
		String sheetname = m.getName();
		int rows = excel.getRowCount(sheetname);
		int cols = excel.getColumnCount(sheetname);
		Object[][] data = new Object[rows - 1][1];

		for (int rownum = 2; rownum <= rows; rownum++) {
			Hashtable<String, String> h = new Hashtable<String, String>();
			for (int colnum = 0; colnum < cols; colnum++) {

				h.put(excel.getCellData(sheetname, colnum, 1), excel.getCellData(sheetname, colnum, rownum));
				data[rownum - 2][0] = h;

			}

		}
		return data;
	}

	public static void select(String locator, String value) {
		WebElement e = driver.findElement(By.xpath(locator));
		Select dropdown = new Select(e);
		dropdown.selectByVisibleText(value);

	}

}
