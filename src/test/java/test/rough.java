package test;

import java.util.Hashtable;

import org.testng.annotations.Test;

import utility.ExcelReader;

public class rough extends Base{
	//////= 0;
	@Test(dataProvider="dp",dataProviderClass=Base.class)
	public static void billingAddress(Hashtable<String,String>h) throws InterruptedException {
		
		
		System.out.println( (h.get("zip").substring(0,6)));
		
		/*
		type(OR.getProperty("streetadd"),h.get("address"));
		Thread.sleep(2000);
		type(OR.getProperty("city"),h.get("city"));
		Thread.sleep(2000);
        select(OR.getProperty("state"), h.get("state"));
		Thread.sleep(2000);

		type(OR.getProperty("zip"),Integer.parseInt(h.get("zip")));
		Thread.sleep(8000);


        select(OR.getProperty("country"), h.get("country"));
		Thread.sleep(2000);

		type(OR.getProperty("telephone"),Integer.parseInt(h.get("telephone")));
		Thread.sleep(18000);


	*/
			
		}
	}
	


