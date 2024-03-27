package utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.aventstack.extentreports.ExtentTest;

public class Utilities {
	

	public static WebDriver driver;
	public  String excelFile;
	public int excelSheet;
	
	public void browserLaunch(String browser, String url) {
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if (browser.equals("safari")) {
			driver = new SafariDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void sendkeys(WebElement ele, String value) {
		ele.sendKeys(value);
	}
	
	public String[][] readExcel(String excelFile, int  excelSheet) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook("E:\\JAT-Guvi\\BestBuyCapstoneProject\\src\\test\\resources\\"+excelFile+".xlsx");  // Excelfile name will be passed from Testcase as it may differ for each test case
		XSSFSheet sheet = book.getSheetAt(excelSheet); // Sheet number which needs to be read is also passed from testcase as it may differ for each test case
		 
		int rowcount = sheet.getLastRowNum();
		int columncount = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowcount][columncount];
		
		for(int i=1; i<=rowcount; i++) {
			
			XSSFRow row = sheet.getRow(i);
			
			for(int j=0; j<columncount; j++) {
				
				XSSFCell cell = row.getCell(j);
				
				data[i-1][j] = cell.getStringCellValue();
			}
		}
		book.close();
		return data;
	}
	
		public String getScreenshot(String test) throws IOException {
		
		int ranNum = (int) (Math.random() * 9999999 + 1000000);
		
		String path = "E:\\JAT-Guvi\\BestBuyCapstoneProject\\ScreenShot\\"+test+ranNum+".png";
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(source, dest);
		
		return path;
	}
		
		public void closeBrowser() {
			driver.close();
		}

}
