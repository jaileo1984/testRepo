package foo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AppTest{
	
	
	public static WebDriver driver = new FirefoxDriver();

//	@BeforeSuite
//	public void setup(){
//		
//		driver= new FirefoxDriver();
//		
//		
//	}
	
	@Test
	public void login(){
		
		driver.get("http://gmail.com");
	}
	
	@AfterSuite
	public void tearDown(){
		
		driver.close();
	}
	
	
	
	
	
	
}