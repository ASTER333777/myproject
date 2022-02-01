package com.crm.comcast.ContactTest;

import org.testng.annotations.Test;

import com.vtiger.comcast.PomRepositoryLibrary.Contacts;
import com.vtiger.comcast.PomRepositoryLibrary.ContactsInfo;
import com.vtiger.comcast.PomRepositoryLibrary.CreateNewContact;
import com.vtiger.comcast.PomRepositoryLibrary.CreateNewOrganization;
import com.vtiger.comcast.PomRepositoryLibrary.Home;
import com.vtiger.comcast.PomRepositoryLibrary.Organizations;
import com.vtiger.comcast.PomRepositoryLibrary.OrganizationsInfo;

import GenericUtilities.BaseClass;
import GenericUtilities.FileUtiltiy;

public class CreateContactWithOrgTestNGTest extends BaseClass
  {
	@Test(groups = {"SMOKE TEST"})
    public void CreateContactTest() throws Throwable
    {  
		String ContactName = eLib.getDataFromExcel("Sheet1", 2, 0);
		
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
    }
	
	@Test(groups = {"REGRESSION TEST"})
    public void CreateContactwithOrgTest() throws Throwable
    {  
		String ContactName = eLib.getDataFromExcel("Sheet1", 2, 0);
		String organizationName = eLib.getDataFromExcel("Sheet1", 2, 0) +"_"+ jLib.getRandomNumber();
		
		Home ho = new Home(driver);
		ho.getOrganizationLink().click();
		
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
		cnc.createContact(ContactName, organizationName);
		
		/* Step 6: Verify the Contact */
		ContactsInfo ci = new ContactsInfo(driver);
		wLib.waitForElementVisibility(driver, oi.getSuccessfulMessage());
		String actualMessage = ci.getSuccessfulMessage().getText();
		
		if(actualMessage.contains(ContactName))
		  {
			System.out.println("Contact is created Successfully ====> TestCase PASS");
			System.out.println(ContactName);
			System.out.println(organizationName);
		  }
		else
		  {
			System.out.println("Contact is not created  ====> TestCase FAIL");
		  }
	
	}
}
		
		