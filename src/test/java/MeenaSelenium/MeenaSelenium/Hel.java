package MeenaSelenium.MeenaSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class Hel {

	@Test
	public void testName() throws Exception {
		/*
		 * Actions:- movetoElement,drag and drop, single click,double click
		 * 
		 */
		WebDriver driver = new ChromeDriver();
		driver.get("https://automationteststore.com/");
		Actions actions = new Actions(driver);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
//		WebElement src = driver.findElement(By.cssSelector("div#draggable"));
//		WebElement dsc = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
//		actions.dragAndDrop(src, dsc).build().perform();

//		WebElement element = driver.findElement(By.xpath("(//a[@class='w5hRs'])[1]"));
//		actions.moveToElement(element).build().perform();
//		actions.click(element).build().perform();
//		actions.doubleClick(element).build().perform();
		WebElement element = driver.findElement(
				By.cssSelector("a[href='https://automationteststore.com/index.php?rt=product/category&path=36']"));
		actions.moveToElement(element).build().perform();
		driver.findElement(RelativeLocator.with(By.linkText("Face")).below(element)).click();

	}
}
