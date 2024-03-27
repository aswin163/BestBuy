package pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
	
	public HomePage addToCart() {
		Actions action = new Actions(driver);
		action.scrollToElement(addtocart);
		click(addtocart);
		return this;
	}
	
	
	public void addToCartAssertion() {
		WebElement ele = driver.findElement(By.xpath("//span[text()='Frequently bought together ']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		String expected = "Added to cart";
		String actual = driver.findElement(By.xpath("//span[@class='added-to-cart']")).getText();
		Assert.assertEquals(expected, actual);
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
	
	public void linkstatuscheck(String url) throws IOException {
		
		URL link = new URL(url);
		HttpURLConnection connect = (HttpURLConnection) link.openConnection();
		int responsecode = connect.getResponseCode();
		int expectedcode = 200;
		Assert.assertEquals(responsecode, expectedcode);
	}
	
	public void menuValidation(String menu, String expTitle) {
		click(driver.findElement(By.xpath("//a[text()='"+menu+"']")));
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expTitle);
	}
	
	public void bottomLinksValidation(String link, String expectedTitle) {
		click(driver.findElement(By.xpath("//a[text()='"+link+"']")));
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	public CheckoutPage checkOut() {
		return new CheckoutPage(driver);
	}

}
