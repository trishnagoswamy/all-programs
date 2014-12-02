package iAgriMarC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.selenium.actions.Signin;

public class TextBox {
	 public WebDriver driver;
	 WebElement t;
	public  TextBox() {
		// TODO Auto-generated method stub
		driver = new FirefoxDriver();
		driver.get("http://192.168.1.124:85");
	WebElement t = driver.findElement(By.xpath("//input[@id='txtUsername']"));
	t.sendKeys("gangavathiapmc");
	String txt_data = t.getAttribute("value");
	System.out.println("The Text box contains :- "+txt_data);
	Signin.Execute(driver, "afzalpurapmc", "vsspl");
	}

}
