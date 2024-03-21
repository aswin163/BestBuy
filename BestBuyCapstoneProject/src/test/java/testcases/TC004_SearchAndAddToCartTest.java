package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecifications;
import pages.HomePage;

public class TC004_SearchAndAddToCartTest extends ProjectSpecifications {

	
	@Test
	public void SearchandAddToCart() {
		
		HomePage obj = new HomePage(driver);
		obj.searchandadd().search("samsung galaxy s23");
		obj.addToCart();

	}

}
