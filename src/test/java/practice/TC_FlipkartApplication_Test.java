package practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_FlipkartApplication_Test {
	@Test
	public void addedProduct() throws InterruptedException{
		
	WebDriver driver = new ChromeDriver();

		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.flipkart.com/");
		String parentid = driver.getWindowHandle();

		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("kurta");
		
		driver.findElement(By.xpath("(//li[@class='_3D0G9a'])[1]")).click();
		
		Thread.sleep(4000);
	
		driver.findElement(By.xpath("//div[text()='ALIEF COLLECTION']/..")).click();
		
		
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String id:allWindowIds) {
			driver.switchTo().window(id);
			String actURL = driver.getCurrentUrl();
			if(actURL.equals("https://www.flipkart.com/alief-collection-women-kurta-pant-set/"))
				break;
			
		}
		
		driver.switchTo().window(parentid);
		
		
		
		
	}
	
	

}
