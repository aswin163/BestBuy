package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecifications;

public class LoginPage extends ProjectSpecifications{
	
	@FindBy(xpath = "//a[@class='c-button c-button-secondary c-button-sm sign-in-btn']")
	WebElement login;
	
	@FindBy(id = "fld-e")
	WebElement email;
	
	@FindBy(id = "fld-p1")
	WebElement password;
	
	@FindBy(xpath = "//button[contains(text(),\"Sign In\")]")
	WebElement signinbutton;
	
	@FindBy(xpath = "//button[@class='c-button-link cia-cancel']")
	WebElement skiprecoveryphonenumber;
	
	public LoginPage(WebDriver driver) {
		driver=this.driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage email(String mailid) {
		sendkeys(email, mailid);
		return this;
	}
	
	public LoginPage password(String pswd) {
		sendkeys(password, pswd);
		return this;
	}
	 public LoginPage submit(String firstname) {
		 click(signinbutton);
//		 click(skiprecoveryphonenumber);
		 String expected = driver.findElement(By.xpath("//span[@class='v-p-right-xxs line-clamp']")).getText();
		 String actual = "Hi, "+firstname+"";
		 Assert.assertEquals(expected, actual);
		 return this;
	 }

}
