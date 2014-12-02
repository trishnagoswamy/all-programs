package iAgriMarC;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import com.selenium.actions.Signin;
import com.selenium.pageobject.Accounts;

public class General_ledger {
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



@Test(enabled=false)
public void getcount(){
	List<WebElement> sco=driver.findElements(By.xpath("//tbody/tr/td[@class='x-grid3-col x-grid3-cell x-grid3-td-lblAccName ']/div[@class='x-grid3-cell-inner x-grid3-col-lblAccName']"));
	int rec_count=sco.size();
	System.out.println("Record Count is " + rec_count);
	
	
	String s1="Parvanige Fee";
	String s=driver.findElement(By.xpath("//table/tbody/tr/td[2]/div")).getText();
	@SuppressWarnings("static-access")
	String s2=s.valueOf(s);
	
	//String s=driver.findElement(By.xpath("//table/tbody/tr/td[2]/div")).getText();
	///td[contains(text()='kapping Charges'
do{
	String grid=driver.findElement(By.xpath("//div[@class='x-grid3-body']")).getText();
	////div[@class='x-grid3-scroller']
	for(int i=0;i<=rec_count;i++){
	
		if(grid.contains(s1)){
		//if(grid.contains(s)){
		System.out.println("Found Element");
		
		}
	
		else{
	      driver.findElement(By.xpath("//tbody/tr/td[@class='x-btn-center']/em/button[@class='x-btn-text x-tbar-page-next']")).click();

	}
	
}
	
	

	
}while(s.equals(s1));

System.out.println("******Record Found in the grid*****"+s2);
}	
@Test(enabled=true)
public void g(){
	//String ss=driver.findElement(By.xpath("//div[@class='x-grid3-body']/div/table/tbody/tr/td[2]/div")).getText();
    
	List<WebElement> sco=driver.findElements(By.xpath("//tbody/tr/td[@class='x-grid3-col x-grid3-cell x-grid3-td-lblAccName ']/div[@class='x-grid3-cell-inner x-grid3-col-lblAccName']"));
	int rec_count=sco.size();
   WebElement grid= driver.findElement(By.xpath("//div[@class='x-grid3-body']"));
  // WebElement sb=driver.findElement(By.xpath("//div[@class='x-grid3-body']/div/table/tbody/tr/td[2]/div(contains(text(),'District Treasory Office'))"));

   for(int i=1;i<=rec_count;i++){
	  String sb=driver.findElement(By.xpath("//div[@class='x-grid3-body']/div/table/tbody/tr/td[2]/div[contains(text(),'Audit Fee')]")).getText();
	  WebElement wb=driver.findElement(By.xpath("//div[@class='x-grid3-body']/div["+i+"]/table/tbody/tr/td[2]/div"));
	 String svalue="Audit Fee";
	  //  sb.click();
	  // System.out.println("Record Found and Clicked");
  
   /*if(wb.){
	   wb.click();
	   
	   
  }
   else{
   driver.findElement(By.xpath("//tbody/tr/td[@class='x-btn-center']/em/button[@class='x-btn-text x-tbar-page-next']")).click();
   System.out.println("record not found");
   }*/
   }


	//System.out.println(ss);
}

}
