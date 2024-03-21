package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	 public LoginPage submit() {
		 click(signinbutton);
		 return this;
	 }

}
