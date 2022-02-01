package com.crm.concast.orgTest;

import org.testng.annotations.Test;

import com.vtiger.comcast.PomRepositoryLibrary.CreateNewOrganization;
import com.vtiger.comcast.PomRepositoryLibrary.Home;
import com.vtiger.comcast.PomRepositoryLibrary.Organizations;
import com.vtiger.comcast.PomRepositoryLibrary.OrganizationsInfo;

import GenericUtilities.BaseClass;

public class CreateOrgWithIndustNameTestNGTest extends BaseClass
  {
	@Test(groups = {"SMOKE TEST"})
    public void CreateOrgTest() throws Throwable
      {  
		/*test script Data*/
    	String organizationName = eLib.getDataFromExcel("Sheet1", 2, 0) +"_"+ jLib.getRandomNumber();
    	
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
		System.out.println(actualSuccessMessage);
		if(actualSuccessMessage.contains(organizationName))
		  {
			System.out.println("Organization is created Successfully ====> TestCase PASS");
		  }
		else
		  {
			System.out.println("Organization is not created  ====> TestCase FALI");
		  }
      }
	
	@Test(groups = {"REGRESSION TEST"})
	public void createOrgWithIndutriesTest() throws Throwable 
	  {
		/*test script Data*/
		String organizationName = eLib.getDataFromExcel("Sheet1", 2, 0) +"_"+ jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("Sheet1", 10, 2);
		
		/* Step 3: Navigate to Organization */
		Home ho = new Home(driver);
		ho.getOrganizationLink().click();
		
		/* Step 4: Navigate to Create Organization page */
		Organizations or = new Organizations(driver);
		or.getCreateOrganizationButton().click();
		
		/* Step 5: Create Organization */
		CreateNewOrganization cno = new CreateNewOrganization(driver);
		cno.createOrg(organizationName, industry);
		
		/* Step 6:Verify the Organization details */
		OrganizationsInfo oi = new OrganizationsInfo(driver);
		wLib.waitForElementVisibility(driver, oi.getSuccessfulMessage());
		String actualSuccessMessage = oi.getSuccessfulMessage().getText();
		
		if(actualSuccessMessage.contains(organizationName))
		  {
			System.out.println("Organization is created Successfully ====> TestCase PASS");
			System.out.println(organizationName);
			System.out.println(industry);
		  }
		else
		  {
			System.out.println("Organization is not created  ====> TestCase FALI");
		  }
	 }     
}
