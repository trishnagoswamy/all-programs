package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import webdriver.Login;
public class Details_create {
	public static WebDriver driver;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
Login t = new Login();
//driver=new FirefoxDriver();
driver=t.signin("afzalpurapmc", "vsspl");
Thread.sleep(1000);
driver.findElement(By.xpath("//div/div/div/span[contains(text(), 'Administration')]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//a/span[contains(text(), 'Details Of Committee')]")).click();
Thread.sleep(3000);
driver.switchTo().frame("4042_IFrame");
driver.findElement(By.xpath("//table[@id='btnNew']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//input[@id='MemberCreationWindow_txtMemberName']")).sendKeys("jadav");
driver.findElement(By.xpath("//img[@id='ext-gen209']")).click();
driver.findElement(By.id("MemberCreationWindow_cmbDesignation")).click();
driver.findElement(By.xpath("//div[@class='x-combo-list-inner']/div[text()= 'Member']")).click();
driver.findElement(By.xpath("//input[@id='MemberCreationWindow_txtMobileNumber']")).sendKeys("1234567894");
//Date picker
driver.findElement(By.xpath("//img[@id='ext-gen252']")).click();
driver.findElement(By.xpath("//td/em[@unselectable='on']/button[contains(text(), 'September 2014')]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//td[@class='x-date-mp-month x-date-mp-sep']/a[text()='Dec']")).click();
driver.findElement(By.xpath("//td[@class='x-date-mp-year x-date-mp-sel']/a[text()='2014']")).click();
driver.findElement(By.xpath("//td[@colspan='4']/button[@class='x-date-mp-ok']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//td[@class='x-date-active']/a[@class='x-date-date']/em/span[contains(text(),'30')]")).click();
driver.findElement(By.xpath("//table[@id='MemberCreationWindow_btnSave']")).click();
Thread.sleep(2000);
//click on "OK" button in confirmation window 
//driver.findElement(By.xpath("//div[@class='x-window x-window-plain x-window-dlg']/tr/td/td/em/button[contains(text(),'OK')]]")).click();
	}
}
