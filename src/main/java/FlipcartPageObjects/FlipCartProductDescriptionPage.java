package FlipcartPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuseablecodes.ReuseableCodes;

public class FlipCartProductDescriptionPage extends ReuseableCodes {
	WebDriver driver;

	public FlipCartProductDescriptionPage(WebDriver driver) throws Exception {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='_30jeq3 _16Jk6d']")
	WebElement getPrice;

	public int getPrice() {
		childWindows();
		String price = getPrice.getText();
		String[] price1 = price.split("₹");
		String[] price2 = price1[1].split(",");
		String price3 = price2[0]+ price2[1].trim();
		
		int price4 = Integer.parseInt(price3);
		return price4;
	}
	public void closeWindow() {
		driver.close();
	}
	


}
