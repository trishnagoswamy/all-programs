package iAgriMarC;

import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


@SuppressWarnings("deprecation")
public class Details_creation {
	
	public WebDriver driver;
	
	@BeforeTest(description = "Login")
	  public void Login() throws InterruptedException {
		  driver = new FirefoxDriver();
		  driver.get("http://192.168.1.124:85/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		  //Login to 'Afzalpur APMC'
		  driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("afzalpurapmc");
		  driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("vsspl");
		  driver.findElement(By.xpath("//button[text()='Login']")).click(); 
		  driver.findElement(By.xpath("//div/div/div/span[contains(text(), 'Administration')]")).click();
		  driver.findElement(By.xpath("//a/span[contains(text(), 'Details Of Committee')]")).click();
		  driver.switchTo().frame("4042_IFrame");
	  }
  //Verify creation of entry in 'Details of committee' 
	@Test(invocationCount=1) 
  public void Details_create() throws InterruptedException {
	  driver.findElement(By.xpath("//table[@id='btnNew']")).click();
	  driver.findElement(By.xpath("//input[@id='MemberCreationWindow_txtMemberName']")).sendKeys("five times");
	  driver.findElement(By.xpath("//img[@id='ext-gen209']")).click();
	  driver.findElement(By.id("MemberCreationWindow_cmbDesignation")).click();
	  driver.findElement(By.xpath("//div[@class='x-combo-list-inner']/div[text()= 'Member']")).click();
	  driver.findElement(By.xpath("//input[@id='MemberCreationWindow_txtMobileNumber']")).sendKeys("1234567894");
	  driver.findElement(By.xpath("//img[@id='ext-gen252']")).click();
	  driver.findElement(By.xpath("//td/em[@unselectable='on']/button[contains(text(), 'September 2014')]")).click();
	  driver.findElement(By.linkText("Dec")).click();
	  driver.findElement(By.linkText("2014")).click();
	  driver.findElement(By.xpath("//td[@colspan='4']/button[@class='x-date-mp-ok']")).click();
	  driver.findElement(By.xpath("//td[@class='x-date-active']/a[@class='x-date-date']/em/span[contains(text(),'30')]")).click();
	  driver.findElement(By.xpath("//table[@id='MemberCreationWindow_btnSave']")).click();
	
	  //Verifying confirmation message
	  try{
		  
		  WebDriverWait wait=new WebDriverWait(driver, 30);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ext-mb-content']/span[@class='ext-mb-text']")));
		  WebElement e = driver.findElement(By.xpath("//div[@class='ext-mb-content']/span[@class='ext-mb-text']"));
		  String str = e.getText();
		  System.out.println(str);
		  Assert.assertEquals("Your record has been saved successfully",str);
		 }
	  catch	(Exception e){
		  
		  System.out.println("Assert Failed "+e.getMessage());
	  }
		
	  	driver.findElement(By.xpath("//tbody/tr/td[@class='x-btn-center']/em/button[contains(text(),'OK')]")).click();
		
	  	//closing creation child window
		driver.findElement(By.xpath("//td[@class='x-btn-center']/em/button[contains(text(),'Close')]")).click();
		
		
  }
  
 

  

}
