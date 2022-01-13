package shopizer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShopizerCatTest {

	WebDriver driver;
	WebDriverWait wait;
	Logger LOGGER = LoggerFactory.getLogger(ShopizerCatTest.class);

	@Before
	public void setUp() throws Exception {
		// System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
		String browser = System.getProperty("browser");
		// driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		// driver = new InternetExplorerDriver();

		if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("WebDriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("WebDriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("WebDriver.ie.driver", "src/main/resources/driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		else {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
	}

	@Test
	public void run() {
		driver.get("http://192.168.0.11:8080/shop");

		HomePage homePage = new HomePage(driver);
		NightTablesPage nightTablesPage = new NightTablesPage(driver);
		TablesPage tablesPage = new TablesPage(driver);
		CoffeeTablePage coffeetablePage = new CoffeeTablePage(driver);

		homePage.openNightTablesPage();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			LOGGER.info("");
			e.printStackTrace();
		}

		// can't make it work
		// wait.until(ExpectedConditions.visibilityOf(nightTablesPage.compactNightTableInitPrice));
		assertEquals(true, nightTablesPage.compactNightTableInitPrice.isDisplayed());
		boolean result2 = nightTablesPage.compactNightTableInitPrice.isDisplayed();
		LOGGER.info("Price is " + result2);

		assertEquals(true, nightTablesPage.compactNightTablePromPrice.isDisplayed());
		boolean result3 = nightTablesPage.compactNightTablePromPrice.isDisplayed();
		LOGGER.info("Promotional price is " + result3);

		assertEquals(true, nightTablesPage.compactNightTableName.isDisplayed());
		boolean result4 = nightTablesPage.compactNightTableName.isDisplayed();
		LOGGER.info("Name is " + result4);

		assertEquals(true, nightTablesPage.compactNightTableStars.isDisplayed());
		boolean result5 = nightTablesPage.compactNightTableStars.isDisplayed();
		LOGGER.info("Rating is " + result5);

		assertEquals(true, nightTablesPage.compactNightTableAddToCartBtn.isDisplayed());
		boolean result6 = nightTablesPage.compactNightTableAddToCartBtn.isDisplayed();
		LOGGER.info("Add to cart button is " + result6);

		String devise = nightTablesPage.exractDevise();
		assertEquals("US$", devise);
		LOGGER.info("Devise is " + devise);

		homePage.openTablesPage();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HashSet<String> beforeProducts = new HashSet<String>();
		for (int i = 0; i < tablesPage.products.size(); i++) {
			String text = tablesPage.products.get(i).getText();
			beforeProducts.add(text);
		}

		LOGGER.info("Before applying filter " + beforeProducts);

		tablesPage.clickAsianWoodFilter();

		String asianWoodFilterExtractText = tablesPage.asianWoodFilter();
		assertEquals(" Asian Wood", asianWoodFilterExtractText);
		LOGGER.info("Filter is" + asianWoodFilterExtractText);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HashSet<String> afterProducts = new HashSet<String>();
		for (int i = 0; i < tablesPage.products.size(); i++) {
			String text = tablesPage.products.get(i).getText();
			afterProducts.add(text);
		}

		LOGGER.info("After applying filter " + afterProducts);

		assertNotEquals(beforeProducts, afterProducts);

		LOGGER.info("Is list of products before and after filter equal : " + beforeProducts.equals(afterProducts));

		assertTrue(beforeProducts.containsAll(afterProducts));

		LOGGER.info("Is list of products after filter present in list before filter : "
				+ beforeProducts.containsAll(afterProducts));

		///

		tablesPage.openCoffeTablePage();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			LOGGER.info("");
			e.printStackTrace();
		}

		assertEquals(true, coffeetablePage.coffeeTablePrice.isDisplayed());
		boolean result7 = coffeetablePage.coffeeTablePrice.isDisplayed();
		LOGGER.info("Price is " + result7);

		assertEquals(true, coffeetablePage.coffeeTableName.isDisplayed());
		boolean result9 = coffeetablePage.coffeeTableName.isDisplayed();
		LOGGER.info("Name is " + result9);

		assertEquals(true, coffeetablePage.coffeeTableStars.isDisplayed());
		boolean result10 = coffeetablePage.coffeeTableStars.isDisplayed();
		LOGGER.info("Rating is " + result10);

		assertEquals(true, coffeetablePage.coffeeTableAddToCartBtn.isDisplayed());
		boolean result11 = coffeetablePage.coffeeTableAddToCartBtn.isDisplayed();
		LOGGER.info("Add to cart button is " + result11);

		String devise2 = coffeetablePage.exractDeviseCoffeeTable();
		assertEquals("US$", devise2);
		LOGGER.info("Devise is " + devise2);
	}

	@After
	public void teardown() {
		driver.quit();

	}

}
