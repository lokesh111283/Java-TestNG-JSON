package SeleniumFramework2.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginDataFetch {
	
	FileInputStream fis;
	String urlname;
	
	
	@DataProvider(name="cartlogin")
	public  Object[][] loginInfoData() throws IOException{
		System.out.println("I came till data read");
		List<HashMap<String, String>> lgdata =getJSONData();
		System.out.println(lgdata.get(0));
		System.out.println(lgdata.get(1));
		return new Object[][] {{lgdata.get(0)},{lgdata.get(1)}};
	}	
	
		public List<HashMap<String, String>> getJSONData() throws IOException{
			//read json to string
		String jsonContent = 	FileUtils.readFileToString(new File(System.getProperty("user.dir")+
				"\\src\\main\\java\\SeleniumFramework2\\Data\\LoginDetails.json"), 
				StandardCharsets.UTF_8);
		
		//string to Hashmap
		ObjectMapper mapper = new ObjectMapper();
		  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
	      });
		  return data;
		
		}
}
