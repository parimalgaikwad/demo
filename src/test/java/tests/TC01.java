package tests;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.Base;
import Pages.RegisterPage;
import Utils.Utilities;

public class TC01 extends Base {

 RegisterPage RP;
 
    	
    	@BeforeClass
    	public void setup() {
    		initialization();
    		RP = new RegisterPage();
    		
    		
    	}
    	
    	
    	@Test(priority=1,dataProvider = "dp", dataProviderClass = Utilities.class)
    	public  void verifyFirstNameTest(Hashtable <String , String> data) {
    		
    		RP.setFirstName(data.get("name"));
    		Assert.assertEquals(RP.getFirstName(), data.get("name"));
    	}	
    	
    	
    	@Test(priority=2,dataProvider = "dp", dataProviderClass = Utilities.class)
    	public  void verifyLastNameTest(Hashtable <String , String> data) {
    		
    		RP.setLastName(data.get("lastname"));
    		Assert.assertEquals(RP.getLastName(), data.get("lastname"));
    	}	
    	
    	
    	@Test(priority=3,dataProvider = "dp", dataProviderClass = Utilities.class)
    	public  void verifyAddressTest(Hashtable <String , String> data) {
    		
    		RP.setAddress(data.get("add"));
    		Assert.assertEquals(RP.getAddress(), data.get("add"));
    	}	
    	
    	
    	@Test(priority=3,dataProvider = "dp", dataProviderClass = Utilities.class)
    	public  void verifyEmailTest(Hashtable <String , String> data) {
    		
    		RP.setEmail(data.get("email"));
    		Assert.assertEquals(RP.getEmail(), data.get("email"));
    	}	
    	
    	
    	@Test(priority=4,dataProvider = "dp", dataProviderClass = Utilities.class)
    	public  void verifyMobileTest(Hashtable <String , String> data) {
    		
    		RP.setPhone(data.get("phone"));
    		Assert.assertEquals(RP.getPhone(), data.get("phone"));
    	}	
    	
    	
    	
    	
    	@Test(priority=5,dataProvider = "dp", dataProviderClass = Utilities.class)
    	public void verifyGenderTest(Hashtable <String , String> data)
    	{	String gender=data.get("gender");
    	
			
			  RP.setGender(gender);
			  if(gender.equalsIgnoreCase("male"))
			  Assert.assertTrue(Utilities.isSelected("male"));
			  else if(gender.equalsIgnoreCase("female"))
			  Assert.assertTrue(Utilities.isSelected("female"));
			 
    	}  
    	
    	@Test(priority=6,dataProvider = "dp", dataProviderClass = Utilities.class)
    	public void verifyHobbiesTest(Hashtable <String , String> data)
    	{	String hobby=data.get("hobbies");
    	
			
			  RP.setHobbies(hobby);
			  if(hobby.equalsIgnoreCase("cricket"))
			  Assert.assertTrue(Utilities.isSelected("cricket"));
			  else if(hobby.equalsIgnoreCase("movies"))
			  Assert.assertTrue(Utilities.isSelected("movies"));
			  else if(hobby.equalsIgnoreCase("hockey"))
				  Assert.assertTrue(Utilities.isSelected("hockey"));
			 
    	} 
    	
    	@Test(priority=7,dataProvider = "dp", dataProviderClass = Utilities.class)
    	public void verifyLanguageTest(Hashtable <String , String> data)
    	{
    		RP.setLanguage(data.get("lang"));
    		System.out.println(RP.getLanguage());
    		Assert.assertEquals(data.get("lang"), RP.getLanguage());
    		
    	}
    	
    	@Test(priority=8,dataProvider = "dp", dataProviderClass = Utilities.class)
    	public void verifySkillsTest(Hashtable <String , String> data)
    	{
    		RP.setSkills(data.get("skills"));
    		Assert.assertEquals(data.get("skills"), RP.getSkills());
    		
    	}
    	
    	
    	
    	@Test(priority=9,dataProvider = "dp", dataProviderClass = Utilities.class)
    	public void verifyCountryTest(Hashtable <String , String> data)
    	{	
    		RP.setCountry(data.get("country"));
    		
    	}
    	
    	@Test(priority=10,dataProvider = "dp", dataProviderClass = Utilities.class)
    	public void verifyYearTest(Hashtable <String , String> data)
    	{
    		RP.setYear(data.get("year"));
    		Assert.assertEquals(data.get("year"), RP.getYear());
    	}
    	
    	@Test(priority=11,dataProvider = "dp", dataProviderClass = Utilities.class)
    	public void verifyMonthTest(Hashtable <String , String> data)
    	{
    		RP.setMonth(data.get("month"));
    		Assert.assertEquals(data.get("month"), RP.getMonth());
    	}
    
    	@Test(priority=12,dataProvider = "dp", dataProviderClass = Utilities.class)
    	public void verifyDayTest(Hashtable <String , String> data)
    	{
    		RP.setDay(data.get("day"));
    		Assert.assertEquals(data.get("day"), RP.getDay());
    	}
    	
    	
    	@Test(priority=13,dataProvider = "dp", dataProviderClass = Utilities.class)
    	public  void verifyPasswordTest(Hashtable <String , String> data) {
    		
    		RP.setPassword(data.get("pwd"));
    		Assert.assertEquals(RP.getPassword(), data.get("pwd"));
    	}
    	@Test(priority=14,dataProvider = "dp", dataProviderClass = Utilities.class)
    	public  void verifyConfirmPwdTest(Hashtable <String , String> data) {
    		
    		RP.setConfirmPwd(data.get("confirmpwd"));
    		Assert.assertEquals(RP.getConfirmPwd(), data.get("confirmpwd"));
    	}	
    	
    	@AfterClass
    	public void teardown() {
    		try {Thread.sleep(5000);}
    		catch (InterruptedException e) {e.printStackTrace();}
    	driver.close();	
    	}
    	


}
