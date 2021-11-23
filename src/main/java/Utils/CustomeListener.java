package Utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomeListener extends Utilities  implements ITestListener{


	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult arg0) {
		try {
			Utilities.captureScreenshot(arg0.getName()+" Failed");
			} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult arg0) {
		
	}

	public void onTestSuccess(ITestResult arg0) {
		try {
			Utilities.captureScreenshot(arg0.getName()+" Passed");
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}