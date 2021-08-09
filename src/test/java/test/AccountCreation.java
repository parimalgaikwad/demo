package test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccountCreation extends Base {

	public static void main(String[] args) throws Exception

	{
		String chrome = System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chrome);
		driver = new ChromeDriver();
		driver.get("http://live.demoguru99.com/index.php/");
		driver.manage().window().maximize();
		String logs = System.getProperty("user.dir") + "//src//test//resources//properties//log4j.properties";
		PropertyConfigurator.configure(logs);

		log = Logger.getLogger(Base.class.getName());

		click("//div/div[@class='block-title']/following-sibling::ul/li/a[@title='My Account']");

		log.info("CLicked on my Account");

		click("//a[@title ='Create an Account' ]");
		log.info("CLicked on create an account");

		type("//input[@id='firstname']", "pari");
		type("//input[@id='lastname']", "Gaikwad");
		type("//input[@id='email_address']", "pari@gmail.com");
		Thread.sleep(5000);
		type("//input[@id='password']", "parimal");
		WebElement cp = driver.findElement(By.xpath("//input[@title='Confirm Password']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", cp);
		cp.sendKeys("parimal");
		click("//button[@title='Register']");
		String reg = "Thank you for registering with Main Website Store.";
		boolean b = getText("//li/span").equalsIgnoreCase(reg);
		System.out.println(b);
		click("//nav/ol/li[@class='level0 nav-2 last']/a");
		click("//h2/a[@title='LG LCD']/parent::h2/following-sibling::div/ul/li/a[@class='link-wishlist']");
		click("//span[contains(text(),'Share')]");
		type("//*[@id=\"email_address\"]", "swarajforupsc@gmail.com");
		click("//*[@id=\"form-validate\"]/div[2]/button/span/span");
		String f = getText("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span");
		String F = "Your Wishlist has been shared.";
		System.out.println(f.equalsIgnoreCase(F));
	}

}
