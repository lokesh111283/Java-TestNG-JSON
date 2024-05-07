package SeleniumFramework2.Data;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutInfo {
	
	public WebDriver driver;
	
	public LogoutInfo(WebDriver driver)
	{
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//button[normalize-space()='Sign Out']")
	WebElement sign_out;
	
	public void logout() {
		sign_out.click();
		
	}

}
