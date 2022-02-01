package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReaddatafromPropertyfile 
{
	public static void main(String[] args) throws IOException
	{

FileInputStream fis = new FileInputStream("./data/commondata.properties");
FileInputStream f=new FileInputStream("./data/testdata.xlsx");//Step1 Specify the path
Workbook book=WorkbookFactory.create(f);//Step2 
Sheet s = book.getSheet("Sheet1");
Row r = s.getRow(0);
Cell c = r.getCell(0);
String value = c.getStringCellValue();

Properties poj = new Properties();
poj.load(fis);
String browser = poj.getProperty("browser");
String  url= poj.getProperty("url");
String username = poj.getProperty("username");
String password = poj.getProperty("password");

Random ran = new Random();
int Random = ran.nextInt(100);

WebDriver driver=new ChromeDriver();
driver.get(url);
driver.findElement(By.name("user_name")).sendKeys(username);
driver.findElement(By.name("user_password")).sendKeys(password);
driver.findElement(By.id("submitButton")).click();		

driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(value);
driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]")).click();
driver.findElement(By.xpath("(//a[.='Sign Out']")).click();
	}
}