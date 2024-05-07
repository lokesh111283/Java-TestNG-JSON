package SeleniumFramework2.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInfo1 {
	
	public WebDriver driver;
	String browserName;


	public  WebDriver initializeDriver() throws IOException {
		System.out.println("I am in driver method");
		Properties prop=new Properties();
		FileInputStream fid=new FileInputStream(System.getProperty("user.dir") 
				+ "\\src\\main\\java\\SeleniumFramework2\\Data\\Driver.properties"); 
		prop.load(fid);
		String browserName = System.getProperty("browser1")!=null ? System.getProperty("browser1") :prop.getProperty("browser1");
		// browserName =prop.getProperty("browser1");
		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));// full screen

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/rahulshetty//documents//geckodriver");
			driver = new FirefoxDriver();
			// Firefox } else if (browserName.equalsIgnoreCase("edge")) { // Edge
			System.setProperty("webdriver.edge.driver", "edge.exe");
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}

}
