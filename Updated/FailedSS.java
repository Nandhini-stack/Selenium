package framework;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class FailedSS extends ExcelDataProvider implements ITestListener{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		failed(arg0.getParameters().toString());
		System.out.println("Failed " + arg0.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Skipped " + arg0.getMethod().getMethodName());
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
