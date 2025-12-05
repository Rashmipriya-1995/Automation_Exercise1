package taskpractice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC_RMG_003_Test {
	@Test
	public void ToCreateProject() throws InterruptedException, IOException {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://49.249.28.218:8091/");
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
		
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("RMGProject");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Shibham Panigrahi");
		
		WebElement selectDropdown = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		
		Select sel=new Select(selectDropdown);
		sel.selectByValue("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		

		
		


		
		
		
		

}
}