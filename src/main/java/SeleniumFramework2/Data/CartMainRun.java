package SeleniumFramework2.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ExtentReports.Retry;

import org.testng.Assert;


public class CartMainRun {
	
	public WebDriver driver;
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	String urlname;
	String browserName;
	
	
	@BeforeClass
	public void PreRun() throws IOException {
		System.out.println("I am in cart2");
		DriverInfo di=new DriverInfo();
		driver=di.initializeDriver();
		WebsiteURL web=new WebsiteURL();
		String urlname=web.WebsiteURLLoad();
		System.out.println(urlname);
		driver.get(urlname);
	}
	
	@Test(dataProvider ="cartlogin", dataProviderClass = LoginDataFetch.class, retryAnalyzer = Retry.class)
	public void CartMainRun(HashMap<String, String> input) throws IOException, InterruptedException {	
		//WebsiteURL web=new WebsiteURL();
		//String urlname=web.WebsiteURLLoad();
		//System.out.println(urlname);
		//driver.get(urlname);
		LoginInfo lg=new LoginInfo(driver);
		lg.Login(input.get("email"),input.get("password"));
		System.out.println("My value isssssssssss"+lg.geterrormsg());
		Assert.assertEquals("Login Successfully",lg.geterrormsg());
		System.out.println("I came after assert");
		Thread.sleep(2000);
		System.out.println("I came in logout method");
		LogoutInfo lgout=new LogoutInfo(driver);
		lgout.logout();
		
	}
		
}
