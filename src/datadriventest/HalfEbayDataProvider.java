package datadriventest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.TestUtil;

public class HalfEbayDataProvider {

	WebDriver driver;
	String baseUrl = "https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F";
	
	@BeforeClass
	public void setUp(){
		System.out.println("\nTestNG_HalfEbayDataProvider -->This runs once before every method");
		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
		driver = new FirefoxDriver();	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator(); //It will iterate each and every element of ArrayList(firstname,lastname,email,password) in a sequence
	}
	
	@Test(dataProvider="getTestData")
	public void halfEbayRegPage(String firstname,String lastname,String email,String password) throws InterruptedException{
		
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("PASSWORD")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.id("ppaFormSbtBtn")).click();
		Thread.sleep(3000);
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void cleanUp() {
		System.out.println("\nTestNG_HalfEbayDataProvider -->This runs once after class");
		driver.quit();
	}
	

}
