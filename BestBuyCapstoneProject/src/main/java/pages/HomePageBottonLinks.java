package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecifications;

public class HomePageBottonLinks extends ProjectSpecifications {
	
	@FindBy(className = "us-link")
	WebElement choosecountry;
	
	public HomePageBottonLinks(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void bottomlink() {
		
		click(choosecountry);
		
		List<WebElement> bottomlinks = driver.findElements(By.xpath("//li[@class='body-copy']"));
		
		
		
		
	}
	
}
