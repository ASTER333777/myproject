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

public class CreateContactWithOrgTest 
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
		String CONTACTNAME = fLib.getPropertyKeyValue("contactname");
		
		/*test script Data*/
		
		String organizationName = eLib.getDataFromExcel("Sheet1", 2, 0) +"_"+ jLib.getRandomNumber();
		
		
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
		
		/* Step 3: Navigate to Organization */
		Home ho = new Home(driver);
		ho.getOrganizationLink().click();
		
		/* Step 4: Navigate to Create Organization page */
		Organizations or = new Organizations(driver);
		or.getCreateOrganizationButton().click();
		
		/* Step 5: Create Organization */
		CreateNewOrganization cno = new CreateNewOrganization(driver);
		cno.createOrg(organizationName);
		
		/* Step 6: Verification */
		OrganizationsInfo oi = new OrganizationsInfo(driver);
		wLib.waitForElementVisibility(driver, oi.getSuccessfulMessage());
		String actualSuccessMessage = oi.getSuccessfulMessage().getText();
		
		if(actualSuccessMessage.contains(organizationName))
		  {
			System.out.println("Organization is created Successfully ====> TestCase PASS");
			System.out.println(organizationName);
		  }
		else
		  {
			System.out.println("Organization is not created  ====> TestCase FALI");
		  }
				
     	/*	 Step 6: Navigate to Contact page */
		ho.getContactLink().click();
		
		/* Step 7: Navigate to add Contact page */
		Contacts co = new Contacts(driver);
		co.getCreateContactImage().click();
		
	    /*  Step 8: Create a new Contact */
		CreateNewContact cnc = new CreateNewContact(driver);
		cnc.createContact(CONTACTNAME, organizationName);
		
		/* Step 6: Verify the Contact */
		ContactsInfo ci = new ContactsInfo(driver);
		wLib.waitForElementVisibility(driver, oi.getSuccessfulMessage());
		String actualMessage = ci.getSuccessfulMessage().getText();
		
		if(actualMessage.contains(CONTACTNAME))
		  {
			System.out.println("Contact is created Successfully ====> TestCase PASS");
			System.out.println(CONTACTNAME);
			System.out.println(organizationName);
		  }
		else
		  {
			System.out.println("Contact is not created  ====> TestCase FAIL");
		  }
		
		// Step 7: Verification 
		ho.logout();
		
		 //Step 8: Close the Browser 
		driver.quit();			
	}
}