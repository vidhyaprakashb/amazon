package vidhyaPrakashAutomation.Amazon;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import vidhyaPrakashAutomation.TestComponents.BaseTest;
import vidhyaPrakashAutomation.PageObject.ItemListPage;
import vidhyaPrakashAutomation.PageObject.SearchOrderPage;

public class OrderSearch extends BaseTest{

	public String iPhone_15_Pro = "iphone 15 pro";
	
	@Test
	public void orderSearch() throws Exception {
		initializeWebDriver();
		SearchOrderPage searchOrderPage = new SearchOrderPage(driver);
		Thread.sleep(2000);
		boolean itemName = searchOrderPage.validateItemName();
		assertTrue(itemName);
		searchOrderPage.itemName(iPhone_15_Pro);
		searchOrderPage.clickSearchButton();
		
		
		ItemListPage  itemListPage = new ItemListPage(driver);
		HashMap<Integer,Integer> itemsPrice = itemListPage.getItemPrice(iPhone_15_Pro);
//		List<Integer> itemsPrice = itemListPage.itemPrice(iPhone_15_Pro);
//		itemListPage.getItemName(iPhone_15_Pro);
		itemListPage.getMinPrice(itemsPrice);
		
	}
}
