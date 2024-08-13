package vidhyaPrakashAutomation.PageObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemListPage {

	WebDriver driver;
	public ItemListPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = ".a-section.s-title-instructions-style")
	List<WebElement> itemsTitle;
	
	@FindBy(css = ".a-section .puisg-row .a-price-whole")
	List<WebElement> itemsPrice;
	By clickItemPrice = By.cssSelector(".a-section .puisg-row .a-price-whole");
	
	
	
	List<Integer> prices = new ArrayList<Integer>();
	HashSet<Integer> hs = new HashSet<Integer>();
	HashMap<Integer, Integer> hm = new HashMap<>();
	

	
	int price;
	public HashMap<Integer,Integer> getItemPrice(String ItemName) {
		for(int i=0; i<itemsTitle.size();i++) 
		{
			String itemTitle = itemsTitle.get(i).getText();
			if(itemTitle.toLowerCase().contains(ItemName.toLowerCase()))
			{
				String itemPrice = itemsPrice.get(i).getText();
				//String price = itemPrice.replaceAll(",","");
				price = Integer.parseInt(itemPrice.replaceAll(",",""));
//				prices.add(price);
				hs.add(price);
				hm.put(i, price);
			}
			
			
//			System.out.println(itemPrice);
//			System.out.println(price);
//			System.out.println(itmprc);	
		}
		System.out.println(hm);		
//		int min = Collections.min(hm.values());
//		System.out.println(min);
		return hm;
	}
	
	public void getMinPrice(HashMap<Integer,Integer> itemsPrice) {
		// TODO Auto-generated method stub
		
		int minPrice = Collections.min(itemsPrice.values());
		for(Entry<Integer, Integer> entry : itemsPrice.entrySet())
		{
			if(entry.getValue().equals(minPrice)) {
				System.out.println(entry.getKey());
				driver.findElement(clickItemPrice).click();
				break;
			}
			
		}
	}
	
	
//	Stream<String> items = (Stream<String>) itemsTitle;
	public void getItemName(String ItemName) {
			
//			String name =	
					itemsTitle.stream()
//				.map(x -> x.getText().contains(ItemName.toLowerCase()))
				.map(x -> x.getText().toString().toLowerCase())
				.filter(x -> x.contains(ItemName.toLowerCase()))
//				.map(x -> Integer.parseInt(ItemName.replaceAll(",","")))
				.forEach(x -> System.out.println(x));
				
//				.forEach(System.out::println);
				
				
//				.forEach(System.out::println);
//				.map(int t -> t.);
//		System.out.println(name);
	}
	
	
	
	
}
