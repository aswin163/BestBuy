package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecifications;

public class SearchAndAddToCart extends ProjectSpecifications{
	
	@FindBy(id = "gh-search-input")
	WebElement searchbar;
	
	@FindBy(className = "header-search-button")
	WebElement searchbutton;
	
	@FindBy(xpath = "(//button[text()='Add to Cart'])[1]")
	WebElement addtocart;
	
	public SearchAndAddToCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public SearchAndAddToCart search(String searchtext) {
		sendkeys(searchbar, searchtext);
		click(searchbutton);
		driver.findElement(By.xpath("(//a[text()='Samsung - Galaxy S23 128GB (Unlocked) - Phantom Black'])[1]")).click();
		return this;
	}

}
