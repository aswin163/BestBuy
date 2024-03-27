package utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.ProjectSpecifications;

public class Listener extends ProjectSpecifications implements ITestListener{
	
	ExtentReports extent = ExtentReportBestBuy.getReport();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Pass");
		String filepath=null;
		try {
			filepath = getScreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(filepath,"TestPass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		String filepath=null;
		
		try {
			filepath = getScreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(filepath, "TestFail");
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
	
	

}
