package com.vtiger.comcast.PomRepositoryLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class Login extends WebDriverUtility//Rule 1: Create a separate java class for every page in an application
  {
	WebDriver driver;
	
    public Login(WebDriver driver)  //Rule 3: Execute all the elements & initialize the elements PageFactory.initElements [initialization]
      {
        this.driver = driver;
	    PageFactory.initElements(driver, this);
      }
  
    @FindBy(name="user_name")   //Rule 2: Identify all elements by using @findBy, @findBys, @findAll (Declaration)
    private WebElement userNameEdit;
  
    @FindBy(name="user_password")
    private WebElement userPasswordEdit;
  
    @FindAll({@FindBy(id="submitButton"), @FindBy(xpath="//input[@id='submitButton']")})
    private WebElement loginButton;

   public WebElement getUserNameEdit() 
    {
  	  return userNameEdit;
    }
   public WebElement getUserPasswordEdit()   //Rule 4: Declare all elements as private and provide getters method, Business method for Utilization
    {
	  return userPasswordEdit;
    }
   public WebElement getLoginButton() 
    {
	  return loginButton;
    }

   public void loginToApp(String userName, String password)   //Login
    {
	   waitUntilPageLoad(driver);
	   driver.manage().window().maximize();
	   userNameEdit.sendKeys(userName);
	   userPasswordEdit.sendKeys(password);
	   loginButton.click();
   }
}