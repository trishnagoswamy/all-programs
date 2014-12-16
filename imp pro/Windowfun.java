package testcases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import com.selenium.actions.Signin;
import com.selenium.pageobject.Devmodule;

public class Windowfun {
	 public WebDriver driver;
  
	@BeforeTest
	  public void beforeTest() {
		driver = new FirefoxDriver();
		 driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		  Signin.Execute(driver, "bidarapmc", "vsspl");
		 driver.manage().window().maximize();
		 Devmodule.Development_module(driver);
			Devmodule.Work_progress(driver);  
	  }
	
	@Test
  public void f() throws InterruptedException {
		driver.switchTo().frame("4009_IFrame");
		
		driver.findElement(By.xpath("//button[@class='x-btn-menu-arrow-el']")).click();
		driver.findElement(By.xpath("//a[@class='x-menu-item']")).click();
		 
		Thread.sleep(2000); 
		
		// Storing parent window reference into a String Variable
		
		
		String Parent_Window = driver.getWindowHandle();
		  // Switching from parent window to child window
		 for (String Child_Window : driver.getWindowHandles())
		 {
		 driver.switchTo().window(Child_Window);
		  //driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		  driver.manage().window().maximize();  
  System.out.println(driver.getTitle());
		 }
		 
//driver.switchTo().frame("bobjid_1416978421756_iframe");
driver.findElement(By.xpath("html/body/form/div[2]/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/table/tbody/tr/td[1]/input")).sendKeys("7777");
driver.findElement(By.xpath("html/body/form/div[2]/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/table/tbody/tr/td[2]/table/tbody/tr/td/div/img")).click();
//driver.findElement(By.xpath("html/body/table[3]/tbody/tr/td/table/tbody/tr[2]/td[2]")).click();	*/	 
	driver.switchTo().window(Parent_Window);	
}}
