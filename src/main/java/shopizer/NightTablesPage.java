package shopizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NightTablesPage {

	public NightTablesPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super();
		// this.driver = driver;
	}

	// Locators

	@FindBy(css = "[item-name=\"Compact night table\"]  > div >[class=\"listing-product-name\"]")
	public WebElement compactNightTable;
	
	// locator img from the result page, not used as of now
	// @FindBy(css = "[item-name=\"Compact night table\"] [class=\"thumbnail
	// product-img\"]")
	// public WebElement compactNightTableImg;

	@FindBy(css = "[id=\"productPrice\"] > del")
	public WebElement compactNightTableInitPrice;

	@FindBy(css = "[id=\"productPrice\"] > [class=\"specialPrice\"]")
	public WebElement compactNightTablePromPrice;

	@FindBy(css = "[class=\"sinple-c-title\"] > h3")
	public WebElement compactNightTableName;

	@FindBy(css = "[id=\"productRating\"]")
	public WebElement compactNightTableStars;

	@FindBy(css = "[class=\"btn addToCart addToCartButton btn-buy\"]")
	public WebElement compactNightTableAddToCartBtn;

	// Methods

	public String exractDevise() {
		String price = compactNightTableInitPrice.getText();
		// System.out.println(price.substring(0, 3));
		String devise = price.substring(0, 3);
		return devise;
	}

}
