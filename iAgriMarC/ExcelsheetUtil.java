package com.selenium.actions;

import java.io.FileInputStream;

import java.io.IOException;


import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelsheetUtil {
	private static Sheet sh;
	public static void file(String path,int sheetnumber) throws BiffException, IOException{
		FileInputStream Fi=new FileInputStream(path);
		 Workbook w = Workbook.getWorkbook(Fi);
		 sh =w.getSheet(sheetnumber); 
	}
	
	public static String celldata(int colnumber,int rownumber){
		String cell= sh.getCell(colnumber, rownumber).getContents();
	return cell;
	}
	
	public static int excel_get_rows() throws Exception{
		try{
		return sh.getRows()-1;
	}
		catch(Exception e){
			throw(e);
		}
}
}

/*****Sample Example to use the above methods*****/

/*try{
	Xlfile.file("/home/vidya/eclipse/Workspace/TestNG/src/All_xlsxSheets/users.xls", 0);
	LoginPage.txt_LoginName(driver).sendKeys(Xlfile.celldata(0, 1));
	LoginPage.txt_Password(driver).sendKeys(Xlfile.celldata(1, 1));
	LoginPage.btn_Login(driver).click();
int row_count=Xlfile.excel_get_rows();
System.out.println("Row Count is : "+row_count);

}
catch(Exception e){
	System.out.println(e.getCause());
}*/