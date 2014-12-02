package iAgriMarC;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class Payments {
	public WebDriver driver;
	private static StringBuffer SB;
	@BeforeTest
	  public void beforeTest() {
		
		driver = new FirefoxDriver();
		  driver.get("http://192.168.1.124:85/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		  //Login to 'Afzalpur APMC'
		  driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("gangavathiapmc");
		  driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("vsspl");
		  driver.findElement(By.xpath("//button[text()='Login']")).click(); 
		  driver.findElement(By.xpath("//div[@class='x-panel-header x-unselectable x-accordion-hd']/span[contains(text(),'Accounts')]")).click();
	
	}
	
	@Test
  public void payments_FUN() throws InterruptedException {
		paymentsEntry();
		  
		  System.out.println("***************Capturing Elements from Payments screen*********************");
		  String Act_Name = null;
		  String Voucher_No = null;
		  String Amount = null;
		  String TDS_Amount = null;
		  String Payment_type=null;
		  String Narration = null;		
		  try{
			  Act_Name=driver.findElement(By.xpath("//td/div[@class='x-grid3-cell-inner x-grid3-col-lblAccName']")).getText();
			  Voucher_No=driver.findElement(By.xpath("//td/div[@class='x-grid3-cell-inner x-grid3-col-lblVoucherNo']")).getText();
			  Amount=driver.findElement(By.xpath("//td/div[@class='x-grid3-cell-inner x-grid3-col-lblAmount']")).getText();
			  TDS_Amount=driver.findElement(By.xpath("//td/div[@class='x-grid3-cell-inner x-grid3-col-lblTdsAmount']")).getText();
			  Payment_type=driver.findElement(By.xpath("//td/div[@class='x-grid3-cell-inner x-grid3-col-lblPayType']")).getText();
			  Narration=driver.findElement(By.xpath("//td/div[@class='x-grid3-cell-inner x-grid3-col-lblNarration']")).getText();
		  }
		  catch (Exception e) {
			  SB.append(e);
			  SB.append("\n");
		}
		  
		 	 
		   cashBook(Act_Name, Amount, TDS_Amount, Narration);
		   
		  /* daybook(Voucher_No, Amount, TDS_Amount);
		  	 	  
	       ledgerAccount(Act_Name, Voucher_No, Amount, TDS_Amount);

		   finalAccounts(Act_Name,Amount,TDS_Amount,Payment_type);
		  
		   viewEntries();
		  
		   income_Expenditure(Act_Name,Amount);
		  
		   payments_Receipts(Act_Name,Amount,TDS_Amount);
	 

		   secretary_Reports();*/
		   Reporter.log(SB.toString());

			  
			  System.out.println("*************************Reporter****************************************************");
			  System.out.println(SB.toString());
			  if(!SB.toString().equalsIgnoreCase(""))
			  {
				  System.out.println(SB.toString());
				  SB = new StringBuffer();
			  }
	}
  

@Test(enabled=true)
public void paymentsEntry() throws InterruptedException{
	//try{
	driver.findElement(By.xpath("//a/span[contains(text(),'Payments')]")).click();
	driver.switchTo().frame("3032_IFrame");
		driver.findElement(By.xpath("//button[contains(text(),'New Record')]")).click();
		driver.findElement(By.xpath("//img[@id='ext-gen276']")).click();
		Thread.sleep(2000);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='x-combo-list-inner']/div[contains(text(),'Andra Bank Pledge Loan Gangavathi')]")));
		driver.findElement(By.xpath("//div[@class='x-combo-list-inner']/div[contains(text(),'Andra Bank Pledge Loan Gangavathi')]")).click();
		driver.findElement(By.xpath("//img[@id='ext-gen299']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'A.Basavaraj And Brothers')]")).click();
	driver.findElement(By.id("PaymentEntryWindow_txtChqueNumber")).sendKeys("3333");
	driver.findElement(By.id("PaymentEntryWindow_txtGrossAmount")).sendKeys("1000");
	driver.findElement(By.id("PaymentEntryWindow_txtTdsAmount")).sendKeys("50");
	driver.findElement(By.id("PaymentEntryWindow_txtNarration")).sendKeys("Payment rec 3");
	driver.findElement(By.xpath("//button[contains(text(),'Insert')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	//}
	/*catch(Exception e){
		SB.append("Payment Entry Failed Reason Is....."+e.toString());
		SB.append("\n");
	}*/
	}

@Test
private void cashBook(String Act_Name,String Amount,String TDS_Amount, String Narration){
driver.findElement(By.xpath("//a/span[contains(text(),'Cash Book')]")).click();
driver.switchTo().frame("3038_IFrame");
driver.findElement(By.xpath("//button[contains(text(),'Show Data')]")).click();
List<WebElement> c=driver.findElements((By.xpath("//div[@class='x-grid3-body']/div")));
int cashbook_count=c.size();
System.out.println("Number of Records in CaskBook Are -- "+cashbook_count);
}
}
