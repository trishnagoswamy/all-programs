package iAgriMarC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class Data_driven {
	public WebDriver driver;
  @Test
  public void Login_datadriven() throws Exception {
	  driver = new FirefoxDriver();
	  
	  FileInputStream Fi=new FileInputStream("/home/vidya/Documents/datadriven.xls");
	 Workbook w = Workbook.getWorkbook(Fi);
	 Sheet sh =w.getSheet(0); 
 
  driver.get("http://192.168.1.124:85");
  driver.manage().window().maximize();
  for(int row=1;row<=sh.getRows();row++){
  String username = sh.getCell(0, row).getContents();
  System.out.println("User Name is "+username);
  driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
  String password=sh.getCell(1, row).getContents();
 System.out.println("Password is "+password);
  driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
  driver.findElement(By.xpath("//button[text()='Login']")).click(); 
  Thread.sleep(3000);
  driver.findElement(By.xpath("//span[@id='lnkBtnSignOff']/a[contains(text(),'| LogOff')]")).click();
  Thread.sleep(2000);
  //driver.findElement(By.linkText("| LogOff")).click();
  }
  }
}
