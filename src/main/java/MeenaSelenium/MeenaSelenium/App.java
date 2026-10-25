package MeenaSelenium.MeenaSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 */
public class App {
	private static Properties properties;
	private static FileInputStream fileInputStream;
	public static WebDriver driver;

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
	
}
