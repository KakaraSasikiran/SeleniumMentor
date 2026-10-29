package MeenaSelenium.MeenaSelenium;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

public class Help extends Extents implements ITestListener {
	public WebDriver driver;
	ExtentReports extentReports = Extents.getExtentReports();
	ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestStart(result);
		System.out.println(result.getMethod().getMethodName());
		extentTest = extentReports.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSuccess(result);
		System.out.println(result.getMethod().getMethodName());
		extentTest.log(Status.INFO, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onFinish(context);
		extentReports.flush();

	}

	@Test
	public void LaunchBrowser() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		File drc = new File(System.getProperty("user.dir") + "//images//one.png");
		try {
			FileUtils.copyFile(src, drc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void printUrl() throws Exception {
		Assert.assertEquals(driver.getTitle(), "Sasi");
		System.out.println(driver.getCurrentUrl());

	}

	@Test
	public void sasik() throws Exception {
		System.out.println(driver.getTitle());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.log(Status.FAIL, new Throwable().fillInStackTrace());
		try {
			driver = (WebDriver) result.getMethod().getRealClass().getDeclaredField("driver").get(result.getInstance());
			String pathString = takeScreenshot(result.getName(), driver);
			extentTest.addScreenCaptureFromPath(pathString);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
