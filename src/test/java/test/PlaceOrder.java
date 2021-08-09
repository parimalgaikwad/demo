package test;
import java.util.Hashtable;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PlaceOrder  extends Base{

	@Parameters({"email","passwrd"})
	@Test
	public static void proceedToCheckout(String email , String passwrd) throws InterruptedException  {
		
	
		
		click(OR.getProperty("myaccount"));
		type(OR.getProperty("emailadd"), email);
		type(OR.getProperty("password"), passwrd);
		click(OR.getProperty("login"));
		click(OR.getProperty("mywishlist"));
		click(OR.getProperty("addtocart"));
		click(OR.getProperty("proceed"));
		Thread.sleep(2000);

		
		
		}
	
	@Test(dataProvider="dp",dataProviderClass=Base.class)
	public static void billingAddress(Hashtable<String,String>h) throws InterruptedException {
		
		
		type(OR.getProperty("streetadd"),h.get("address"));
		Thread.sleep(2000);
		type(OR.getProperty("city"),h.get("city"));
		Thread.sleep(2000);
        select(OR.getProperty("state"), h.get("state"));
		Thread.sleep(2000);

		type(OR.getProperty("zip"),(h.get("zip").substring(0,6)));
		Thread.sleep(8000);


        select(OR.getProperty("country"), h.get("country"));
		Thread.sleep(2000);

		type(OR.getProperty("telephone"),((h.get("telephone"))).replace(".", "").substring(0,10));
		Thread.sleep(18000);


		
		
		
		
	}

	

}