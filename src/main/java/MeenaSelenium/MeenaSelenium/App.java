package MeenaSelenium.MeenaSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 */
public class App {
	private static Properties properties;
	private static FileInputStream fileInputStream;
	public static WebDriver driver;
	public static Select select;
	static WebElement element;
	public static WebDriverWait wait;
	public static Properties getProperties(String fileName) {
		properties = new Properties();
		try {
			fileInputStream = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\MeenaSelenium\\MeenaSelenium\\" + fileName + ".properties");
			try {
				properties.load(fileInputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}

	public static WebDriver optBrowser(String fileName) {
		if (getProperties(fileName).getProperty("browser").toLowerCase().equals("chrome")) {
			driver = new ChromeDriver();
		} else if (getProperties(fileName).getProperty("browser").toLowerCase().equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (getProperties(fileName).getProperty("browser").toLowerCase().equals("edge")) {
			driver = new EdgeDriver();
		} else {
			System.err.println("Sorry!Please Check Properly!");
		}
		driver.get(getProperties(fileName).getProperty("url"));
		return null;
	}

	public static Select pickYourDropdown(String name) {
		element  = driver.findElement(By.cssSelector("select.form-control"));
		select = new Select(element);
		select.selectByVisibleText(name);
		return select;
	}
	public static Select pickYourDropdownBasedOnIndex(int val) {
		element  = driver.findElement(By.cssSelector("select.form-control"));
		select = new Select(element);
		select.selectByIndex(val);
		return select;
	}
	
	public static void performClick(By by) {
		driver.findElement(by).click();
	}
	
	public static void window_handles() {
		String parentTab = driver.getWindowHandle();
		System.out.println("Parent Tab:"+parentTab);
		Set<String>chilTab = driver.getWindowHandles();
		for(String str:chilTab) {
			System.out.println("Child Tab:"+str);
			if (!chilTab.equals(parentTab)) {
				driver.switchTo().window(str);
			}
		}
		System.out.println("Current URL:"+driver.getCurrentUrl());
	}
	
	public static void handle_alert_box(By by) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
		System.out.println("Alert Message:"+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

}
