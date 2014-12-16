package webdriver;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.regex.Pattern;
public class Google {
	public WebDriver driver;
	
  @Test
  public void f() {
	 String Pattern = "[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\-\\_]+\\.[a-zA-Z]{3}";
	  driver.findElement(By.xpath("//div[@class='gb_e gb_f']/a[contains(text(),'Gmail')]")).click();
	WebElement id=  driver.findElement(By.id("Email"));
			id.sendKeys("trishna  .gos.@emailwamy@email.net");
			String id_data=id.getAttribute("value");
			System.out.println("id contains text  : "+id_data);
	  if(id_data.matches(Pattern)){
		  System.out.println("String matches format");
		  
	  }
	  else{
		  System.out.println("String not matching");
	  }
		  
  }
  @BeforeTest
  public void beforeTest() {
 driver = new FirefoxDriver();
 driver.get("https://www.google.co.in");
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

}
