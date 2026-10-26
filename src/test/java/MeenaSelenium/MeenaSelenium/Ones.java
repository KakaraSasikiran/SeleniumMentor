package MeenaSelenium.MeenaSelenium;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Ones {

	@Test(priority = -2)
	public void testName1() throws Exception {
		System.out.println("Sasi");
	}
	@Test(priority = 0)
	public void testName2() throws Exception {
		System.out.println("Kiran");
	}
	@Test(priority = -1)
	public void testName3() throws Exception {
		System.out.println("Meena");
	}
	@Test(dataProvider = "meena")
	public void testName4(String one,String two) throws Exception {
		System.out.println(one+" "+two);
	}
	@DataProvider(name = "meena")
	public Object[][] datass(){
		return new Object[][] {
			{"ones","two"},
			{"three","four"},
		};
	}
}
