package exp;

//import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import com.selenium.actions.Signin;
import com.selenium.pageobject.Accounts;

public class Grid_Find {
	//private static final String wb = null;
	public WebDriver driver;
  @BeforeTest
  public void beforeTest() {
	  driver= new FirefoxDriver();  
	  driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS );
	 Signin.Execute(driver, "bidarapmc", "vsspl");
      Accounts.Acc_Module(driver);
      Accounts.GeneralLedger_ScreenName(driver);
      driver.switchTo().frame("3024_IFrame");  
  }
  @Test
  public void rec_find() {
	 String pag= driver.findElement(By.xpath("//td/span[@id='ext-gen47']")).getText();
	
	 
	 pag =  pag.replace("of ", "");
     Integer pag1 = Integer.parseInt(pag);
     System.out.println("Page count is :- "+pag1);
     
     for(int j=1;j <=pag1;j++){
	  String name="Luxury Tax";
	  boolean flag=false;
	  String wb=null;
	  for(int i=1;i<=20;i++)
	  {
	 
		 wb=driver.findElement(By.xpath("//div[@class='x-grid3-body']/div["+i+"]/table/tbody/tr/td[2]/div")).getText(); 
        
     	 
	  if(wb.contains(name))
	     {
		  
		 driver.findElement(By.xpath("//div[@class='x-grid3-body']/div["+i+"]/table/tbody/tr/td[2]/div")).click();
		
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 System.out.println("Record Found with Name : "+wb);
		 
		  flag=true;
		   break;
          }
	 	 
}//for loop close
	  
	  if(flag){
		 // System.out.println("Record Found in Grid with : "+wb); 
		  break;
	  }
	  driver.findElement(By.xpath("//tbody/tr/td[@class='x-btn-center']/em/button[@class='x-btn-text x-tbar-page-next']")).click();
     }
    
     
  }//@test close
}//class
