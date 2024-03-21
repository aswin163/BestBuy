package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecifications;


public class HomePage extends ProjectSpecifications {
	
	@FindBy(className = "us-link")
	WebElement choosecountry;
	
	@FindBy(xpath = "//span[text()='Account']")
	WebElement account;
	
	@FindBy(xpath = "//button[@class='c-button-unstyled hamburger-menu-button']")
	WebElement menu;
	
	@FindBy(xpath = "//a[@class='c-button c-button-outline c-button-sm create-account-btn']")
	WebElement signup;
	
	@FindBy(xpath = "//a[@class='c-button c-button-secondary c-button-sm sign-in-btn']")
	WebElement login;
	
	@FindBy(xpath = "(//button[text()='Add to Cart'])[1]")
	WebElement addtocart;
	
	public HomePage(WebDriver driver) {
		driver = this.driver;
		PageFactory.initElements(driver, this);
		click(choosecountry);
	}
	
	public SignUpPage signup() {
		click(account);
		click(signup);
		return new SignUpPage(driver);
	}
	
	public LoginPage login() {
		click(account);
		click(login);
		return new LoginPage(driver);
	}
	
	public void addToCart() {
		click(addtocart);
	}
	
	public SearchAndAddToCart searchandadd() {
		return new SearchAndAddToCart(driver);
	}
	
	public ShopByDepartment shopbydepartment() {
		click(menu);
		return new ShopByDepartment(driver);
	}
	
	public ShopByBrand ShopbyBrand() {
		click(menu);
		return new ShopByBrand(driver);
	}

}
