package SeleniumFramework2.Data;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginInfo {
	
	WebDriver driver;
	String urlname;
	
	public LoginInfo(WebDriver driver)
	{
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement pwd;
	
	@FindBy(id="login")
	WebElement login_web;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormsg;
	

	public void Login(String user_name,String user_pwd) throws IOException {
		System.out.println("I came hereee in login");	
		System.out.println(user_name+"anddddddddddd"+user_pwd);
		username.clear();
		username.sendKeys(user_name);
		pwd.clear();
		pwd.sendKeys(user_pwd);
		login_web.click();
		System.out.println("I have ended");
	}
	
/*	public void waitforWebElementToAppear(WebElement findBy) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}  */
	
	public String geterrormsg() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return errormsg.getText();
	}
	

}
