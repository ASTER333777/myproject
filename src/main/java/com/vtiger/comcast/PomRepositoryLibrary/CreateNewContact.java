package com.vtiger.comcast.PomRepositoryLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class CreateNewContact  extends WebDriverUtility
  {
	  WebDriver driver;
	  
	  public CreateNewContact(WebDriver driver)
	    {
		  this.driver = driver;
		  PageFactory.initElements(driver, this);
	    }
	  
	  @FindBy(name = "lastname")
	  private WebElement lastNameEdit;
	  
	  @FindBy(xpath = "//input[@title='Save [Alt+S]']")
	  private WebElement saveButton;
	   
	  @FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	  private WebElement orgLookUpImage;
	  
	  public WebElement getLastNameEdit() 
		{
			return lastNameEdit;
		}
		public WebElement getSaveButton() 
		{
			return saveButton;
		}

	  public void createContact(String contactLastName)
	   {
		  lastNameEdit.sendKeys(contactLastName); 
		  saveButton.click();
	   }
	  public void createContact(String contactLastName, String organizationName)
	   {
	 	  lastNameEdit.sendKeys(contactLastName); 
		  orgLookUpImage.click();
		  switchToWindow(driver, "Accounts&action");
		  Organizations or = new Organizations(driver);
		  or.getSearchTextEdit().sendKeys(organizationName);
		  or.getSearchButton().click();
		  driver.findElement(By.xpath("//a[.='"+organizationName+"']")).click();
		  switchToWindow(driver, "Contacts&action");
		  saveButton.click();
	  }	
}