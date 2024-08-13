package vidhyaPrakashAutomation.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchOrderPage {

	WebDriver driver;
	public SearchOrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement orderSearchField;
	
	@FindBy(id = "nav-search-submit-button")
	WebElement searchButton;
	
	public boolean validateItemName() {
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		return orderSearchField.isDisplayed();
		
	}
	
	public void itemName(String name) {
		orderSearchField.sendKeys(name);
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	public ItemListPage getItemList() {
		return new ItemListPage(driver);
	}
	
}
