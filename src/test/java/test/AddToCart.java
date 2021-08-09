package test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AddToCart extends Base {
    @Test
	public static void addToCartTest() throws InterruptedException, IOException

	{

	
		driver.findElement(By.xpath("//*[@id='nav']/ol/li[1]/a")).click();
		log.info("clicked on mobile");

		WebElement addToCart = driver
				.findElement(By.xpath("//h2/a[@title='Sony Xperia']/parent::h2/following-sibling::div[3]/button"));
		addToCart.click();
		log.info("added mobile to cart");

		System.out.println("Dpne");
		driver.findElement(By.xpath("//input[contains(@name , 'qty')]")).clear();

		driver.findElement(By.xpath("//input[contains(@name , 'qty')]")).sendKeys("1000");

		log.info("added 1000 qtyties");

		driver.findElement(By.xpath("//tbody/tr/td/button[contains(@value,'update_qty')]")).click();
		if (isElementPresent(By.xpath("//p[@class='item-msg error']")))
			log.error("The maximum quantity allowed for purchase is 500");
		driver.findElement(By.xpath("//button/span/span[contains(text(),'Empty')]")).click();
		// "//h1[contains(text(),'Empty')]"
		if (isElementPresent(By.xpath("//h1[contains(text(),'Empty')]")))
			log.info("SHOPPING CART IS EMPTY");
	

	}
}
