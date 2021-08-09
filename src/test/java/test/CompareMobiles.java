package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CompareMobiles extends Base {
	@Test
	public static void compareMobilesTest() {

		driver.findElement(By.xpath("//*[@id='nav']/ol/li[1]/a")).click();
		log.info("clicked on mobile");

		driver.findElement(By.xpath(
				"//h2/a[@title='Sony Xperia']/parent::h2/following-sibling::div[3]/ul/li/a[contains(text(),'Add to Compare')]"))
				.click();
		log.info("Sony Experia add to compare clicked");
		driver.findElement(By.xpath(
				"//h2/a[@title='IPhone']/parent::h2/following-sibling::div[3]/ul/li/a[contains(text(),'Add to Compare')]"))
				.click();
		log.info("Iphone add to compare clicked");
		String Parent = driver.getWindowHandle();
		log.info("getting parent window handle" + Parent);

		driver.findElement(By.xpath("//button/span/span[contains(text(),'Compare')]")).click();
		log.info("clicked on compare");

		Set<String> s = new HashSet<String>();
		s = driver.getWindowHandles();

		Iterator<String> i = s.iterator();
		while (i.hasNext()) {
			String z = i.next();
			if (!z.equalsIgnoreCase(Parent)) {
				driver.switchTo().window(z);
				System.out.println(driver.getWindowHandle());
				log.info("Switching to compare window with handle" + z);
				System.out.println("$$$$$$$$$" + driver.findElement(By.xpath("//*[@id='top']/body/div/div[1]/h1"))
						.getText().equalsIgnoreCase("compare products"));
				log.info("Window heading checked");

				System.out.println("$$$$$$$$$" + driver.findElement(By.xpath("//td/h2/a[@title='IPhone']")).getText()
						.equalsIgnoreCase("iphone"));
				log.info("Iphone reflected in popup");

				System.out.println("$$$$$$$$$" + driver.findElement(By.xpath("//td/h2/a[@title='Sony Xperia']"))
						.getText().equalsIgnoreCase("sony xperia"));
				log.info("SonyXperia reflected in popup");
				driver.close();
				log.info("compare windo closed");

			}

		}
		driver.switchTo().window(Parent);

		log.info("switch to parent window" + Parent);

	}

}
