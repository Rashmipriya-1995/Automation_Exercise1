package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class TC_VerifyTheProject_003_Test {
	@Test
	public void ToCreateProject() throws InterruptedException, IOException, SQLException {
		Connection conn=null;
		String projectName="Zoho_CRM_01";

		
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://49.249.28.218:8091/");
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
		
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
//		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
//		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("RMGProject");
//		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Shibham Panigrahi");
//		
//		WebElement selectDropdown = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
//		
//		Select sel=new Select(selectDropdown);
//		sel.selectByValue("Created");
//		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
//verify the project in DB
		try{boolean flag=false;
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		 conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root@%","root");
		
		Statement stat = conn.createStatement();
		
		ResultSet resultset = stat.executeQuery("select * from project");
		while(resultset.next()) {
			String actProjectName=resultset.getString(4);
			if(projectName.equals(actProjectName))
			{
				flag=true;
				System.out.println(projectName+ " is available in database");
			}
			
		 
//		System.out.println( resultset.getString(1)+"\t" +resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4)+"\t"+resultset.getString(5)+"\t"+resultset.getInt(6));

		}
		
		if(flag==false) {
			System.out.println(projectName+ " is not available in database");
			Assert.fail();
		}
			
		}
		
		catch(Exception e) {
			System.out.println("handle exception");
			
		}
		finally {
		conn.close();
		}
		
		


		
		
		
		

}
}