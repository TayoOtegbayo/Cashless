package Cashless;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CashlessTestFramework {

	public WebDriver driver ;
	Properties prop = new Properties();
	static String projectPath = System.getProperty("user.dir");
	static String dataFilePath = System.getProperty("\\src\\Cashless\\CashlessData.properties");

	@Test

	public void launchUrl() throws InterruptedException, IOException {

		FileInputStream input = new FileInputStream("C:\\Users\\tayoo\\eclipse-workspace\\CashlessTuckShop\\src\\Cashless\\CashlessData.properties");
		prop.load(input);

		System.setProperty("webdriver.gecko.driver", "C://Users//tayoo//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
	}

	@Test
	public void login() throws IOException {

		FileInputStream input = new FileInputStream("C:\\Users\\tayoo\\eclipse-workspace\\CashlessTuckShop\\src\\Cashless\\CashlessData.properties");
		prop.load(input);

		driver.findElement(By.name("email")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual = driver.getTitle();
		String expected = "Cashless School";
		Assert.assertEquals(actual, expected);
		
		
	}
	@Test
	public void logOut() {
		driver.findElement(By.xpath("//a[@href='/CashlessSchoolWeb/Account/SignOut']")).click();

	}
	
	

}
