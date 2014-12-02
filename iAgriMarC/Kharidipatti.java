package iAgriMarC;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import com.selenium.actions.Signin;
import com.selenium.pageobject.Kp_elements;
import com.selenium.pageobject.Marketing;

public class Kharidipatti {
	public WebDriver driver;
  @Test
  public void f() {
	
	 Marketing.Mkting_ModuleName(driver);
	 Marketing.KP_screenname(driver);
	 driver.switchTo().frame("3008_IFrame");
	 Kp_elements.combo_OriginName(driver).click();
	
	ArrayList<String> unsortedlist=new ArrayList<String>();
	WebElement combo=driver.findElement(By.xpath("//div[@class='x-combo-list-inner']"));
	String st=combo.getText();
	String[] mt=st.split("\n");
    for(int i=0; i<mt.length;i++)
    {	unsortedlist.add(mt[i]);
    }
	System.out.println("\n ArrayList is unsort===========\n");
	for(String temp1: unsortedlist){
		System.out.println(temp1);
	}
	
Collections.sort(unsortedlist);
System.out.println("\n ArrayList is sorted===========\n");
for(String temp:unsortedlist){
System.out.println(temp);	  
}



  
  }
/*Collections.sort(unsortedlist, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2)
    {    
    	return s1.compareTo(s2);
    }
});*/
  
  //}
 
  
  
  @BeforeTest
  public void beforeTest() {
	  driver= new FirefoxDriver();  
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
	 Signin.Execute(driver, "afzalpurapmc", "vsspl");
	
  }

}
