package Utilities;

import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

public class listener extends TestListenerAdapter{
	
	   public void onTestStart(ITestContext Result) {
		   System.out.println("Test started");
	   }
	   
	   public void onTestSuccess(ITestContext Result) {
		   System.out.println("Test passed");
	   }

	   public void onTestFailure(ITestContext Result) {
		   System.out.println("Test failed");
	   }
	   
	   public void onTestSkipped(ITestContext Result) {
		   System.out.println("Test skipped");
	   }
	   
	}
