package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelBasedOnCondition {
	@Test
	public void readingExcelDataBasedOnConditin() throws EncryptedDocumentException, IOException 
	{
		String expectedTestId="tc_02";
		
		//reading the 1st row data
		
		String data1="";
		String data2="";
		String data3="";
		
		FileInputStream fis1=new FileInputStream("C:\\Users\\sahoo\\OneDrive\\Documents\\TestScriptData.xlsx");		
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Sheet1");
		int rowCount = sh.getLastRowNum();
		for(int i=0; i<=rowCount;i++) {
			String data="";// to store expectedTestId
			data=sh.getRow(i).getCell(0).toString();
			if(data.equals(expectedTestId)) {
				data1=sh.getRow(i).getCell(1).toString();

				data2=sh.getRow(i).getCell(2).toString();

				data3=sh.getRow(i).getCell(3).toString();

				
			}
		}
		System.out.println(data1);
		System.out.println(data2);

		System.out.println(data3);

		
		
		

		wb.close();
		System.out.println("------Executed-------");
		
		
	}


}
