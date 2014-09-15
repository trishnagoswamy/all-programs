package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
	public static WebDriver driver;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
	}
	public WebDriver signin(String username,String password)throws Exception{
		driver=new FirefoxDriver();
			  driver.get("http://192.168.1.124:85/");
			  driver.manage().window().maximize();
			  driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
			  driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
			  driver.findElement(By.xpath("//button[text()='Login']")).click(); 
		  Thread.sleep(3000);
		  return driver;
		}
public void admin_click(){
	driver.findElement(By.xpath("//div/div/div/span")).click();
}
}
