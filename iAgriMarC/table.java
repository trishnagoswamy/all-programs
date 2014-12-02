package iAgriMarC;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class table {
	public WebDriver driver;
	 @BeforeTest
	  public void signin() {
		 driver = new FirefoxDriver();
	      driver.get("http://192.168.1.124:85");
	      driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("afzalpurapmc");
	      driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("vsspl");
	      driver.findElement(By.xpath("//td/em[@unselectable='on']/button[contains(text(),'Login')]")).click();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      driver.findElement(By.xpath("//div[@class='x-panel-header x-unselectable x-accordion-hd']/span[contains(text(),'Accounts')]")).click();
	     
	      
	  }
	
	@Test(enabled=false)
  public void table_data() {
		driver.findElement(By.xpath("//a/span[contains(text(),'General Ledger')]")).click();
	      driver.switchTo().frame("3024_IFrame");
	List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr/td/div[@class='x-grid3-cell-inner x-grid3-col-lblAccName']"));
	int row_count = rows.size();
	System.out.println(row_count);
	
	 for (int row=1; row<row_count; row++){
		 List<WebElement> Columns_row = rows.get(row).findElements(By.xpath("//table/thead/tr[@class='x-grid3-hd-row']/td"));
		 int columns_count = Columns_row.size();
		   System.out.println("Number of cells In Row "+row+" are "+columns_count);
		   
	 }
	 }
@Test
public void ref(){
driver.findElement(By.xpath("//a[@class='x-tree-node-anchor']/span[contains(text(),'Ledger Account')]")).click();
driver.switchTo().frame("3039_IFrame");
driver.findElement(By.xpath("//img[@id='ext-gen126']")).click();
driver.findElement(By.xpath("//div[@class='x-combo-list-inner']/div[contains(text(),'All')]")).click();
driver.findElement(By.xpath("//img[@id='ext-gen138']")).click();
driver.findElement(By.xpath("//div[contains(text(),'zeus Bank')]")).click();
driver.findElement(By.xpath("//button[contains(text(),'Show Data')]")).click();

String Particulars = driver.findElement(By.xpath("//table/tbody/tr/td[@class='x-grid3-col x-grid3-cell x-grid3-td-lblParticulars ']/div")).getText();

System.out.println("OB  : "+Particulars);

String Debit = driver.findElement(By.xpath("//table/tbody/tr/td[@class='x-grid3-col x-grid3-cell x-grid3-td-lblDebit ']/div")).getText();

System.out.println(Debit);

String Credit = driver.findElement(By.xpath("//table/tbody/tr/td[@class='x-grid3-col x-grid3-cell x-grid3-td-lblCredit ']/div")).getText();
System.out.println(Credit);

String Balance = driver.findElement(By.xpath("//table/tbody/tr/td[@class='x-grid3-col x-grid3-cell x-grid3-td-lblBalance ']/div")).getText();
System.out.println(Balance);

String Type = driver.findElement(By.xpath("//table/tbody/tr/td[@class='x-grid3-col x-grid3-cell x-grid3-td-lblType x-grid3-cell-last ']/div")).getText(); 

System.out.println(Type);
//driver.findElement(By.xpath("//div[@class='x-form-field-wrap x-trigger-wrap-focus']/img[@id='ext-gen159']")).click();
/*List <WebElement> combo = driver.findElements(By.xpath("//div[@class='x-combo-list-inner']/div"));
int combo_count=combo.size();
//combo.split("\n");

System.out.println("Elements Count of dropdown are  "+ combo_count);*/

}
}
  
 


