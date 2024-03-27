package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecifications;
import pages.HomePage;

public class TC004_SearchAndAddToCartTest extends ProjectSpecifications {

	
	@Test
	public void SearchandAddToCart() {
		
		HomePage obj = new HomePage(driver);
		obj.searchandadd().search("samsung galaxy s23");
		obj.addToCart().addToCartAssertion();


	}

}
