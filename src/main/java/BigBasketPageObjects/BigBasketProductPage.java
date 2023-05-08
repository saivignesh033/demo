package BigBasketPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuseablecodes.ReuseableCodes;

public class BigBasketProductPage extends ReuseableCodes {
	WebDriver driver;

	public BigBasketProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//div[@qa='product_name']//a")
	List<WebElement> productName;
	
	By productWait = By.xpath("//div[@qa='product_name']//a");

	
	public void getProducts() {
		
		waitToClick(productWait);
		for (int i = 0; i < productName.size(); i++) {
			String product = productName.get(i).getText();
			if (product.contains("Carrot - Ooty")) {
				productName.get(i).click();
			}
		}
	}
}
