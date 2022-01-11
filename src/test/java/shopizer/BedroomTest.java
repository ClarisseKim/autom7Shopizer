package shopizer;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BedroomTest {

	WebDriver driver;
	WebDriverWait wait;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
		// String browser = System.getProperty("browser");
		// driver = new ChromeDriver();
		driver = new FirefoxDriver();

		/*
		 * if (browser.equalsIgnoreCase("Firefox")) {
		 * System.setProperty("WebDriver.gecko.driver",
		 * "src/main/resources/driver/geckodriver.exe"); driver = new FirefoxDriver(); }
		 * 
		 * else if (browser.equalsIgnoreCase("Chrome")) {
		 * System.setProperty("WebDriver.chrome.driver",
		 * "src/main/resources/driver/chromedriver.exe"); driver = new ChromeDriver(); }
		 * 
		 * else if (browser.equalsIgnoreCase("IE")) {
		 * System.setProperty("WebDriver.ie.driver",
		 * "src/main/resources/driver/IEDriverServer.exe"); driver = new
		 * InternetExplorerDriver(); }
		 * 
		 * else { System.setProperty("webdriver.chrome.driver",
		 * "src/main/resources/driver/chromedriver.exe"); driver = new ChromeDriver(); }
		 */
		driver.manage().window().maximize();
	}

	@Test
	public void run() {
		driver.get("http://192.168.0.11:8080/shop");

		HomePage homePage = new HomePage(driver);
		NightTablesPage nightTablesPage = new NightTablesPage(driver);

		homePage.openTablePage();
		
		assertEquals(true, nightTablesPage.compactNightTableInitPrice.isDisplayed());
		boolean result2 = nightTablesPage.compactNightTableInitPrice.isDisplayed();
		System.out.println("Status of Compact Night Table is" + result2);
		
		assertEquals(true, nightTablesPage.compactNightTablePromPrice.isDisplayed());
		boolean result3 = nightTablesPage.compactNightTablePromPrice.isDisplayed();
		System.out.println("Status of Compact Night Table is" + result3);
		
		assertEquals(true, nightTablesPage.compactNightTableName.isDisplayed());
		boolean result4 = nightTablesPage.compactNightTableName.isDisplayed();
		System.out.println("Status of Compact Night Table is" + result4);
		
		assertEquals(true, nightTablesPage.compactNightTableStars.isDisplayed());
		boolean result5 = nightTablesPage.compactNightTableStars.isDisplayed();
		System.out.println("Status of Compact Night Table is" + result5);
		
		assertEquals(true, nightTablesPage.compactNightTableAddToCartBtn.isDisplayed());
		boolean result6 = nightTablesPage.compactNightTableAddToCartBtn.isDisplayed();
		System.out.println("Status of Compact Night Table is" + result6);
		
		String devise = nightTablesPage.exractDevise();
		assertEquals(devise, "US$");
		System.out.println("devise is" + devise);
		
	}

	@After
	public void teardown() {
		// driver.quit();

	}

}
