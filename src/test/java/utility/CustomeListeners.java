package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import test.Base;

public class CustomeListeners  extends Base implements ITestListener  {

	public void onTestStart(ITestResult result) {
test = rep.startTest(result.getName().toUpperCase());	
	}

	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getName()+ "test is Passed");
		try {
			test.log(LogStatus.PASS, test.addScreenCapture(Base.captureScreenshot()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rep.endTest(test);
		rep.flush();
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
