package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecifications;
import pages.HomePage;

public class TC006_ShopByBrandTest extends ProjectSpecifications {

	
	@Test
	public void ShopByBrandTest() {
		
		HomePage obj = new HomePage(driver);
		obj.ShopbyBrand().selectitem();
		obj.addToCart().addToCartAssertion();

	}

}
