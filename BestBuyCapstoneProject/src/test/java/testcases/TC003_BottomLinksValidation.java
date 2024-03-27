package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifications;
import pages.HomePage;

public class TC003_BottomLinksValidation extends ProjectSpecifications {
	
	@BeforeTest
	public void setup() {
		excelFile = "TestData";
		excelSheet = 3;
	}

	@Test(dataProvider = "readExcel")
	public void BottonLinksValidation(String link, String expTitle) {
		
		HomePage obj = new HomePage(driver);
		obj.bottomLinksValidation(link, expTitle);

	}

}
