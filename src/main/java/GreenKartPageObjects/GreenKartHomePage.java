package GreenKartPageObjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GreenKartHomePage  {
	WebDriver driver;

	public GreenKartHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='search']")
	WebElement Search;

	@FindBy(xpath = "//h4[@class='product-name']")
	List<WebElement> productName;

	@FindBy(xpath = "//div//p[@class='product-price']")
	List<WebElement> getPrice;


	public String searchProduct(String name) {
		Search.sendKeys(name);
		return name;
	}

	public int getPrice(String name)  {

		for (int i = 0; i < productName.size(); i++) {
			String product = productName.get(i).getText();
			if (product.contains(name)) {
				String Price = getPrice.get(i).getText();
				int productPrice = Integer.parseInt(Price);
				return productPrice;

			}
		}
		return 0;

	}

	

}
