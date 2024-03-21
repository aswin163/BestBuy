package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecifications;

public class ShopByBrand extends ProjectSpecifications{
	
	@FindBy(xpath = "//button[text()='Brands']")
	WebElement brands;
	
	@FindBy(xpath = "//a[text()='Sony']")
	WebElement sony;
	
	@FindBy(xpath = "(//a[text()='PlayStation'])[2]")
	WebElement playstation;
	
	@FindBy(xpath = "//a[text()='PS5 consoles']")
	WebElement ps5consoles;
	
	
	public ShopByBrand(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ShopByBrand selectitem() {
		click(brands);
		click(sony);
		click(playstation);
		click(ps5consoles);
		driver.findElement(By.xpath("(//h4[@class='sku-title '])[1]")).click();
		return this;
	}

}
