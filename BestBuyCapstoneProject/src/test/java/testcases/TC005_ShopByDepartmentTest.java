package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecifications;
import pages.HomePage;

public class TC005_ShopByDepartmentTest extends ProjectSpecifications {

	
	@Test
	public void Shopbydept() {
		
		HomePage obj = new HomePage(driver);
		obj.shopbydepartment().shopbydept().selectitem();
		obj.addToCart().addToCartAssertion();

	}

}
