package FlipcartPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuseablecodes.ReuseableCodes;

public class FlipCartProductsPage extends ReuseableCodes {
	WebDriver driver;

	public FlipCartProductsPage(WebDriver driver) throws Exception {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//div[@class='_4rR01T'])[3]")
	WebElement clickOnProduct;

	By product = By.xpath("(//div[@class='_4rR01T'])[3]");

	public void clickOnProduct() {
		waitToClick(product);
		clickOnProduct.click();

	}
	
	public void parentWindow() {
		parentWindows();
	}
}