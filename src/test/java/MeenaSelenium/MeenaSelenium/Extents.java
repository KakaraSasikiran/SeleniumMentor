package MeenaSelenium.MeenaSelenium;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extents {
	static File file;
	public static ExtentReports getExtentReports() {
		ExtentReports extentReports = new ExtentReports();
		String path = System.getProperty("user.dir") + "//reports//one.html";
		File file = new File(path);
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(extentSparkReporter);
		return extentReports;
	}
	@Test
	public void testName() throws Exception {
		

	}
}
