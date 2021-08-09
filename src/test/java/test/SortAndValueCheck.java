package test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class SortAndValueCheck extends Base {
	

	
	
@Test
public static void checkSorting ()throws InterruptedException, IOException

	{

	System.setProperty("org.uncommons.reportng.escape-output", "false");
	
	click("//*[@id='nav']/ol/li[1]/a");
	test.log(LogStatus.INFO, "CLicked on Mobile");

		Select sortBy = new Select(
				driver.findElement(By.cssSelector("div.category-products>div>div>div.sort-by>select")));
		sortBy.selectByVisibleText("Name");
		test.log(LogStatus.INFO, "Selected sort by Name");

		
	
	}

@Test
public static void checkValue() {
	click("//*[@id='nav']/ol/li[1]/a");

		String valueInList =driver.findElement(By.cssSelector("div.product-info>div>span#product-price-1>span.price")).getText();
test.log(LogStatus.INFO, "Value in the List is :"+valueInList);
		driver.findElement(By.cssSelector("img#product-collection-image-1")).click();
		
		String ValueInDetailsPage = driver.findElement(By.cssSelector("span.price")).getText();
	test.log(LogStatus.INFO, "Value in the Details is :"+ValueInDetailsPage);

		Assert.assertEquals(valueInList, ValueInDetailsPage );
		
	}



}
