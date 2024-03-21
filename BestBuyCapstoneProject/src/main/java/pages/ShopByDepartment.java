package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecifications;

public class ShopByDepartment extends ProjectSpecifications {
	
	@FindBy(xpath = "//button[@class='c-button-unstyled hamburger-menu-button']")
	WebElement menu;
	
	@FindBy(xpath = "//button[text()='TV & Home Theater']")
	WebElement tvandhometheater;
	
	public ShopByDepartment(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ShopByDepartment shopbydept() {
		
		click(tvandhometheater);
		driver.findElement(By.xpath("//button[text()='TVs by Size']")).click();
		driver.findElement(By.xpath("//a[text()='75-Inch TVs']")).click();
		return this;
	}
	
	public ShopByDepartment selectitem() {
		driver.findElement(By.xpath("//a[text()='Samsung - 77” Class S89C OLED 4K UHD Smart Tizen TV']")).click();	
		return this;
	}

}
