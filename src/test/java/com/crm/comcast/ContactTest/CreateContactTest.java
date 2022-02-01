package com.crm.comcast.ContactTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.vtiger.comcast.PomRepositoryLibrary.Contacts;
import com.vtiger.comcast.PomRepositoryLibrary.ContactsInfo;
import com.vtiger.comcast.PomRepositoryLibrary.CreateNewContact;
import com.vtiger.comcast.PomRepositoryLibrary.CreateNewOrganization;
import com.vtiger.comcast.PomRepositoryLibrary.Home;
import com.vtiger.comcast.PomRepositoryLibrary.Login;
import com.vtiger.comcast.PomRepositoryLibrary.Organizations;
import com.vtiger.comcast.PomRepositoryLibrary.OrganizationsInfo;

import GenericUtilities.ExcelUtility;
import GenericUtilities.FileUtiltiy;
import GenericUtilities.JavaUtility;
import GenericUtilities.WebDriverUtility;

public class CreateContactTest 
  {
	public static void main(String[] args) throws Throwable 
	  {
		/* Object Creation */
		JavaUtility jLib = new JavaUtility();            
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtiltiy fLib = new FileUtiltiy();
		ExcelUtility eLib = new ExcelUtility();
		WebDriver driver = null;
			
		/* read the common Data */
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		String ContactName = eLib.getDataFromExcel("Sheet1", 2, 0);
		
		
		/* Step 1: Launch the Browser */
		if(BROWSER.equals("firefox"))
		  {
			driver = new FirefoxDriver();
		  }
		else if(BROWSER.equals("chrome"))
		  {
		 	driver = new ChromeDriver();
		  }
		else if(BROWSER.equals("ie"))
		  {
			driver = new InternetExplorerDriver();
		  }
		else
		  {
			driver = new ChromeDriver();
		  }
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/* Step 2: Login to the Application */
		driver.get(URL);
		wLib.waitUntilPageLoad(driver);
		Login lg = new Login(driver);
		lg.loginToApp(USERNAME, PASSWORD);
		
		/* Step 3: Navigate to Contacts */
		Home ho = new Home(driver);
		ho.getContactLink().click();
		
		/* Step 4: Navigate to Contact page */
		Contacts co = new Contacts(driver);
		co.getCreateContactImage().click();
		
		/* Step 5: Create a new Contact */
		CreateNewContact cnc = new CreateNewContact(driver);
		cnc.getLastNameEdit().sendKeys(ContactName);
		cnc.getSaveButton().click();
		
		/* Step 6: Verify the Contact */
		ContactsInfo ci = new ContactsInfo(driver);
		String actualMessage = ci.getSuccessfulMessage().getText();
		if(actualMessage.contains(ContactName))
		  {
			System.out.println("Contact is verified Successfully ====> TestCase PASS");
			System.out.println(ContactName);
		  }
		else
		  {
			System.out.println("Contact is not verified  ====> TestCase FAIL");
		  }
		
		/* Step 7: Verification */
		ho.logout();
		
		/* Step 8: Close the Browser */
		driver.quit();			
	}
}