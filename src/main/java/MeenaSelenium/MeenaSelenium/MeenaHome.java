package MeenaSelenium.MeenaSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MeenaHome {

	public WebDriver driver;

	public MeenaHome(WebDriver driver) {
		this.driver = driver;
	}

	By alertBy = By.cssSelector("input#alertbtn");

	public void clickAlert() {
		driver.findElement(alertBy).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	

}
