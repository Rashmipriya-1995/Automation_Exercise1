package contactsmodule;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateContactWithSupportTest {
	
	@Test
	public void creatingContactwithSupport() throws IOException, InterruptedException {
		//Read data from property file
		FileInputStream fis=new FileInputStream("./Data/CommonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		String browsername = prop.getProperty("browser");
		String url= prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");

		
		//generate Random Number
		Random random=new Random();
		int randomInt = random.nextInt(2000);
		
		//Read data from Excel file
		FileInputStream fis1=new FileInputStream("./Data/TestScriptData1.xlsx");		
		Workbook wb = WorkbookFactory.create(fis1);
		String contactlastName = wb.getSheet("Sheet1").getRow(1).getCell(2).toString();
		
		WebDriver driver=null;
		if(browsername.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		else if(browsername.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else 
		{
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(contactlastName);
		
		//to get Start date and End date
		
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String startDate = sim.format(date);
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,+30);//after 30 days
		
		//to get that date
		
		String endDate = sim.format(cal.getTime());
		
		WebElement ele1 = driver.findElement(By.xpath("//input[@name='support_start_date']"));
		ele1.clear();
		ele1.sendKeys(startDate);
		
		WebElement ele2 = driver.findElement(By.xpath("//input[@name='support_end_date']"));
		ele2.clear();
		ele2.sendKeys(endDate);
		
		driver.findElement(By.name("button")).click();
		
		//verify expected result
		
		String headerinformation = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinformation.contains(contactlastName))
		{
			System.out.println(contactlastName+ "is created == PASS");
		}
		else {
			System.out.println(contactlastName+ "is not created == Fail");

		}
		
		String startdateinfo = driver.findElement(By.xpath("//span[@id='dtlview_Support Start Date']")).getText();
		if(startdateinfo.contains(startDate))
		{
			System.out.println(startdateinfo+ "is created == PASS");
		}
		else {
			System.out.println(startdateinfo+ "is not created == Fail");

		}
		
		String enddateinfo = driver.findElement(By.xpath("//span[@id='dtlview_Support End Date']")).getText();
		if(enddateinfo.contains(endDate))
		{
			System.out.println(enddateinfo+ "is created == PASS");
		}
		else {
			System.out.println(enddateinfo+ "is not created == Fail");

		}

		
	

		
		WebElement logouticon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(logouticon).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(5000);
		
		driver.quit();
		
		
		
		
		
	}

}



