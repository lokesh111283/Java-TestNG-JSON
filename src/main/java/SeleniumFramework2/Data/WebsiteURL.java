package SeleniumFramework2.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WebsiteURL {
	
	String urlname;
	
	public String WebsiteURLLoad() throws IOException {
		Properties prop=new Properties();
		FileInputStream fib=new FileInputStream(System.getProperty("user.dir") 
				+ "\\src\\main\\java\\SeleniumFramework2\\Data\\Driver.properties"); 
		prop.load(fib);
		urlname=prop.getProperty("website");
		System.out.println("My value is "+urlname);
		return urlname;
}

}
