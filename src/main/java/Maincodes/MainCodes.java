package Maincodes;

import org.testng.Assert;
import AmzonPageObject.AmazonHomePage;
import AmzonPageObject.AmazonProductDescriptionPage;
import AmzonPageObject.AmazonProductPage;
import BaseClass.BaseTest;
import BigBasketPageObjects.BigBasketHomePage;
import BigBasketPageObjects.BigBasketProductDescriptionPage;
import BigBasketPageObjects.BigBasketProductPage;
import FlipcartPageObjects.FlipCartHomePage;
import FlipcartPageObjects.FlipCartProductDescriptionPage;
import FlipcartPageObjects.FlipCartProductsPage;
import GreenKartPageObjects.GreenKartHomePage;

public class MainCodes extends BaseTest {
	static int flipcartPrice;
	static int Amazonprice;
	int greenKartPrice;
	float bigBaksetprice;

	public static void flipcart(String search, String productName) throws Exception {
		LaunchApplication("FlipCartURL");
		FlipCartHomePage flipcarthomepage = new FlipCartHomePage(driver);
		flipcarthomepage.clickOnCloseButton();
		flipcarthomepage.productSearch(search);

		flipcarthomepage.getProducts(productName);

		FlipCartProductsPage flipcartproductspage = new FlipCartProductsPage(driver);
		try {
			flipcartproductspage.clickOnProduct();
		} catch (Exception e) {
			System.out.println(productName + ":" + "item is not found in flipcart");
		}
		FlipCartProductDescriptionPage flipcartproductdescriptionpage = new FlipCartProductDescriptionPage(driver);
		flipcartPrice = flipcartproductdescriptionpage.getPrice();
		System.out.println("flipcartprice:" + flipcartPrice);
	}

	public static void Amazon(String search, String productName) throws Exception {
		 
		LaunchApplication("AmazonURL");
		AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
		amazonHomePage.searchBox(search);
		amazonHomePage.getProducts(productName);
		AmazonProductPage amazonProductPage = new AmazonProductPage(driver);
		try {
			amazonProductPage.clickProduct();
		} catch (Exception e) {
			System.out.println(productName + ":" + "item is not found in amazon");
		}
		AmazonProductDescriptionPage amazonProductDescription = new AmazonProductDescriptionPage(driver);
		Amazonprice = amazonProductDescription.getPrice();
		System.out.println("amazonprice:" + Amazonprice);

	}

	public void CompareValues1() throws Exception {
		System.out.println(flipcartPrice);
		boolean price = flipcartPrice > Amazonprice;
		Assert.assertEquals(price, true, "Amazon price is higher");

	}

	public void greenkart(String productName, String productquantity) throws Exception {
		LaunchApplication("GreenKartURL");
		GreenKartHomePage greenkartHomePage = new GreenKartHomePage(driver);
		greenkartHomePage.searchProduct(productName);
		greenKartPrice = greenkartHomePage.getPrice(productquantity);
	}

	public void greenkartprice() {

		System.out.println("GreenKartPrice:" + greenKartPrice);
	}

	public void bigBasket(String productName, String productQuanity) throws Exception {
		LaunchApplication("BigBasketURL");
		BigBasketHomePage bigBasketHomePage = new BigBasketHomePage(driver);
		bigBasketHomePage.SearchProduct(productName);
		BigBasketProductPage bigBasketProductPage = new BigBasketProductPage(driver);
		bigBasketProductPage.getProducts();
		BigBasketProductDescriptionPage bigBasketProductDescriptionPage = new BigBasketProductDescriptionPage(driver);
		bigBaksetprice = bigBasketProductDescriptionPage.getPrice(productQuanity);
    }

	public void bigbasketprice() {
		System.out.println("BigBasketPrice:" + bigBaksetprice);
	}

	public void CompareValues2() throws Exception {
		boolean name = greenKartPrice > bigBaksetprice;
		Assert.assertEquals(name, true, "BigBasket price is higher");
	}
}