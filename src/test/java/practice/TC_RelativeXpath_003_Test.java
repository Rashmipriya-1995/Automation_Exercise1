package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_RelativeXpath_003_Test {
	@Test
	public void toLearnXpathbyUsingAndOR() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.xpath("//a[starts-with(text(),'Log ')]")).click();
		
		driver.findElement(By.xpath("//input[@id='Email' and @name='Email']")).sendKeys("rashmi123@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='Password' or @name='Password']")).sendKeys("Rashmi@123");
		driver.findElement(By.xpath("(//input[@value='Log in' or @type='submit'])[2]")).click();
	}
	

}
