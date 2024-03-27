package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpecifications;
import pages.HomePage;

public class TC007_LinkIsNotBrokenTest extends ProjectSpecifications{
	
	@Test
	public void LinkIsNotBrokenTest() throws IOException {
		
		HomePage obj = new HomePage(driver);
		obj.linkstatuscheck("https://www.bestbuy.com/");

	}

}
