package parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_SeleniumParametersParallel {
	
	WebDriver driver;
	String baseUrl;
	
	@BeforeClass
	@Parameters({"browser","baseUrl"})
	public void setUp(String browser,String baseUrl) {
		//baseUrl = "https://letskodeit.teachable.com";
		//baseUrl = "http://www.google.com";
		if (browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();	
		}
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
			//ChromeOptions options = new ChromeOptions();
			//options.addExtensions(new File("/Users/Parihar08/Library/Application Support/Google/Chrome/Default/Extensions/fhbjgbiflinjbdggehcddcbncdddomop/5.5.3_0.crx"));
			//driver = new ChromeDriver(options);
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@Test
	@Parameters({"emailId","psswd"})
	public void testLogin(String emailId,String psswd) {
		WebElement loginLink = driver.findElement(By.xpath("//a[contains(@href,'/sign_in')]"));
		loginLink.click();
		WebElement email = driver.findElement(By.id("user_email"));
		email.sendKeys(emailId);
		WebElement password = driver.findElement(By.id("user_password"));
		password.sendKeys(psswd);
		WebElement loginButton = driver.findElement(By.name("commit"));
		loginButton.click();
	}

	@AfterClass
	public void cleanUp() {
		driver.quit();
	}

}
