package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.ProjectSpecifications;

public class CheckoutPage extends ProjectSpecifications {
	
	@FindBy(xpath = "//span[@class='cart-label']")
	WebElement cart;
	
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkout;
	
	@FindBy(xpath = "//button[text()='Continue as Guest']")
	WebElement continueasguest;
	
	@FindBy(id = "user.emailAddress")
	WebElement email;
	
	@FindBy(id = "user.phone")
	WebElement phonenumber;
	
	@FindBy(xpath = "//span[text()='Continue to Payment Information']")
	WebElement continuetopay;
	
	@FindBy(id = "first-name")
	WebElement firstname;
	
	@FindBy(id = "last-name")
	WebElement lastname;
	
	@FindBy(id = "address-input")
	WebElement address;
	
	@FindBy(id = "city")
	WebElement city;
	
	@FindBy(id ="state")
	WebElement state;
	
	@FindBy(id = "postalCode")
	WebElement zipcode;
	
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public CheckoutPage clickcartandcheckout() {
		click(cart);
		click(checkout);
		click(continueasguest);
		return this;
	}
	
	public CheckoutPage enterDetails(String mailid, String phone)  {
		
		String expected = "Order Summary";
		String actual = driver.findElement(By.xpath("//span[text()='Order Summary']")).getText();
		Assert.assertEquals(expected, actual);
		sendkeys(email, mailid);
		sendkeys(phonenumber, phone);
//		click(continuetopay);
		return this;
		
	}
	
	public void checkoutdetails(String fname, String lname, String add, String dist, String province, String postcode) {
		sendkeys(firstname, fname);
		sendkeys(lastname, lname);
		sendkeys(address, add);
		sendkeys(city, dist );
		Select obj = new Select(state);
		obj.selectByVisibleText(province);
		sendkeys(zipcode, postcode);
	}
	
	

}
