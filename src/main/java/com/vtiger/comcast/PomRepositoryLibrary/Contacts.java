package com.vtiger.comcast.PomRepositoryLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts
{
  WebDriver driver;
  public Contacts(WebDriver driver)
   {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
   }
	
   @FindBy(xpath = "//img[@title='Create Contact...']")
   private WebElement createContactImage;
  
   public WebElement getCreateContactImage() 
    {
	  return createContactImage;
    }
}