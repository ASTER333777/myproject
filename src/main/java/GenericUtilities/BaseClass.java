package GenericUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.comcast.PomRepositoryLibrary.Home;
import com.vtiger.comcast.PomRepositoryLibrary.Login;

public class BaseClass 
  { 
	public WebDriver driver=null;
	  /*Object Creation for Lib*/
		public JavaUtility jLib = new JavaUtility();
		public WebDriverUtility wLib = new WebDriverUtility();
		public FileUtiltiy fLib = new FileUtiltiy();
		public ExcelUtility eLib = new ExcelUtility();
	
	  @BeforeSuite(groups={"SMOKE TEST","REGRESSION TEST"})
	  public void configBS() 
	   {
	     System.out.println("=*=*=*=*=*=*=*=*=*= Connect to DataBase =*=*=*=*=*=*=*=*=*=");
       }
	
	 //@Parameters("browser")
	 @BeforeClass(groups={"SMOKE TEST","REGRESSION TEST"})
	 public void configBC() throws Throwable
	  {
		System.out.println("==================== Launch the Browser ====================");
		
		/*Read common data from the properties file*/
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		 
		if(BROWSER.equals("chrome")) 
		{
		    driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) 
		{
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equals("ie")) 
		{
			driver = new InternetExplorerDriver();
		}
		else 
		{
			 driver = new ChromeDriver();
		}
		driver.get(URL);
		wLib.waitUntilPageLoad(driver);
		driver.manage().window().maximize();
	}

	 @BeforeMethod(groups={"SMOKE TEST","REGRESSION TEST"})
	 public void configBM() throws Throwable 
	   {
		 /*Read common data from the properties file*/
		 String USERNAME = fLib.getPropertyKeyValue("username");
		 String PASSWORD = fLib.getPropertyKeyValue("password");
		 
	        /* step 1 : login */
	        Login loginPage = new Login(driver);
	        loginPage.loginToApp(USERNAME, PASSWORD);
	   }
	
	 @AfterMethod(groups={"SMOKE TEST","REGRESSION TEST"})
	 public void configAM() 
	 {
	      /*step 6 : logout*/
		Home homePage = new Home(driver);
        homePage.logout();
	 }
	
	 @AfterClass(groups={"SMOKE TEST","REGRESSION TEST"})
	 public void configAC() 
	   {
		 System.out.println("==================== Close the Browser ====================");
		 driver.quit();
	   }
	
	 @AfterSuite(groups={"SMOKE TEST","REGRESSION TEST"})
	 public void configAS() 
	   {
		  System.out.println("=*=*=*=*=*=*=*=*=*= Disconnect from DataBase =*=*=*=*=*=*=*=*=*=");
	   }
}