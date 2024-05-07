package ExtentReports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Screenshot {
	
	//WebDriver driver;

	public String getScreenshot(String testcasename,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"//reports//"+testcasename+".png");
		FileUtils.copyFile(source, dest);
		return System.getProperty("user.dir")+"//reports//"+testcasename+".png";
	
		
	}
	

}
