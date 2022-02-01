package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtilities.ExcelUtility;
import GenericUtilities.FileUtiltiy;
import GenericUtilities.JavaUtility;
import GenericUtilities.WebDriverUtility;

public class CreateOrganization {
	
	public static void main(String[] args) throws Throwable {
		
	  /*Object Creation for Lib*/
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtiltiy fLib = new FileUtiltiy();
		ExcelUtility eLib = new ExcelUtility();
		
		int randomInt = jLib.getRandomNumber();
		
		/*common Data*/
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		/*test script Data*/
		String orgName = eLib.getDataFromExcel("Sheet1", 0, 0) + randomInt;
		String option = eLib.getDataFromExcel("Sheet1", 9, 2);
		
		/* Navigate to app*/
		WebDriver driver = new ChromeDriver();
		wLib.waitUntilPageLoad(driver);
        driver.get(URL);
        Thread.sleep(1000);
        
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        Thread.sleep(1000);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        Thread.sleep(1000);
        driver.findElement(By.id("submitButton")).click();
        
        driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@name='industry']")).sendKeys(option);
        Thread.sleep(1000);
        
	}

}

