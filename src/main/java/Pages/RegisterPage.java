package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.Utilities;

public class RegisterPage extends Utilities {

	public void setFirstName(String name) {
		type("firstname", name);
	}

	public String getFirstName() {
		return getAttribute("firstname", "value");
	}

	public void setLastName(String name) {
		type("lastname", name);
	}

	public String getLastName() {
		return getAttribute("lastname", "value");
	}

	public void setAddress(String add) {
		type("address", add);
	}

	public String getAddress() {
		return getAttribute("address", "value");
	}
	
	public void setEmail(String mail) {
		type("email", mail);
	}

	public String getEmail() {
		return getAttribute("email", "value");
	}
	
	public void setPhone(String Phone) {
		type("phone", Phone);
	}

	public String getPhone() {
		return getAttribute("phone", "value");
	}
	
	public void setLanguage(String lang) {
		Utilities.scrollToElement("skl");
		 driver.findElement(By.xpath("//*[@id=\"msdd\"]")).click(); 
		  driver.findElement(By.xpath("//multi-select/div[2]/ul/li/a[contains(text(),'"+lang+"')]")).click(); 

	}
	public String getLanguage() {
		return driver.findElement(By.xpath(OR.getProperty("lang"))).getText();
	}

	
	public void setSkills(String name) {
		Utilities.scrollToElement("skl");
		dropdown("skills", name);

	}

	public String getSkills() {
		return getAttribute("skills", "value");
	}

	public void setGender(String g) {
		if (g.equalsIgnoreCase("female"))
			click("female");
		if (g.equalsIgnoreCase("male"))
			click("male");
	}
	
	public void setHobbies(String h) {
		Utilities.scrollToElement("hobby");
		if (h.equalsIgnoreCase("cricket"))
			click("cricket");
		else if (h.equalsIgnoreCase("movies"))
			click("movies");
		else if (h.equalsIgnoreCase("hockey"))
			click("hockey");
	}

	public void setCountry(String country)

	{
		scrollToElement("country");
		click("country");
		WebElement c = driver
				.findElement(By.xpath("//span[@class='select2-results']/ul/li[contains(text(),'" + country + "')]"));
		c.click();

	}

	public void setYear(String year) {
		scrollToElement("dob");
		dropdown("year", year);
	}

	public String getYear() {
		scrollToElement("dob");
		return getAttribute("year", "value");
	}
	
	public void setMonth(String month) {
		scrollToElement("dob");
		dropdown("month", month);
	}

	public String getMonth() {
		scrollToElement("dob");
		return getAttribute("month", "value");
	}
	public void setDay(String day) {
		scrollToElement("dob");
		dropdown("day", day);
	}

	public String getDay() {
		scrollToElement("dob");
		return getAttribute("day", "value");
	}
	
	public void setPassword(String pwd) {
		scrollToElement("password");
		type("password", pwd);
	}

	public String getPassword() {
		scrollToElement("password");

		return getAttribute("password", "value");
	}
	public void setConfirmPwd(String pwd) {
		scrollToElement("password");
		type("confirmpassword", pwd);
	}

	public String getConfirmPwd() {
		scrollToElement("password");
		return getAttribute("confirmpassword", "value");
	}

}
