package MeenaSelenium.MeenaSelenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Meena extends App {

	public static void main(String[] args) {
		optBrowser("two");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
//		pickYourDropdown("Teacher");
//		pickYourDropdownBasedOnIndex(2);
//		performClick(By.cssSelector("button#openwindow"));
//		window_handles();
//		driver.close();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		handle_alert_box(By.cssSelector("button[name='alertbox']"));
//		driver.findElement(By.cssSelector("")).click();
		WebElement element = driver.findElement(By.cssSelector("iframe#courses-iframe"));
		driver.switchTo().frame(element).findElement(By.xpath("(//a[text()='Courses'])[1]")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("input[value='radio1']")).click();
	}

}
