package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecifications;

public class SignUpPage extends ProjectSpecifications {
	
	@FindBy(id = "firstName")
	WebElement firstname;
	
	@FindBy(id = "lastName")
	WebElement lastname;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "fld-p1")
	WebElement password;
	
	@FindBy(id = "reenterPassword")
	WebElement confirmpassword;
	
	@FindBy(id = "phone")
	WebElement mobilenumber;
	
	@FindBy(xpath = "//button[text()='Create an Account']")
	WebElement submit;
	
	public SignUpPage(WebDriver driver) {
		driver = this.driver;
		PageFactory.initElements(driver, this);
	}
	
	public SignUpPage firstname(String fname) {
		sendkeys(firstname, fname);
		return this;
	}
	public SignUpPage lastname(String lname) {
		sendkeys(lastname, lname);
		return this;
	}
	public SignUpPage email(String mailid) {
		sendkeys(email, mailid);
		return this;
	}
	public SignUpPage password(String pswd) {
		sendkeys(password, pswd);
		sendkeys(confirmpassword, pswd);
		return this;
	}
	public SignUpPage phone(String mnumber) {
		sendkeys(mobilenumber, mnumber);
		return this;
	}
	
	public void submit(String fname) {
		click(submit);
		String expected = driver.findElement(By.xpath("//span[@class='v-p-right-xxs line-clamp']")).getText();
		String actual = "Hi, "+fname+"";
		Assert.assertEquals(expected, actual);
	}

}
