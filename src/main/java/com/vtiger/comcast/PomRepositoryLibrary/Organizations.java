package com.vtiger.comcast.PomRepositoryLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations 
  {
	WebDriver driver;
	
	public Organizations(WebDriver driver)
	 {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	 }
  
    @FindBy(xpath="//img[@title='Create Organization...']")
    private WebElement createOrganizationButton;
  
    @FindBy(xpath="//input[@type='button']")
    private WebElement searchButton;
    
    @FindBy(xpath="//input[@name='search_text']")
    private WebElement searchTextEdit;

    public WebElement getCreateOrganizationButton() 
    {
	    return createOrganizationButton;
    }
	public WebElement getSearchButton() 
	{
		return searchButton;
	}
	public WebElement getSearchTextEdit() 
	{
		return searchTextEdit;
	}  
}