package com.vtiger.comcast.PomRepositoryLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfo 
{
   WebDriver driver;
   
   public ContactsInfo(WebDriver driver)
	 {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	 }
	  
	 @FindBy(xpath="//span[@class='dvHeaderText']")
	 private WebElement successfulMessage;
	  
	 public WebElement getSuccessfulMessage() 
	  {
		return successfulMessage;
	  }
}