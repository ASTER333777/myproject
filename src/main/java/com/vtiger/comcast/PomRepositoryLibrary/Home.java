package com.vtiger.comcast.PomRepositoryLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home 
{
	WebDriver driver;
	
	public Home(WebDriver driver)
	  {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	  }
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImage;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;

	public WebElement getOrganizationLink() 
	  {
		return organizationLink;
	  }
	public WebElement getContactLink() 
	  {
		return contactLink;
	  }
	public WebElement getProductLink() 
	  {
		return productLink;
	  }
	public WebElement getAdministratorImage() 
	  {
		return administratorImage;
	  }
	public WebElement getSignoutLink() 
	  {
		return signoutLink;
	  }
	
	public void logout()
	  {
		Actions act= new Actions(driver);
		act.moveToElement(administratorImage).perform();
		signoutLink.click();
	  }
}