package FlipcartPageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuseablecodes.ReuseableCodes;

public class FlipCartHomePage extends ReuseableCodes {
	WebDriver driver;

	public FlipCartHomePage(WebDriver driver) throws Exception {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	WebElement close;

	@FindBy(xpath = "//input[@class='_3704LK']")
	WebElement search;

	@FindBy(xpath = "//li[@class='Y5N33s']//a")
	List<WebElement> product;

	By waitProduct = By.xpath("//li[@class='Y5N33s']//a");

	public void clickOnCloseButton() {
		close.click();

	}

	public void productSearch(String name) {
		search.sendKeys(name);

	}

	public void getProducts(String name) throws Exception {
		waitToClick(waitProduct);
		for (WebElement products : product) {
			String names = products.getText();
			if (names.contains(name)) {
				products.click();
				search.click();
				break;

			}
		}
	}
public void removeName() {
	search.clear();
	
}
	}


