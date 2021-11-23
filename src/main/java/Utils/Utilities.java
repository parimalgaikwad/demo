package Utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import Pages.Base;

public class Utilities extends Base

{

	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
		} catch (Exception e) {

			return false;
		}
		return true;
	}

	public static void click(String locator) {

		driver.findElement(By.xpath(OR.getProperty(locator))).click();
	}

	public static void type(String locator, String value) {

		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);

	}

	public static String getText(String locator) {

		String s = driver.findElement(By.xpath(OR.getProperty(locator))).getText();
		return s;
	}

	public static void dropdown(String locator, String text) {

		Select select = new Select(driver.findElement(By.xpath(OR.getProperty(locator))));
		select.selectByVisibleText(text);

	}
	
	public static void scrollToElement(String  locator)
	{
WebElement e = driver.findElement(By.xpath(OR.getProperty(locator)));
JavascriptExecutor je = (JavascriptExecutor) driver;
je.executeScript("arguments[0].scrollIntoView(true);",e);
		
	}

	public static String getAttribute(String locator, String attri) {

		return driver.findElement(By.xpath(OR.getProperty(locator))).getAttribute(attri);

	}

	public static void captureScreenshot(String name) {
		Date d = new Date();
		String date = d.toString().replace(":", "_").replace(" ", "_"); 
		
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\TC01Screenshots\\" +"TC01"+ name +".jpg";
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File destFile = new File(path);
			FileUtils.copyFile(scrFile, destFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean isSelected(String locator) {

		return driver.findElement(By.xpath(OR.getProperty(locator))).isSelected();
	}

	@DataProvider(name="dp")
	public Object[][] getData() {
	       
	String sheet = "register";
	int rows = excel.getRowCount(sheet);
	int cols = excel.getColumnCount(sheet);
	Object[][] data = new Object[rows - 1][1];

	for (int rownum = 2; rownum <= rows; rownum++) {
	Hashtable <String , String> table = new Hashtable <String , String> ();
	for (int colnum = 0; colnum < cols; colnum++) {
	table.put(excel.getCellData(sheet, colnum, 1), excel.getCellData(sheet, colnum, rownum));
	data[rownum - 2][0] = table;

	}

	}

	return data;
	}}