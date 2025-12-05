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

public class ReadDataFromExcelTest {
	
	@Test
	public void readingExcelData() throws EncryptedDocumentException, IOException
	{
		//open Excel in read mode
		FileInputStream fis1=new FileInputStream("C:\\Users\\sahoo\\OneDrive\\Documents\\TestScriptData.xlsx");		
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Org");
		Row row = sh.getRow(1);
		//create new cell
		Cell newCell = row.createCell(3);
		//set data type
		newCell.setCellType(CellType.STRING);
		//write data in cell
		newCell.setCellValue("PASS");
		
		//to save the data keep the excel file write mode
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\sahoo\\OneDrive\\Documents\\TestScriptData.xlsx");
		//save workbook
		wb.write(fos);
		wb.close();
		System.out.println("------Executed-------");
		
		
	}

	
}
