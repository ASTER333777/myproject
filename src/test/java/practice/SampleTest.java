package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest 
{
public static void main(String[] args) throws InterruptedException, FileNotFoundException 
{
	FileInputStream fis = new FileInputStream("./data/commondata.properties");
	FileInputStream f=new FileInputStream("./data/testdata.xlsx");//Step1 Specify the path
	
	
	
	WebDriver driver = new ChromeDriver();
	driver.get("http://localhost:8888");
	driver.findElement(By.xpath("//input[@name='user_name']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[.='Contacts']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	Thread.sleep(2000);
}
}
