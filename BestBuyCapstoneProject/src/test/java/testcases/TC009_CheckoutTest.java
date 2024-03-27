package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifications;
import pages.CheckoutPage;
import pages.HomePage;

public class TC009_CheckoutTest extends ProjectSpecifications{
	
	@BeforeTest
	public void setup() {
		excelFile = "TestData";
		excelSheet = 4;
	}
	

	@Test(dataProvider = "readExcel")
	public void CheckOutTest(String fname, String  lname, String email, String phone, String address, String city, String state, String zipcode) throws InterruptedException {
		
		HomePage obj = new HomePage(driver);
		obj.searchandadd().search("samsung galaxy s23");
		obj.addToCart();
		Thread.sleep(3000);
		obj.checkOut().clickcartandcheckout().enterDetails(email, phone);
		
		//The web site doesn't work properly after the above step as it doesn't proceed to next page. If it does, below commented lines will fill out the details in checkout  page
//		CheckoutPage chkobj = new CheckoutPage(driver);
//		chkobj.checkoutdetails(fname, lname, address, city, state, zipcode);

	}

}
