package datadriventest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) throws InterruptedException {
		
		String excelPath = "/Users/Parihar08/Documents/workspace/DataDrivenExcel/src/testdata/HalfEbayTestData.xlsx";
		Xls_Reader reader = new Xls_Reader(excelPath);
		
		String firstname = reader.getCellData("RegTestData", "firstname", 2);
		System.out.println(firstname);
		
		String lastname = reader.getCellData("RegTestData", "lastname", 2);
		System.out.println(lastname);
		
		String email = reader.getCellData("RegTestData", "email", 2);
		System.out.println(email);
		
		String password = reader.getCellData("RegTestData", "password", 2);
		System.out.println(password);
		
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
		driver = new FirefoxDriver();
		String baseUrl = "https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("PASSWORD")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.id("ppaFormSbtBtn")).click();
		driver.quit();
		
		
		
	}

}
