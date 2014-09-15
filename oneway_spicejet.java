package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class oneway_spicejet {
public WebDriver driver;

public void openUrl(){
	driver=new FirefoxDriver();
	driver.get("http://www.spicejet.com/");
}
public void book_ticket_oneway()throws Exception{
	driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	Thread.sleep(1000);
	driver.findElement(By.linkText("Delhi (DEL)")).click();	
	Thread.sleep(1000);
	driver.findElement(By.linkText("Jaipur (JAI)")).click();
	driver.findElement(By.linkText("25")).click();
	new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult"))).selectByVisibleText("3 Adults");
	new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child"))).selectByVisibleText("2 Children");
	new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant"))).selectByVisibleText("1 Infant");
	driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	driver.switchTo().alert().accept();
}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		oneway_spicejet t=new oneway_spicejet();
		t.openUrl();
		t.book_ticket_oneway();
	}

}
