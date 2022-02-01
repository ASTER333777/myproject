package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;

public class SoftAssert  extends BaseClass
{
  @Test
  public void verifyHomePage()
    {
	  System.out.println("=========TEST START=========");
	  String expextedTitle = " Home ";
	  System.out.println("capture page title");
	  String actTitle = driver.getTitle();
	  Assert.assertEquals(actTitle, expextedTitle);
	  System.out.println("=========TEST END=========");
    }
  
  @Test
  public void verifyLogoinHomePage()
    {
	  System.out.println("=========TEST START=========");
	  System.out.println("capture Homepage Logo");
	  Boolean actualStatus = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isDisplayed();
	  Assert.assertTrue(actualStatus);
	  System.out.println("=========TEST END=========");
  }
}