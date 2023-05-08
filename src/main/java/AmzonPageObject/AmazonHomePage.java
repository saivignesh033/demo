package AmzonPageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuseablecodes.ReuseableCodes;

public class AmazonHomePage extends ReuseableCodes {
	WebDriver driver;

	public AmazonHomePage (WebDriver driver) throws Exception {
		super(driver);
	
		this.driver = driver;
		PageFactory.initElements(driver,this);

	}

@FindBy(xpath="//input[@id='twotabsearchtextbox']")
WebElement searchBox;

@FindBy(xpath="//div[@id='nav-flyout-searchAjax']//div[@class='s-suggestion s-suggestion-ellipsis-direction']")
List<WebElement> product;

By waitProduct = By.xpath("//div[@id='nav-flyout-searchAjax']//div[@class='s-suggestion s-suggestion-ellipsis-direction']");
	
	



public void searchBox(String name) {
	searchBox.sendKeys(name);
	
}

public void getProducts(String name) throws Exception {
	Thread.sleep(2000);
   for(WebElement products:product) {
		String names= products.getText();
		if(names.contains(name)) {
			products.click();
			break;
			
		}	
			
   }
	
   }	
   
}

