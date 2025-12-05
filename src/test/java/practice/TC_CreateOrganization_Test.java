package practice;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class TC_CreateOrganization_Test {
	@Test
	public void creatingOrganization() throws IOException, InterruptedException
	{	
		//read common data from property file
		FileInputStream fis=new FileInputStream("C:\\Users\\sahoo\\OneDrive\\Documents\\Commondata.properties.txt");
		Properties prop=new Properties();
		prop.load(fis);
		
		//generate Random Number
		Random random=new Random();
		//set the UpperLimit and it will return integer format
		int randomInt=random.nextInt(4000);

		//read testscript data from excelfile
		FileInputStream fis1=new FileInputStream("C:\\Users\\sahoo\\OneDrive\\Documents\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);

		String value = wb.getSheet("Org").getRow(1).getCell(1).getStringCellValue()+randomInt;
		
		
		
		WebDriver driver=null;
		if(prop.getProperty("browser").equals("chrome")){
			driver=new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("firefox")){
			driver=new FirefoxDriver();
		}
		else if(prop.getProperty("browser").equals("edge")){
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
			
		}
		
		//step-1 : Login to Application
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@name=\'user_password\']")).sendKeys(prop.getProperty("password"));
		driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.xpath("//input[@name=\'user_password\']"))).click();
		
		//step-2 : navigate to organization module
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		//step-3 : click on "create organization" button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step-4 : enter all the details and create new organization

		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(value);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step-5 : logout
		Actions act=new Actions(driver);
		Thread.sleep(4000);

		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		Thread.sleep(4000);

		driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(4000);
		driver.quit();
	}

}
