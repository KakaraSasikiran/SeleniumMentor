package MeenaSelenium.MeenaSelenium;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
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

	public String takeScreenshot(String testName, WebDriver driver) {

		String path = System.getProperty("user.dir") + "/reports/screenshots/" + testName + ".png";

		try {
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File destination = new File(path);

			destination.getParentFile().mkdirs();

//	        Files.copy(source.toPath(), destination.toPath(),
//	                StandardCopyOption.REPLACE_EXISTING);
			Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

			return destination.getAbsolutePath();

		} catch (IOException e) {
			throw new RuntimeException("Screenshot failed", e);
		}
	}

	@Test
	public void testName() throws Exception {

	}
}
