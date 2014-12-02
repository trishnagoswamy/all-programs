package iAgriMarC;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class Bank_Details_Creation {
	public WebDriver driver;
	String cell_data ;
    String	data_bankname= "zee Bank";
    String min_bal="2000";
  
	@BeforeTest
	  public void beforeTest() {
		  driver = new FirefoxDriver();
		  driver.get("http://192.168.1.124:85/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		  //Login to 'Afzalpur APMC'
		  driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("afzalpurapmc");
		  driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("vsspl");
		  driver.findElement(By.xpath("//button[text()='Login']")).click(); 
		  driver.findElement(By.xpath("//div[@class='x-panel-header x-unselectable x-accordion-hd']/span[contains(text(),'Accounts')]")).click();
		 
	}
	
	
	
	
	@Test(priority=1)
	private void bank_creation() throws InterruptedException{
		driver.findElement(By.xpath("//a[@class='x-tree-node-anchor']/span[contains(text(),'Bank Details')]")).click();
		////a[@class='x-tree-node-anchor']/span[contains(text(),'Bank Details')]  
		driver.switchTo().frame("3025_IFrame");
		
		driver.findElement(By.xpath("//td/em/button[contains(text(),'New Record')]")).click();
		
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BankAccountCreationWindow_txtBankName")));
	
		WebElement bank_name = driver.findElement(By.id("BankAccountCreationWindow_txtBankName"));
	
		 bank_name.sendKeys(data_bankname);
		 String pass = bank_name.getText();
		
		driver.findElement(By.id("BankAccountCreationWindow_txtShortName")).sendKeys("aaaaa");
		
		driver.findElement(By.xpath("//textarea[@id='BankAccountCreationWindow_txtAddress']")).sendKeys("Afzalpur branch");
		driver.findElement(By.xpath("//input[@id='BankAccountCreationWindow_txtContactNumber']")).sendKeys("3333333333");
		driver.findElement(By.xpath("//input[@id='BankAccountCreationWindow_txtAccountType']")).sendKeys("Savings");
		driver.findElement(By.xpath("//input[@id='BankAccountCreationWindow_txtAccountNumber']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='BankAccountCreationWindow_txtAccountholderName']")).sendKeys("Afzalpur apmc");
		driver.findElement(By.xpath("//img[@class='x-form-trigger x-form-arrow-trigger']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='x-combo-list-inner']/div[contains(text(),'Bank Account')]")).click();
	    driver.findElement(By.xpath("//img[@class='x-form-trigger x-form-arrow-trigger'] ")).click();
	    driver.findElement(By.xpath("//div[@class='x-combo-list-inner']/div[contains(text(),'Cr')]")).click();
	    
	    driver.findElement(By.id("BankAccountCreationWindow_txtMinBalance")).sendKeys(min_bal);
		
	    WebDriverWait wait1= new WebDriverWait(driver, 30); 
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td[@class='x-btn-center']/em/button[contains(text(),'Save')]"))).click();
	     Thread.sleep(1000);
		WebElement confirmation_msg =driver.findElement(By.xpath("//div[@class='ext-mb-content']/span[@class='ext-mb-text']"));
	    String msg = confirmation_msg.getText();
	    if(msg.equalsIgnoreCase("Bank details has been saved successfully")){
	    	System.out.println("Record created");
	    	}
	    else if(msg.equalsIgnoreCase("'Save Bank failed :Account already exists with this name This Bank name Already Exist'")){
	    	System.out.println("Record Already Exists");
	    }
	    else{
	    	System.out.println("Error Thrown ");
	    }
	    System.out.println(msg);
	    driver.findElement(By.xpath("//td/em/button[contains(text(),'OK')]")).click();
	    driver.findElement(By.xpath("//button[@class='x-btn-text icon-cancel']")).click();
	
	}
	
	
	
	@Test(priority=2)
	public void verify_record(){
	
	    List<WebElement> grid= driver.findElements(By.xpath("//tbody/tr/td/div[@class='x-grid3-cell-inner x-grid3-col-lblBankName']"));	
		int rec_count=grid.size(); 
			System.out.println("Record Count is " + rec_count);
	do{
				 cell_data = driver.findElement(By.xpath("//div[@class='x-grid3-scroller']")).getText();	
		for(int i=0;i<=rec_count;i++){
			         if(cell_data.contains(data_bankname)){
			         System.out.println("Record Present in Grid  "+data_bankname);	
			          }
			         else{
				      driver.findElement(By.xpath("//tbody/tr/td[@class='x-btn-center']/em/button[@class='x-btn-text x-tbar-page-next']")).click();
			
			              }
		                              }
		}while(cell_data.contains(data_bankname));
			System.out.println("Record Found In The Grid : "+data_bankname);
	}
  @Test(priority=4)
  public void OB() throws InterruptedException{
	  driver.switchTo().defaultContent();
	  WebDriverWait wait2=new WebDriverWait(driver, 30);
	  wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='x-tree-node-anchor']/span[contains(text(),'Opening Balance')]"))).click();
	  driver.switchTo().frame("3026_IFrame");
	  driver.findElement(By.xpath("//button[contains(text(),'New Record')]")).click();
      driver.findElement(By.xpath("//div[@class='x-form-field-wrap x-trigger-wrap-focus']/img[@id='ext-gen159']")).click();
	  String combo = driver.findElement(By.xpath("//div[@class='x-combo-list-inner']")).getText();
  //System.out.println(combo);
	  if(combo.contains(data_bankname)){
	  System.out.println("Bank Name Found In Combobox  "+data_bankname);
                                  }
  else{
	  System.out.println("Bank Name Not Exists In Combobox  ");
  }
  }
@Test(priority=3)
public void Ledger_Acc(){
	driver.switchTo().defaultContent();
	driver.findElement(By.xpath("//a[@class='x-tree-node-anchor']/span[contains(text(),'Ledger Account')]")).click();
	driver.switchTo().frame("3039_IFrame");
	driver.findElement(By.xpath("//img[@id='ext-gen126']")).click();
	driver.findElement(By.xpath("//div[@class='x-combo-list-inner']/div[contains(text(),'All')]")).click();
	driver.findElement(By.xpath("//img[@id='ext-gen138']")).click();
	driver.findElement(By.xpath("//div[contains(text(),'zeus Bank')]")).click();
	driver.findElement(By.xpath("//button[contains(text(),'Show Data')]")).click();

	String particulars = driver.findElement(By.xpath("//table/tbody/tr/td[@class='x-grid3-col x-grid3-cell x-grid3-td-lblParticulars ']/div")).getText();

	//System.out.println("OB  : "+particulars);

	String debit = driver.findElement(By.xpath("//table/tbody/tr/td[@class='x-grid3-col x-grid3-cell x-grid3-td-lblDebit ']/div")).getText();

	//System.out.println(debit);

	String credit = driver.findElement(By.xpath("//table/tbody/tr/td[@class='x-grid3-col x-grid3-cell x-grid3-td-lblCredit ']/div")).getText();
	//System.out.println(credit);

	String Balance = driver.findElement(By.xpath("//table/tbody/tr/td[@class='x-grid3-col x-grid3-cell x-grid3-td-lblBalance ']/div")).getText();
	//System.out.println(balance);

	String Type = driver.findElement(By.xpath("//table/tbody/tr/td[@class='x-grid3-col x-grid3-cell x-grid3-td-lblType x-grid3-cell-last ']/div")).getText(); 

	//System.out.println(type);
	if(particulars.contains("Opening Balance") && credit.contains(min_bal)){
		System.out.println("Bank Credit Record Updated Successfully");
	}
	else{
		System.out.println("Not Updated");
	}
}

}
  


