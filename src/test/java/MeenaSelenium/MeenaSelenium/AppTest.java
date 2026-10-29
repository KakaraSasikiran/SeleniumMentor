package MeenaSelenium.MeenaSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {

	public WebDriver driver;
	@BeforeSuite
	public void init() {
		System.out.println("Before suite");
		driver = new ChromeDriver();
	}
	@BeforeTest
	public void oness() {
		System.out.println("Onbes");
		driver.get("https://www.google.com");
	}
	@AfterSuite
	public void tests() {
		System.out.println("Tests");
		driver.close();
		
	}
	@Test
	public void testName() throws Exception {
		Assert.assertEquals(driver.getTitle(),"ONes");
		
		
	}
//	@Test
//	public void onesY() throws Exception {
//		System.out.println(driver.getTitle());
//		System.out.println("Login");
//	}
   
}
