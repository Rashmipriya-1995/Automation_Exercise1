package organizationmodule;
	
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.time.Duration;
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
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.Test;

	public class CreateOrganizationWithTypeTest {
		@Test
		public void creatingOrganization() throws IOException, InterruptedException {
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
			int randomInt = random.nextInt(3000);
			
			//Read data from Excel file
			FileInputStream fis1=new FileInputStream("./Data/TestScriptData1.xlsx");		
			Workbook wb = WorkbookFactory.create(fis1);
			String orgName = wb.getSheet("Organization").getRow(4).getCell(2).toString()+randomInt;
			String indus = wb.getSheet("Organization").getRow(4).getCell(3).toString();
			String type = wb.getSheet("Organization").getRow(4).getCell(4).toString();


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
			
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
			WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
			Select sel1= new Select(industry);
			sel1.selectByVisibleText(indus);
			
			WebElement typein = driver.findElement(By.xpath("//select[@name='accounttype']"));
			Select sel=new Select(typein);
			sel.selectByVisibleText(type);
			driver.findElement(By.name("button")).click();
			
			//verify expected result
			
			String headerinformation = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerinformation.contains(orgName))
			{
				System.out.println(orgName+ "is created == PASS");
			}
			else {
				System.out.println(orgName+ "is not created == Fail");

			}
			
			String industryinfo = driver.findElement(By.xpath("//span[@id='dtlview_Industry']")).getText();
			if(industryinfo.contains(indus))
			{
				System.out.println(indus+ " is created == PASS");
			}
			else {
				System.out.println(indus+ " is not created == Fail");

			}
			
			
			String typeinfo = driver.findElement(By.xpath("//span[@id='dtlview_Type']")).getText();
			if(typeinfo.equals("Partner"))
			{
				System.out.println(typeinfo+ " is created == PASS");
			}
			else {
				System.out.println(typeinfo+ " is not created == Fail");

			}

			
			WebElement logouticon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act=new Actions(driver);
			act.moveToElement(logouticon).perform();
			
			driver.findElement(By.linkText("Sign Out")).click();
			
			Thread.sleep(5000);
			
			driver.quit();
			
			
			
			
		}

	}



