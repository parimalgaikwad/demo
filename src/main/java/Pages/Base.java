package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.ExcelReader;

public class Base {
	
	public static WebDriver driver;
	public static Properties config;
	public static Properties OR;
	public static WebDriverWait wait;
	public static ExcelReader excel;
	
	public Base() {

		config = new Properties();
		OR = new Properties();
		excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\AutomationTaskData.xlsx");
		try {
			config.load(new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			OR.load(new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\OR.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void initialization()
	{ 	System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");
		 * DesiredCapabilities capabilities = new DesiredCapabilities();
		 * capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		 */
    driver = new ChromeDriver();

		
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		
		
		
	}
}
