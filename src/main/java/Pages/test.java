package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.Utilities;

public class test extends Base{

	public static void main(String[] args) {
		initialization();
		
		/*
		 * String a =
		 * driver.findElement(By.xpath("//multi-select/div[2]/ul/li/a")).getText();
		 * System.out.println(a);
		 */	
		
		Utilities.scrollToElement("skl");
		 driver.findElement(By.xpath("//*[@id=\"msdd\"]")).click(); 
		  driver.findElement(By.xpath("//multi-select/div[2]/ul/li/a[contains(text(),'Czech')]")).click(); 
		  		 	driver.close();
	}

}
