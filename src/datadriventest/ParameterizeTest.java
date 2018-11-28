package datadriventest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Xls_Reader;

public class ParameterizeTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
		driver = new FirefoxDriver();
		String baseUrl = "https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
		String excelPath = "/Users/Parihar08/Documents/workspace/DataDrivenExcel/src/testdata/HalfEbayTestData.xlsx";
		Xls_Reader reader = new Xls_Reader(excelPath);
		int rowCount = reader.getRowCount("RegTestData");
		reader.addColumn("RegTestData", "Status");
		
		//Parameterization
		for(int rowNum=2; rowNum<=rowCount; rowNum++){
			System.out.println("<===================================================>");
			String firstname = reader.getCellData("RegTestData", "firstname", rowNum);
			System.out.println("Firstname: "+firstname);
			String lastname = reader.getCellData("RegTestData", "lastname", rowNum);
			System.out.println("Lastname: "+lastname);
			String email = reader.getCellData("RegTestData", "email", rowNum);
			System.out.println("Email id: "+email);
			String password = reader.getCellData("RegTestData", "password", rowNum);
			System.out.println("Password: "+password);
			
			driver.findElement(By.name("firstname")).sendKeys(firstname);
			driver.findElement(By.name("lastname")).sendKeys(lastname);
			driver.findElement(By.name("email")).sendKeys(email);
			driver.findElement(By.name("PASSWORD")).sendKeys(password);
			Thread.sleep(3000);
			driver.findElement(By.id("ppaFormSbtBtn")).click();
			Thread.sleep(3000);
			reader.setCellData("RegTestData", "Status", rowNum, "PASS");
			driver.get(baseUrl);
			
		}		
		driver.quit();
	}

}
