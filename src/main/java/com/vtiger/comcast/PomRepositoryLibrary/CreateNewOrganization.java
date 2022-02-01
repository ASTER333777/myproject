package com.vtiger.comcast.PomRepositoryLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import GenericUtilities.WebDriverUtility;

public class CreateNewOrganization extends WebDriverUtility
  {
	WebDriver driver;
	
    public CreateNewOrganization(WebDriver driver)
	  {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	  }
	  
      @FindBy(name = "accountname")
      private WebElement organizationNameEdit;
      
      @FindBy(name = "industry")
	  private WebElement industriesInfo;

	  @FindBy(xpath="//input[@title='Save [Alt+S]']")
	  private WebElement saveButton;
	  	  
	  public void createOrg(String organizationName)
	    {
		  organizationNameEdit.sendKeys(organizationName);
		  saveButton.click();
	    }
	
	  public void createOrg(String organizationName, String industry)
	    {
		  organizationNameEdit.sendKeys(organizationName, industry);
		  Select s= new Select(industriesInfo);
		  s.selectByVisibleText(industry);
		  saveButton.click();
	  }
}