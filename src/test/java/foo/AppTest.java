package foo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AppTest{
	
	
	public static WebDriver driver ;

	@BeforeSuite
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium\\chromedriver.exe");
		
		driver= new ChromeDriver();
		
	
	}
	
	@Test
	public void login(){
		
		driver.get("http://google.com");
		
		
	
		System.out.println("Insie login page");
		
		Assert.assertEquals(driver.getTitle(), "Google");
	}
	
	@AfterSuite
	public void tearDown(){
		
		driver.close();
	}
	
	
	
	
	
	
}