package MeenaSelenium.MeenaSelenium;

public class Meena extends App {

	public static void main(String[] args) {
		optBrowser("three");
		MeenaHome home = new MeenaHome(driver);
		home.clickAlert();
		
	}

}
