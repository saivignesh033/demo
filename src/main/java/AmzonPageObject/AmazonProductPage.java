package AmzonPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuseablecodes.ReuseableCodes;

public class AmazonProductPage extends ReuseableCodes {
	WebDriver driver;
	
	public AmazonProductPage (WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements( driver, this);
	}
@FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
WebElement clickProduct;

By wait = By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]");



public void clickProduct() {
	waitToClick(wait);
	clickProduct.click();

	
	
}

}
