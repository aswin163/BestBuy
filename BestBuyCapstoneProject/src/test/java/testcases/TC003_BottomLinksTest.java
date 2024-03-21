package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecifications;
import pages.HomePageBottonLinks;

public class TC003_BottomLinksTest extends ProjectSpecifications{

	
	@Test
	public void BottomLinksTest() {
		
		HomePageBottonLinks obj = new HomePageBottonLinks(driver);
		obj.bottomlink();

	}

}
