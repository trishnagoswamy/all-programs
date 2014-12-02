package iAgriMarC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class allimg {
	public WebDriver driver;
  @Test
  public void imag() {
	  driver=new FirefoxDriver();
	  driver.get("http://192.168.1.124:85");
	  List<WebElement>list = driver.findElements(By.tagName("img"));
 int count=list.size();
 System.out.println(count);
  }
}
