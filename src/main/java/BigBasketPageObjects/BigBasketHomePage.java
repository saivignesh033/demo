package BigBasketPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuseablecodes.ReuseableCodes;

public class BigBasketHomePage extends ReuseableCodes {
	WebDriver driver;

	public BigBasketHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Search for Products..']")
	WebElement search;

	@FindBy(xpath = "(//div[@class='view-all'])[1]")
	WebElement ViewAll;

	@FindBy(xpath = "//div[@class='_3Yybm']")
	List<WebElement> price;

	By ViewAllWait = By.xpath("(//div[@class='view-all'])[1]");

	public void SearchProduct(String name) {
		search.sendKeys(name);
		waitToClick(ViewAllWait);
		ViewAll.click();

	}

}
