package TestCases;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.Test;
import BaseClass.BaseTest;
import Maincodes.MainCodes;

public class TestCases extends BaseTest {
	MainCodes mainCodes;
	DataFormatter formatter = new DataFormatter();

	@Test(priority = 1, dataProvider ="AmazonAndFlipcart")
	public void Flipcart(String search, String ProductName) throws Exception {
		mainCodes = new MainCodes();
		MainCodes.flipcart(search, ProductName);
	}

	@Test(priority = 2, dataProvider ="AmazonAndFlipcart")
	public void Amazon(String search, String productName) throws Exception {

		mainCodes = new MainCodes();
		MainCodes.Amazon(search, productName);
	}

	@Test(priority = 3)
	public void comparePrices() throws Exception {
		mainCodes = new MainCodes();
		mainCodes.CompareValues1();
	}

	@Test(priority = 4, dataProvider ="greenKart")
	public void Greenkart(String productName, String productQuantity) throws Exception {
		mainCodes = new MainCodes();
		mainCodes.greenkart(productName, productQuantity);
		mainCodes.greenkartprice();
	}

	@Test(priority = 5, dataProvider ="bigBasket")
	public void BigBasket(String productName, String productQuantity) throws Exception {
		mainCodes = new MainCodes();
		mainCodes.bigBasket(productName, productQuantity);
		mainCodes.bigbasketprice();
	}

    @Test(priority = 6)
	public void comparePrices1() throws Exception {
		mainCodes = new MainCodes();
		mainCodes.CompareValues2();
	}
}