package BigBasketPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuseablecodes.ReuseableCodes;

public class BigBasketProductDescriptionPage extends ReuseableCodes {
	WebDriver driver;
	

	public BigBasketProductDescriptionPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='_3Yybm']")
	List<WebElement> quantity;
	
	@FindBy(xpath = "//td[@data-qa='productPrice']")
	WebElement price;

	By wait = By.xpath("//div[@class='_3Yybm']");

	public float getPrice(String name) {
		for(int i=0;i<quantity.size();i++) {
			String productPrice = quantity.get(i).getText();
			if(productPrice.contains(name)) {
				waitToClick(wait);
				quantity.get(i).click();
				String price1 = price.getText();
				String[] arr1 = price1.split("Rs");
				String price2 = arr1[1].trim();
				float carootprice = Float.parseFloat(price2);
				return carootprice;
				
	}
			
	
		}
		return 0;
	
		
		
	
		
		
	
	
		

	}
}