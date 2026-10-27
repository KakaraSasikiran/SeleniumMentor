package MeenaSelenium.MeenaSelenium;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Upload_Download {

	public WebDriver driver;

	@BeforeSuite
	public void init() {
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/upload-download");
	}

	@Test
	public void upload() throws Exception {
		driver.findElement(By.cssSelector("input#uploadFile"))
				.sendKeys("C:\\Users\\Sasikiran Kakara\\eclipse-workspace\\MeenaSelenium\\one.txt");
	}
	@Test(dependsOnMethods = "upload")
	public void downloads() throws Exception {
		driver.findElement(By.cssSelector("a#downloadButton")).click();
		System.out.println(System.getProperty("user.dir"));
	}
}
