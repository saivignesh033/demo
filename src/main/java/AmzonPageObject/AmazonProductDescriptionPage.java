package AmzonPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuseablecodes.ReuseableCodes;

public class AmazonProductDescriptionPage extends ReuseableCodes {
	WebDriver driver;

	public AmazonProductDescriptionPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[@class='a-price-whole'])[5]")
	WebElement getPrice;

	public int getPrice() {
		childWindows();
		String price = getPrice.getText();
		String[] price1 = price.split(",");
		String price2 = price1[0] + price1[1].trim();

		int price3 = Integer.parseInt(price2);
		return price3;
	}
}
