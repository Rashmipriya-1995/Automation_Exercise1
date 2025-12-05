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

public class ReadMultipleDatafromExcelTest {
	@Test
	public void readingExcelData() throws EncryptedDocumentException, IOException
	{
		//open Excel in read mode
		FileInputStream fis1=new FileInputStream("C:\\Users\\sahoo\\OneDrive\\Documents\\TestScriptData.xlsx");		
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Sheet1");
		int rowCount = sh.getLastRowNum();
		
		for(int i=1;i<=rowCount;i++) {
		Row row = sh.getRow(i);
		String columndata1 = row.getCell(0).toString();
		String columndata2 = row.getCell(1).toString();
		String columndata3 = row.getCell(2).toString();
		String columndata4 = row.getCell(3).toString();
		

		System.out.println(columndata1+ "\t"+columndata2+ "\t"+columndata3+ "\t"+columndata4);
		}
		
		wb.close();
		System.out.println("------Executed-------");
		
		
	}


}
