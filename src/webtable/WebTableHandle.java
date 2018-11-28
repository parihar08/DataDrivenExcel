package webtable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTableHandle {

	public static void main(String[] args) {
		WebDriver driver= new FirefoxDriver();	;
		String baseUrl = "https://www.w3schools.com/html/html_tables.asp";
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		//*[@id="customers"]/tbody/tr[7]/td[1]
		
		String beforeXpath_company = "//*[@id='customers']/tbody/tr[";
		String afterXpath_company = "]/td[1]";
		
		String beforeXpath_contact = "//*[@id='customers']/tbody/tr[";
		String afterXpath_contact = "]/td[2]";
		
		String beforeXpath_country = "//*[@id='customers']/tbody/tr[";
		String afterXpath_country = "]/td[3]";
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		System.out.println("Total number of Rows:: "+rows.size());
		int rowCount = rows.size();
		
		for(int i=2;i<=rowCount;i++){
			String actualXpath_company = beforeXpath_company+i+afterXpath_company;
			String companyName = driver.findElement(By.xpath(actualXpath_company)).getText();
			System.out.println("Company Name:: "+companyName);
			System.out.println("<::::::::::::::::::::::::::::::::::::::::::::::::::::::::::>");
			String actualXpath_contact = beforeXpath_contact+i+afterXpath_contact;
			String contact = driver.findElement(By.xpath(actualXpath_contact)).getText();
			System.out.println("Contact Name:: "+contact);
			System.out.println("<::::::::::::::::::::::::::::::::::::::::::::::::::::::::::>");
			String actualXpath_country = beforeXpath_country+i+afterXpath_country;
			String country = driver.findElement(By.xpath(actualXpath_country)).getText();
			System.out.println("Country Name:: "+country);
			System.out.println("<::::::::::::::::::::::::::::::::::::::::::::::::::::::::::>");
			
		}
		driver.quit();
	}

}
